package com.utils;

import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {
	
	@Test
	public void test_validatInputIndexForReflector() {
		try {
			Validator.validatInputIndexForReflector(-1);
		} catch (Exception exception) {
			Assert.assertTrue(exception instanceof EnigmaImplementationNotSupported);
			Assert.assertEquals(MessageKeys.INPUT_INDEX_NOT_ALLOWED, exception.getMessage());
		}
	}
	
	@Test
	public void test_validatInputIndexForReflector2() {
		try {
			Validator.validatInputIndexForReflector(26);
		} catch (Exception exception) {
			Assert.assertTrue(exception instanceof EnigmaImplementationNotSupported);
			Assert.assertEquals(MessageKeys.INPUT_INDEX_NOT_ALLOWED, exception.getMessage());
		}
	}
	
	@Test
	public void test_validateInputFieldsForRotor_InvalidIndex() {
		try {
			Validator.validateInputFieldsForRotor(-1, FlowDirection.TO_RIGHT);
		} catch (Exception exception) {
			Assert.assertTrue(exception instanceof EnigmaImplementationNotSupported);
			Assert.assertEquals(MessageKeys.INVLID_INPUT_FIELDS_FOR_ADJACENT_CHARACTER, exception.getMessage());
		}
	}
	
	@Test
	public void test_validateInputFieldsForRotor_InvalidIndex2() {
		try {
			Validator.validateInputFieldsForRotor(50, FlowDirection.TO_RIGHT);
		} catch (Exception exception) {
			Assert.assertTrue(exception instanceof EnigmaImplementationNotSupported);
			Assert.assertEquals(MessageKeys.INVLID_INPUT_FIELDS_FOR_ADJACENT_CHARACTER, exception.getMessage());
		}
	}
	
	@Test
	public void test_validateInputFieldsForRotor_InvalidIndex3() {
		try {
			Validator.validateInputFieldsForRotor(50, null);
		} catch (Exception exception) {
			Assert.assertTrue(exception instanceof EnigmaImplementationNotSupported);
			Assert.assertEquals(MessageKeys.INVLID_INPUT_FIELDS_FOR_ADJACENT_CHARACTER, exception.getMessage());
		}
	}
	

}
