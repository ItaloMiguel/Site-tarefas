package com.api.todo.controller;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.api.todo.service.exception.MyObjectNotFoundException;
import com.api.todo.service.exception.StandardError;

@ControllerAdvice
public class ResourceExcptionHandle {

	@ExceptionHandler(MyObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(MyObjectNotFoundException e, ServletRequest request) {
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
