package com.jsp.btm.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TaskNotAssignedException extends RuntimeException {
	private String message;
}
