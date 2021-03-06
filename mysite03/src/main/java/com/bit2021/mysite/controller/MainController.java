package com.bit2021.mysite.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2021.web.util.MVCUtil;

public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int visitCount = 0;
		
		// 쿠키 읽기
		Cookie[] cookies = request.getCookies();
		if(cookies != null && cookies.length > 0) {
			for (Cookie cookie : cookies) {
				String cookieName = cookie.getName();
				if("visitCount".equals(cookieName)) {
					visitCount = Integer.parseInt(cookie.getValue());
				}
			}
		}
		
		// 쿠키 쓰기
		visitCount++;
		Cookie cookie = new Cookie("visitCount", String.valueOf(visitCount));
		cookie.setMaxAge(24*60*60); //1 day
		cookie.setPath(request.getContextPath());
		response.addCookie(cookie);
		
		MVCUtil.forward("main/index", request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
