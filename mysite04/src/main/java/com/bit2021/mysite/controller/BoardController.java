package com.bit2021.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit2021.mysite.security.Auth;
import com.bit2021.mysite.vo.BoardVo;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@RequestMapping("")
	public String list() {
		return "board/list";
	}
	
	@Auth
	@RequestMapping(value="/write", method=RequestMethod.GET)
	public String write() {
		return "board/write";
	}
	
	@RequestMapping(value="/write", method=RequestMethod.POST)
	public String write(BoardVo boardVo) {
		System.out.println(boardVo);
		return "redirect:/board";
	}
}
