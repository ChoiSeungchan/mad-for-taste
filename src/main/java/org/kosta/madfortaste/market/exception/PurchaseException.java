package org.kosta.madfortaste.market.exception;

public class PurchaseException extends RuntimeException{

	public PurchaseException() {
		super();
	}

	public PurchaseException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public PurchaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public PurchaseException(String message) {
		super(message);
	}

	public PurchaseException(Throwable cause) {
		super(cause);
	}
	
}
