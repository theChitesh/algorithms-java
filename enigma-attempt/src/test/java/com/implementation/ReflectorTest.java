package com.implementation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.implementation.Reflector;
import com.utils.EnigmaImplementationNotSupported;
import com.utils.MessageKeys;

public class ReflectorTest {
	
	
	Reflector reflector;
	
	@Before
	public void setUp() {
		reflector = new Reflector();
	}
	
	@Test
	public void testForA() throws EnigmaImplementationNotSupported {
		
		int i = reflector.getCharAtIndexFromRotor(0);
		Assert.assertEquals(24, i);
		
	}
	
	@Test
	public void testForB() throws EnigmaImplementationNotSupported {
		
		int i = reflector.getCharAtIndexFromRotor(1);
		Assert.assertEquals(17, i);
		
	}
	
	@Test
	public void testForC() throws EnigmaImplementationNotSupported {
		
		int i = reflector.getCharAtIndexFromRotor(2);
		Assert.assertEquals(20, i);
		
	}
	
	@Test
	public void testForD() throws EnigmaImplementationNotSupported {
		
		int i = reflector.getCharAtIndexFromRotor(3);
		Assert.assertEquals(7, i);
		
	}
	
	@Test
	public void testForJ() throws EnigmaImplementationNotSupported {
		
		int i = reflector.getCharAtIndexFromRotor(9);
		Assert.assertEquals(23, i);
		
	}
	
	@Test
	public void testInvalidIndex() {
		
		try {
			reflector.getCharAtIndexFromRotor(26);
		} catch (Exception exception) {
			
			Assert.assertTrue(exception instanceof EnigmaImplementationNotSupported);
			Assert.assertEquals(MessageKeys.INPUT_INDEX_NOT_ALLOWED	, exception.getMessage());
		}
		
		
	}
}
