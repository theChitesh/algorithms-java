package com.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.implementation.Rotor;
import com.utils.EnigmaImplementationNotSupported;
import com.utils.FlowDirection;
import com.utils.MessageKeys;

public class RotorTest {
	
	
	private Rotor rotor;
	
	@Before
	public void setUp() {
		
        int notchPosition = 22;
        String[] charCodes = {"KX", "LV", "MZ", "NN", "OY", "PE", "QI", "RW", "SG", "TA", "UK", "VM",
                "WU", "XS", "YQ", "ZO", "AB", "BD", "CF", "DH", "EJ", "FL", "GC", "HP", "IR", "JT"};
        
        List<String> codes = new ArrayList<>(charCodes.length);
        Collections.addAll(codes,charCodes);
        
        rotor = new Rotor(codes, notchPosition);
	}
	
	@Test
	public void test_getIndexOfAdjacentLetter_fromLeft_ForE() throws Exception {
		
		int index = rotor.getIndexAdjacentLetter(4, 
				FlowDirection.TO_LEFT);
		Assert.assertEquals(14, index);
	}
	
	@Test
	public void test_getIndexOfAdjacentLetter_fromLeft_ForQ() throws Exception {
		
		int index = rotor.getIndexAdjacentLetter(16, 
				FlowDirection.TO_LEFT);
		Assert.assertEquals(17, index);
	}

	@Test
	public void test_getIndexOfAdjacentLetter_fromRight() throws Exception {
		
		int index = rotor.getIndexAdjacentLetter(14, 
				FlowDirection.TO_RIGHT);
		Assert.assertEquals(4, index);
	}
	
	@Test
	public void test_getIndexOfAdjacentLetter_DirectionNull() {
		try {
			rotor.getIndexAdjacentLetter(1, null);
		} catch (Exception exception) {
			Assert.assertTrue(exception instanceof EnigmaImplementationNotSupported);
			Assert.assertEquals(exception.getMessage(), MessageKeys.INVLID_INPUT_FIELDS_FOR_ADJACENT_CHARACTER);
		}
	}
	
	@Test
	public void test_getIndexOfAdjacentLetter_IndexNotValid() {
		
		try {
			rotor.getIndexAdjacentLetter(-1, FlowDirection.TO_RIGHT);
		} catch (Exception exception) {
			Assert.assertTrue(exception instanceof EnigmaImplementationNotSupported);
			Assert.assertEquals(exception.getMessage(), MessageKeys.INVLID_INPUT_FIELDS_FOR_ADJACENT_CHARACTER);
		}
		
	}
	
	@Test
	public void test_EgetIndexOfAdjacentLetter_InvalidInput() {
		
		try {
			rotor.getIndexAdjacentLetter(26, FlowDirection.TO_RIGHT);
		} catch (Exception exception) {
			Assert.assertTrue(exception instanceof EnigmaImplementationNotSupported);
			Assert.assertEquals(exception.getMessage(), MessageKeys.INVLID_INPUT_FIELDS_FOR_ADJACENT_CHARACTER);
		}
		
	}


}
