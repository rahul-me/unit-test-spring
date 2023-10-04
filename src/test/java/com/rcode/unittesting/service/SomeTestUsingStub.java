package com.rcode.unittesting.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.rcode.unittesting.data.SomeDataService;

class SomeDataServiceStub implements SomeDataService {

	@Override
	public int[] retriveAllData() {
		return new int[] {1,2,3};
	}
	
}

class SomeTestUsingStub {
	
	
	SomeDataService stubReturning10 = () -> {
		return new int[] {5,5};
	};

	@Test
	public void testCalculateSum() {
		SomeBusinessService service = new SomeBusinessService();
		
		service.setDataService(new SomeDataServiceStub());
		int sum = service.calculateSumUsingDataService();
		int expectedresult = 6;
		
		assertEquals(expectedresult, sum);
	}
	
	@Test
	public void testCalculateSumUsingDataService() {
		SomeBusinessService service = new SomeBusinessService();
		
		service.setDataService(stubReturning10);
		int sum = service.calculateSumUsingDataService();
		int expectedresult = 10;
		
		assertEquals(expectedresult, sum);
	}

}

