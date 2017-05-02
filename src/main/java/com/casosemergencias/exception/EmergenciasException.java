package com.casosemergencias.exception;

public class EmergenciasException extends Exception {
	private static final long serialVersionUID = 1L;

	private String code;
	private String message;
	
	public EmergenciasException() {
	}

	public EmergenciasException(String code, String message) {
		this.setCode(code);
		this.setMessage(message);
	}
	
	public EmergenciasException(String message) {
		super(message);
	}

	public EmergenciasException(Throwable cause) {
		super(cause);
	}

	public EmergenciasException(String message, Throwable cause) {
		super(message, cause);
	}

	public EmergenciasException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}