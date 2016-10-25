package com.regularExprPrac;


import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



public class REPracTest {

	/**
	 * A phone number in this example consists either out of 7 numbers in a row or out of 3 number, 
	 * a (white)space or a dash and then 4 numbers.
	 * @author 212331901
	 *
	 */
	@Test 
	public void checkSevenPhoneNumber(){
		String pattern = "[0-9]{3}(\\s|-)?[\\d]{4}";
		String s1 = "1233323";
        assertTrue(s1.matches(pattern));
        String s2 = "123 3323";
        assertTrue(s2.matches(pattern));
        String s3 = "123-3323";
        assertTrue(s3.matches(pattern));
		String s4 = "12333238";
        assertFalse(s4.matches(pattern));
	}
	
	/**
	 * 
	 */
}
