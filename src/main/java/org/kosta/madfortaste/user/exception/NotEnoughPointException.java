package org.kosta.madfortaste.user.exception;

public class NotEnoughPointException extends RuntimeException {

	public NotEnoughPointException() {
		super();
	}

	public NotEnoughPointException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NotEnoughPointException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotEnoughPointException(String message) {
		super(message);
	}

	public NotEnoughPointException(Throwable cause) {
		super(cause);
	}
	
	

}
