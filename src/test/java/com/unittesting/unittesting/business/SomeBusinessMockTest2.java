package com.unittesting.unittesting.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import business.SomeBusinessImpl;
import data.SomeDataService;

@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockTest2 {
	
	// esto se puede mejorar con @InjectMocks y @Mock
	// luego no haria falta hacer uso del @Before en este caso
	// Mockito hace la instancia de lo que se inyecta
	/*
	SomeBusinessImpl business = new SomeBusinessImpl();
	SomeDataService dataServiceMock = mock(SomeDataService.class);		
	
	@Before
	public void beforeTest() {
		business.setSomeDataService(dataServiceMock);
	}*/	
	
	@InjectMocks
	SomeBusinessImpl business;  // no se crea la instancia, solo de declara
	
	@Mock
	SomeDataService dataServiceMock;

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
