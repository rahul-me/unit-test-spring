package com.rcode.unittesting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SomeBusinessServiceUsingSpringBootTestAnnotationTest {
	
	@Test
	public void testCalculateSum() {
		SomeBusinessService service = new SomeBusinessService();
		int[] arr = new int[] {3,1,5,6,7};
		int sum = service.calculateSum(arr);
		int expectedresult = 22;
		
		assertEquals(expectedresult, sum);
	}
}
