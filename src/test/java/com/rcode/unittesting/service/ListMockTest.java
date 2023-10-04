package com.rcode.unittesting.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ListMockTest {
	
	List<String> mock = mock(List.class);
	
	@BeforeEach
	void before() {
		
		
	}
	

	@Test
	void test() {
		
		when(mock.get(0)).thenReturn("rahul");
		
		assertEquals(mock.get(0), "rahul");
		
		when(mock.size()).thenReturn(5).thenReturn(10);
		
		
		assertEquals(mock.size(), 5);
		assertEquals(mock.size(), 10);
	}
	
	@Test
	void withParameter() {
		when(mock.get(0)).thenReturn("rahul");
		assertEquals(mock.get(1), null);
		
	}
	@Test
	void withGenericParameter() {
		when(mock.get(anyInt())).thenReturn("rahul");
		assertEquals(mock.get(1), "rahul");
		assertEquals(mock.get(2), "rahul");
		
	}
	
	@Test
	void verificationBasics() {
		mock.get(0);
		mock.get(0);
		verify(mock, atLeast(1)).get(0);
		
		verify(mock, times(2)).get(0);
		
	}
	
	@Test
	void argumentCapture() {
		mock.add("rahul");
		
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		
		verify(mock).add(captor.capture());
		
		assertEquals("rahul", captor.getValue());
	}
	
	
	@Test
	void spying() {
		@SuppressWarnings("rawtypes")
		ArrayList<String> list = mock(ArrayList.class);
		
		when(list.size()).thenReturn(5);
		when(list.get(anyInt())).thenReturn("test");
		System.out.println(list.size());
		System.out.println(list.get(0));
	}
	

}