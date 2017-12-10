package com.implementation;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.implementation.Engine;
import com.implementation.Rotor;
import com.utils.EnigmaConstants;

public class EngineTest {

	Engine engine;
	
	@Before
	public void setUp() {
		engine = new Engine();
	}
	
	@Test
	public void test_RotorOne() {
		
		Rotor rotor = engine.initializeRotorOne();

		Assert.assertEquals("KX" ,rotor.getCodes().get(0));
		Assert.assertEquals("JT" ,rotor.getCodes().get(25));
		Assert.assertEquals(22, rotor.getNotchPosition());
	}
	
	@Test
	public void test_RotorTwo() {
		
		Rotor rotor = engine.initializeRotorTwo();
		Assert.assertEquals("CD" ,rotor.getCodes().get(0));
		Assert.assertEquals("BJ" ,rotor.getCodes().get(25));
		Assert.assertEquals(5, rotor.getNotchPosition());
	}
	
	@Test
	public void test_RotorThree() {
		
		Rotor rotor = engine.initializeRotorThree();
		Assert.assertEquals("MO" ,rotor.getCodes().get(0));
		Assert.assertEquals("LT" ,rotor.getCodes().get(25));
		Assert.assertEquals(17, rotor.getNotchPosition());
	}
	
	@Test
	public void test_ShiftRotor() {
		
		Rotor rotor = engine.initializeRotorOne();
		int initialPosition = rotor.getNotchPosition();
		rotor = engine.shiftRotorUp(rotor);
		Assert.assertEquals(initialPosition -1, rotor.getNotchPosition());
		
	}
	
	@Test
	public void test_shiftRotorNotchToLastPosition() {
		
		Rotor rotor = engine.initializeRotorOne();
		rotor.setNotchPosition(1);
		rotor = engine.shiftRotorUp(rotor);
		Assert.assertEquals(EnigmaConstants.LAST_NOTCH_POSITION, rotor.getNotchPosition());
		
	}
}

