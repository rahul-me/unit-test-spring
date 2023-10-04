package com.rcode.unittesting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rcode.unittesting.data.SomeDataService;



class SomeTestUsingMock {
	
	class SomeDataServiceStub implements SomeDataService {

		@Override
		public int[] retriveAllData() {
			return new int[] {1,2,3};
		}
		
	}
	SomeBusinessService service = new SomeBusinessService();
	
	
	@BeforeEach
	public void before() {
		service.setDataService(someDataServiceMock);
	}
	
	SomeDataService stubReturning10 = () -> {
		return new int[] {5,5};
	};
	
	
	SomeDataService someDataServiceMock = mock(SomeDataService.class);

	@Test
	public void testCalculateSum() {
		
		
		when(someDataServiceMock.retriveAllData()).thenReturn(new int[] {1,2,3});
		assertEquals(6, service.calculateSumUsingDataService());
	}
	
	@Test
	public void testCalculateSumUsingDataService() {
		
		when(someDataServiceMock.retriveAllData()).thenReturn(new int[] {5,2,3});
		assertEquals(10, service.calculateSumUsingDataService());
	}

}

