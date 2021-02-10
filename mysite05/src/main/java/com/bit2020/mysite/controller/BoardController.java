package com.bit2020.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit2020.mysite.security.Auth;

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
	
}
