package com.clickncash.model;

import java.util.ArrayList;
import java.util.List;

public class Response<T> {

	private List<String> errors = new ArrayList<>();
	private List<String> messages = new ArrayList<>();
	private T payload;

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}
}