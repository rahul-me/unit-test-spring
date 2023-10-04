package com.rcode.unittesting.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.rcode.unittesting.data.SomeDataService;


@ExtendWith(MockitoExtension.class)
class SomeTestUsingMockWithAnnotations {
	
	class SomeDataServiceStub implements SomeDataService {

		@Override
		public int[] retriveAllData() {
			return new int[] {1,2,3};
		}
		
	}
	
//	@InjectMocks
//	SomeBusinessService service = new SomeBusinessService();
	
	@InjectMocks
	SomeBusinessService service;
	
	@Mock
	SomeDataService someDataServiceMock;
	
//	@BeforeEach
//	public void before() {
//		service.setDataService(someDataServiceMock);
//	}
	
	SomeDataService stubReturning10 = () -> {
		return new int[] {5,5};
	};
	
	

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

