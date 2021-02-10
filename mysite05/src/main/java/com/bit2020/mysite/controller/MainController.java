package com.bit2020.mysite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2020.mysite.vo.GuestbookVo;

@Controller
public class MainController {

	@RequestMapping("")
	public String index() {
		return "main/index";
	}
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return "안녕하세요~";
	}
	
	@ResponseBody
	@RequestMapping("/json")
	public Object json() {
		GuestbookVo vo = new GuestbookVo();
		vo.setNo(10L);
		vo.setName("안대혁");
		vo.setMessage("안녕하세요~");
		
		return vo;
	}
	
}