package com.unittesting.unittesting.business;

import static org.junit.Assert.*;

import org.junit.Test;

import business.SomeBusinessImpl;
import data.SomeDataService;

class SomeDataServiceStub implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] { 1, 2, 3, 0 };
	}

}

class SomeDataServiceStubNull implements SomeDataService {
	@Override
	public int[] retrieveAllData() {
		return new int[] {};
	}
}

class SomeDataServiceStubOneValue implements SomeDataService {

	@Override
	public int[] retrieveAllData() {
		return new int[] { -3 };
	}
}

public class SomeBusinessStubTest {

	@Test
	public void calculateSumUsingSomeDataService_basic() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStub());
		int actualResult = business.calculateSumUsingSomeDataService();
		int expectedResult = 6;
		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void calculateSumUsingSomeDataService_empty() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStubNull());
		int actualResult = business.calculateSum(new int[] {});
		int expectedResult = 0;
		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void calculateSumUsingSomeDataService_oneValue() {
		SomeBusinessImpl business = new SomeBusinessImpl();
		business.setSomeDataService(new SomeDataServiceStubOneValue());
		int actualResult = business.calculateSum(new int[] { 7 });
		int expectedResult = 7;
		assertEquals(expectedResult, actualResult);

	}

}
