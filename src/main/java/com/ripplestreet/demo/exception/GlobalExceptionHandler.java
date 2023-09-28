package com.ripplestreet.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=EmployeeNotFoundException.class)
	
	public ResponseEntity<ApiError> handleEmployeeNotFoundException(EmployeeNotFoundException ex){
		
		ApiError errorMessage=new ApiError(404,"No Employee Found",new Date());
		return new ResponseEntity<ApiError>(errorMessage,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=EmployeeAlreadyExistException.class)
	public ResponseEntity<ApiError> handleEmployeeAlreadyExistException(EmployeeAlreadyExistException ex){
		ApiError error=new ApiError(404,"Employee Record Exists!!",new Date());
		return new ResponseEntity<ApiError>(error,HttpStatus.BAD_REQUEST);
	}

}
