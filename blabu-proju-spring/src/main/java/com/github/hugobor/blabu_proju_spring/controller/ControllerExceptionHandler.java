package com.github.hugobor.blabu_proju_spring.controller;

import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ControllerExceptionHandler {
	
	private final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);
	
	
	private ResponseEntity<String> handleException(Exception exc, HttpStatus status) {
		return new ResponseEntity<>(exc.getLocalizedMessage(), status);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgument(RuntimeException exc) {
		return handleException(exc, HttpStatus.UNPROCESSABLE_ENTITY); 
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElement(RuntimeException exc) {
		return handleException(exc, HttpStatus.NOT_FOUND); 
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleRuntime(RuntimeException exc) {
		logger.error(exc.getLocalizedMessage());
		return handleException(exc, HttpStatus.INTERNAL_SERVER_ERROR); 
	}


}
