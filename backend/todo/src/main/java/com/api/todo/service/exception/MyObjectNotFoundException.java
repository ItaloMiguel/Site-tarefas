package com.api.todo.service.exception;

public class MyObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MyObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyObjectNotFoundException(String message) {
		super(message);
	}
	
}
