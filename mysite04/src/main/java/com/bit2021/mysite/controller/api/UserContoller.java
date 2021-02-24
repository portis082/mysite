package com.bit2021.mysite.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2021.mysite.dto.JasonResult;
import com.bit2021.mysite.service.UserService;

@Controller("userAPIContoller")
@RequestMapping("api/user")
public class UserContoller {
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping("checkemail")
	public JasonResult checkEmail(@RequestParam(value="email", required=true, defaultValue="") String email) {
		boolean exist = userService.existUser(email);
		return JasonResult.success(exist);
	}
}
