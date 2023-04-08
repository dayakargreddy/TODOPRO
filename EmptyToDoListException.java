package com.todo.project;

public class EmptyToDoListException extends Exception{
	private String message;

	public EmptyToDoListException(String message) {
		super();
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}

}
