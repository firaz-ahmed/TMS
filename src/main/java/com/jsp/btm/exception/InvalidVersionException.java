package com.jsp.btm.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class InvalidVersionException extends RuntimeException {
	private String message;
}
