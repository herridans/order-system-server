package com.sean.oss.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@ControllerAdvice
public class ExceptionHandlers {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handle(Exception e, HttpServletRequest request, HttpServletResponse response)
	{
		return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
	}
}
