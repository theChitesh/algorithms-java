package com.implementation.test;
import org.junit.Assert;
import org.junit.Test;

import com.exception.EnigmaImplementationNotSupported;
import com.implementation.Reflector;

public class ReflectorTest {
	

	
	@Test
	public void testForA() throws EnigmaImplementationNotSupported {
		
		Reflector reflector = new Reflector();
		int i = reflector.getCharAtIndexFromRotor(0);
		Assert.assertEquals(24, i);
		
	}
	
	@Test
	public void testForB() throws EnigmaImplementationNotSupported {
		
		Reflector reflector = new Reflector();
		int i = reflector.getCharAtIndexFromRotor(1);
		Assert.assertEquals(17, i);
		
	}
	
	@Test
	public void testForC() throws EnigmaImplementationNotSupported {
		
		Reflector reflector = new Reflector();
		int i = reflector.getCharAtIndexFromRotor(2);
		Assert.assertEquals(20, i);
		
	}
	
	@Test
	public void testForD() throws EnigmaImplementationNotSupported {
		
		Reflector reflector = new Reflector();
		int i = reflector.getCharAtIndexFromRotor(3);
		Assert.assertEquals(7, i);
		
	}
	
	@Test
	public void testForJ() throws EnigmaImplementationNotSupported {
		
		Reflector reflector = new Reflector();
		int i = reflector.getCharAtIndexFromRotor(9);

		Assert.assertEquals(23, i);
		
	}
	
}
