package com.bit2021.mysite.dto;

public class JasonResult {
	private String result; // "success" or "fail"
	private Object data; // if success, set data
	private String message; // if fail set message
	
	private JasonResult() {	
	}
	
	public static JasonResult success(Object data) {
		JasonResult jasonResult = new JasonResult();
		jasonResult.result = "success";
		jasonResult.data = data;
		return jasonResult;
	}
	
	public static JasonResult fail(String message) {
		JasonResult jasonResult = new JasonResult();
		jasonResult.result = "fail";
		jasonResult.message = message;
		return jasonResult;
	}

	public String getResult() {
		return result;
	}

	public Object getData() {
		return data;
	}

	public String getMessage() {
		return message;
	}
}
