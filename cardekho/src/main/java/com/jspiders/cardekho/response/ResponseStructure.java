package com.jspiders.cardekho.response;

import lombok.Data;

@Data
public class ResponseStructure<T> {
	private String message;
	private T data;
	private int status;
}
