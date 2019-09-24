package com.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import business.SomeBusinessImpl;
import data.SomeDataService;

public class SomeBusinessMockTest2 {
	
	SomeBusinessImpl business = new SomeBusinessImpl();
	SomeDataService dataServiceMock = mock(SomeDataService.class);		
	
	@Before
	public void beforeTest() {
		business.setSomeDataService(dataServiceMock);
	}
	

	@Test
	public void calculateSumUsingSomeDataService_basic() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 1, 2, 3, 0 });			
		assertEquals(6, business.calculateSumUsingSomeDataService());

	}

	@Test
	public void calculateSumUsingSomeDataService_empty() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { });			
		assertEquals(0, business.calculateSumUsingSomeDataService());

	}

	@Test
	public void calculateSumUsingSomeDataService_oneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { -3});			
		assertEquals(-3, business.calculateSumUsingSomeDataService());

	}

}
