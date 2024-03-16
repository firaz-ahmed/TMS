package com.jsp.btm.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UnAuthorisedUserException extends RuntimeException{
	private String message;
}
