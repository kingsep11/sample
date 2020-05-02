package com.example.exdemo;

public class CustomException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
