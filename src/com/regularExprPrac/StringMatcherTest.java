package com.regularExprPrac;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StringMatcherTest {

	private StringMatcher m;
	
	@Before
	public void setup(){
		m = new StringMatcher();
	}
	
	@Test
    public void testisNoNumberAtBeginning() {
            assertTrue(m.isNoNumberAtBeginning("abc"));
            assertFalse(m.isNoNumberAtBeginning("1abcd"));
            assertTrue(m.isNoNumberAtBeginning("a1bcd"));
            assertTrue(m.isNoNumberAtBeginning("asdfdsf"));
    }

    @Test
    public void testisIntersection() {
            assertTrue(m.isIntersection("1"));
            assertFalse(m.isIntersection("abcksdfkdskfsdfdsf"));
            assertTrue(m.isIntersection("skdskfjsmcnxmvjwque484242"));
    }

    @Test
    public void testLessThenThreeHundred() {
            assertTrue(m.isLessThanThreeHundred("288"));
            assertFalse(m.isLessThanThreeHundred("3288"));
            assertFalse(m.isLessThanThreeHundred("328 8"));
            assertTrue(m.isLessThanThreeHundred("1"));
            assertTrue(m.isLessThanThreeHundred("99"));
            assertFalse(m.isLessThanThreeHundred("300"));
    }
}
