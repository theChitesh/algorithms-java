package com.exception;

/**
 * Custom Exception define when Engima Engine fails to identify the lookup character element
 * @author chitesh
 *
 */
public class EnigmaImplementationNotSupported extends Exception{
	
	public EnigmaImplementationNotSupported(String message) {
		super(message);
	}

}
