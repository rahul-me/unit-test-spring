package com.rcode.unittesting.service;

import com.rcode.unittesting.data.SomeDataService;

public class SomeBusinessService {
	
	private SomeDataService dataService;
	
	public void setDataService(SomeDataService dataService) {
		this.dataService = dataService;
	}

	public int calculateSum(int[] arr) {
		int sum = 0;
		
		for(int a: arr) {
			sum += a;
		}
//		System.out.println(sum);
		return sum;
	}
	
	public int calculateSumUsingDataService() {
		
		int[] arr = dataService.retriveAllData();
		int sum = 0;
		
		for(int a: arr) {
			sum += a;
		}
//		System.out.println(sum);
		return sum;
	}
	
	
}



