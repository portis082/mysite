package com.bit2021.mysite.exception;

public class UserRepositoryException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public UserRepositoryException() {
		super("UserRepositoryException");
	}
	
	public UserRepositoryException(String message) {
		super(message);
	}
}
