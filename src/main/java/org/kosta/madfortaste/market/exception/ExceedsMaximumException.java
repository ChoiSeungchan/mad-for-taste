package org.kosta.madfortaste.market.exception;

public class ExceedsMaximumException extends RuntimeException{
	public ExceedsMaximumException(String message){
		super(message);
	}
}
