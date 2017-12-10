package com.utils;

/**
 * Validator class used to validate input fields
 * @author chitesh
 *
 */
public class Validator {
	
	
	public static void validatInputIndexForReflector(int index) throws EnigmaImplementationNotSupported {
		
		if(index < 0 || index > 25) {
			throw new EnigmaImplementationNotSupported(MessageKeys.INPUT_INDEX_NOT_ALLOWED);
		}
	}

	
	/**
	 * Method validates the input fields for Rotor method which returns index of adjacent characer
	 * @param positionOfElement - position of current character
	 * @param direction - direction in which the lookup has to continue
	 * @throws EnigmaImplementationNotSupported - custom exception
	 */
	public static void validateInputFieldsForRotor(int positionOfElement, FlowDirection direction) throws EnigmaImplementationNotSupported {
		
		if(positionOfElement < 0 || positionOfElement > 25 || direction == null) {
        	throw new EnigmaImplementationNotSupported(MessageKeys.INVLID_INPUT_FIELDS_FOR_ADJACENT_CHARACTER);
        }
	}
}
