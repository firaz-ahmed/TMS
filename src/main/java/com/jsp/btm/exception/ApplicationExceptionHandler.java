package com.jsp.btm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jsp.btm.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(UnAuthorisedUserException.class)
	public ResponseEntity<ResponseStructure<String>> handleUnAuthorisedException(UnAuthorisedUserException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage("UnAuthorised User");
		responseStructure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleUserNotFoundException(UserNotFoundException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("User Not Found");
		responseStructure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(TaskNotAssignedException.class)
	public ResponseEntity<ResponseStructure<String>> handleTaskNotAssignedException(TaskNotAssignedException exception){
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage("Task not assigned");
		responseStructure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TaskNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handleTaskNotFoundException(TaskNotFoundException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Task Not Found");
		responseStructure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidVersionException.class)
	public ResponseEntity<ResponseStructure<String>> handleInvalidVersionException(InvalidVersionException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatusCode(HttpStatus.BAD_REQUEST.value());
		responseStructure.setMessage("Invalid version");
		responseStructure.setData(exception.getMessage());
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.BAD_REQUEST);
	}
}
