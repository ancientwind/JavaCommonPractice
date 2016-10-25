package com.enumTest;

import static org.junit.Assert.*;

import org.junit.Test;

public class EnumsTest {

	@Test
	public void testColor() {
		COLOR red = COLOR.RED;
		assertEquals(255, red.getRedValue());
	}

}
