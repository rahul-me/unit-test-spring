package com.rcode.unittesting.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeTest {

	@Test
	public void testCalculateSum() {
		SomeBusinessService service = new SomeBusinessService();
		int[] arr = new int[] {3,1,5,6,7};
		int sum = service.calculateSum(arr);
		int expectedresult = 22;
		
		assertEquals(expectedresult, sum);
	}

}
