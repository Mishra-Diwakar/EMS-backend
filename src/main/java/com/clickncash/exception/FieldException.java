package com.clickncash.exception;

public class FieldException extends Exception {

	private static final long serialVersionUID = -6398451184283159693L;

	public FieldException() {
		super();
	}

	public FieldException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FieldException(String message, Throwable cause) {
		super(message, cause);
	}

	public FieldException(String message) {
		super(message);
	}

	public FieldException(Throwable cause) {
		super(cause);
	}
}
