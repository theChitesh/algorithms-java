package com.implementation.test;

import org.junit.Assert;
import org.junit.Test;

import com.implementation.EnigmaRunner;

public class EnigmaRunnerTest {

	@Test
	public void test_decoding() {
		
		EnigmaRunner runner = new EnigmaRunner();
		String encodedValue = "QMJIDO";
		String decodedValue = runner.decode(encodedValue.toCharArray());
		Assert.assertEquals("ENIGMA", decodedValue);
	}
}
