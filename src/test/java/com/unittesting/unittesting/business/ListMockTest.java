package com.unittesting.unittesting.business;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

public class ListMockTest {

	List mock = mock(List.class);		
	
	@Test
	public void size_basic() {
		when(mock.size()).thenReturn(5);
		assertEquals(5, mock.size());
	}
	
	@Test
	public void returnDifferentValues() {
		when(mock.size()).thenReturn(5).thenReturn(10);
		assertEquals(5, mock.size());
		assertEquals(10, mock.size());
	}
	
	@Test
	public void returnWithParamiters() {
		when(mock.get(0)).thenReturn("texto de prueba");
		assertEquals("texto de prueba", mock.get(0));
		assertEquals(null, mock.get(1));		// este test pasa porque retorna el valor por defecto que es null
	}

}
