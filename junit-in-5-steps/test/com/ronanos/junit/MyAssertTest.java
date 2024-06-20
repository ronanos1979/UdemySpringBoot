package com.ronanos.junit;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyAssertTest {

	List <String> todos = Arrays.asList("AWS", "Azure", "DevOps");

	@Test
	void test() {
		boolean test = todos.contains("AWS");
		boolean test2 = todos.contains("GCP");

		assertEquals(true, test);
		assertEquals(3, todos.size());
		assertTrue("Something went wrong", test);
		assertEquals(false, test2);
		assertTrue(test);
		assertFalse(test2);
		assertArrayEquals(new int[] {1,2}, new int [] {1, 2});
	}

}
