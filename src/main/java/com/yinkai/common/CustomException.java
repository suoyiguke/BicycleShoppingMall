package com.yinkai.common;
import java.io.Serializable;

public class CustomException extends Exception implements Serializable{

	public String message;
	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CustomException(String message) {
		this.message = message;
	}
}
