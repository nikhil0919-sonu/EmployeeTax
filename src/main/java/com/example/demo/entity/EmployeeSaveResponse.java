package com.example.demo.entity;

import org.springframework.stereotype.Component;

@Component
public class EmployeeSaveResponse {
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
