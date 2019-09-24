package com.unittesting.unittesting.business;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;

import java.util.List;

public class ListMockTest {

	List<String> mock = mock(List.class);		
	
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
	
	@Test
	public void returnWithGenericParameters() {
		when(mock.get(anyInt())).thenReturn("texto de prueba").thenReturn("iniciales");
		assertEquals("texto de prueba", mock.get(0));
		assertEquals("iniciales", mock.get(1));
	}
	
	@Test
	public void verificationBasics() {
		
		//SUT
		String value1 = mock.get(0);
		String value2 = mock.get(1);
		
		//Verify  /* se usa para verificar si un metodo se llama sin importar el valor */
		verify(mock).get(0);
		//verify(mock).get(anyInt());				// falla porque se llama 2 veces
		//verify(mock, times(1)).get(anyInt());  // falla porque se llama 2 veces
		verify(mock, times(2)).get(anyInt());
		verify(mock, atLeast(1)).get(anyInt());
		verify(mock, atLeastOnce()).get(anyInt());
		verify(mock, atMost(2)).get(anyInt());
		verify(mock, never()).get(2);
		
	}

}
