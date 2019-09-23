package com.unittesting.unittesting.business;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import business.SomeBusinessImpl;
import data.SomeDataService;

public class SomeBusinessMockTest2 {

	@Test
	public void calculateSumUsingSomeDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		SomeDataService dataServiceMock = mock(SomeDataService.class);		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3, 0 });	
		
		business.setSomeDataService(dataServiceMock);
		int actualResult = business.calculateSumUsingSomeDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void calculateSumUsingSomeDataService_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		SomeDataService dataServiceMock = mock(SomeDataService.class);		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { });	
		
		business.setSomeDataService(dataServiceMock);
		int actualResult = business.calculateSumUsingSomeDataService();
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void calculateSumUsingSomeDataService_oneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		SomeDataService dataServiceMock = mock(SomeDataService.class);		
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { -3});	
		
		business.setSomeDataService(dataServiceMock);
		int actualResult = business.calculateSumUsingSomeDataService();
		int expectedResult = -3;
		assertEquals(expectedResult, actualResult);

	}

}
