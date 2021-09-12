package com.emp.config;

import java.io.Console;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.emp.controller.EmployeeCrudController;

@ControllerAdvice
public class GlobalExceptionHandler {

	static final Logger log = 
	        LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value = Exception.class)
    public ResponseEntity databaseConnectionFailsException(Exception exception) {
		log.error(exception.getMessage()+" -- ERROR CODE --" + HttpStatus.INTERNAL_SERVER_ERROR+"");
        return new ResponseEntity<>("AC", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
