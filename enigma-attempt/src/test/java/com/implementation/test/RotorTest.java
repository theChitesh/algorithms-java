package com.implementation.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.implementation.Rotor;

public class RotorTest {
	
	
	Rotor rotor;
	
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
				"toLeft");
		Assert.assertEquals(14, index);
	}
	
	@Test
	public void test_getIndexOfAdjacentLetter_fromLeft_ForQ() throws Exception {
		
		int index = rotor.getIndexAdjacentLetter(16, 
				"toLeft");
		Assert.assertEquals(17, index);
	}

	@Test
	public void test_getIndexOfAdjacentLetter_fromRight() throws Exception {
		
		int index = rotor.getIndexAdjacentLetter(14, 
				"toRight");
		Assert.assertEquals(4, index);
	}

}
