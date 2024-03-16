package com.jsp.btm.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class TaskNotFoundException extends RuntimeException{
	private String message;
}
