package com.kang.spring.exception;

public class UserAcountException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAcountException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAcountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserAcountException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserAcountException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserAcountException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
