package com.implementation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.implementation.EnigmaRunner;
import com.implementation.Rotor;
import com.utils.EnigmaImplementationNotSupported;
import com.utils.MessageKeys;

public class EnigmaRunnerTest {

	private EnigmaRunner runner;
	
	@Before
	public void setUp() {
		runner = new EnigmaRunner();
	}
	
	@Test
	public void test_decoding() throws EnigmaImplementationNotSupported {
		
		String encodedValue = "QMJIDO";
		String decodedValue = runner.decode(encodedValue.toCharArray());
		Assert.assertEquals("ENIGMA", decodedValue);
	}
	
	@Test
	public void test_EnigmaExcpetion() {

		String encodedValue = "12";
		String decodedValue;
		try {
			decodedValue = runner.decode(encodedValue.toCharArray());
			Assert.assertEquals("ENIGMA", decodedValue);
		} catch (Exception enigmaException) {
			Assert.assertTrue(enigmaException instanceof EnigmaImplementationNotSupported);
			Assert.assertEquals(MessageKeys.INPUT_CHARACTER_NOT_SUPPORTED, enigmaException.getMessage());
		}
	}
	
	
	
	@Test
	public void test_adjustRotors() throws EnigmaImplementationNotSupported {
	
		
		String input = "QMJIDO";
		Rotor one = runner.getRotorOne();
		
		int initialNotchPosition = one.getNotchPosition();
		int expectedNotchPositon = initialNotchPosition - input.toCharArray().length;
		runner.decode(input.toCharArray());
		Assert.assertEquals(expectedNotchPositon, one.getNotchPosition());
		
	}
	
	
	
	
}
