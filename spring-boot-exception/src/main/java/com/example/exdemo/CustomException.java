package com.example.exdemo;

import org.springframework.stereotype.Component;

public class CustomException extends Exception {

	private String messages;
	
	
	
	public String getMessages() {
		return messages;
	}



	public void setMessages(String messages) {
		this.messages = messages;
	}



	public CustomException(String message) {
		this.messages =message;
	}
}
