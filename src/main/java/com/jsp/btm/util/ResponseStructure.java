package com.jsp.btm.util;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResponseStructure<T> {
	private int statusCode;
	private String message;
	private T data;
}
