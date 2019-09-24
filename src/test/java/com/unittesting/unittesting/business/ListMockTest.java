package com.unittesting.unittesting.business;


import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;

import java.util.ArrayList;
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
		
		//SUT: system under test
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
		verify(mock, never()).get(2);		// verifica si nunca se llamo con este argumento
		
	}
	
	@Test
	public void argumentCapturing() {
		
		//SUT: system under test
		mock.add("SomeString");
		
		//Verification /* captura el parametro especifico que se pasa a un metodo */ 
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
		verify(mock).add(captor.capture());
		
		assertEquals("SomeString", captor.getValue());
		
	}

	@Test
	public void multipleArgumentCapturing() {
		
		//SUT: system under test
		mock.add("SomeString1");
		mock.add("SomeString2");
		
		//Verification /* captura el parametro especifico que se pasa a un metodo */ 
		ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
//		verify(mock).add(captor.capture());  // si se usa asi falla porque verifica que se llama una vez por default
		verify(mock, times(2)).add(captor.capture());
		
		List<String> allValues = captor.getAllValues();
		assertEquals("SomeString1", allValues.get(0));
		assertEquals("SomeString2", allValues.get(1));
		
	}
	
	@Test
	public void noRealSpaying() {
		ArrayList<String> arrayListMock = mock(ArrayList.class);
		System.out.println(arrayListMock.get(0)); // se obtiene null
		System.out.println(arrayListMock.size()); // se obtine 0
		System.out.println(arrayListMock.add("Test1")); // en consola es falso
		System.out.println(arrayListMock.add("Test2")); // en consola es falso
		System.out.println(arrayListMock.size()); // se obtiene 0 porque es mock
		
		when(arrayListMock.size()).thenReturn(5);
		System.out.println(arrayListMock.size()); // ya retorna 5 por la linea de arriba
		
	}
	
	@Test
	public void spaying() {
		ArrayList<String> arrayListSpy = spy(ArrayList.class);
		arrayListSpy.add(0, "Test0");
		
		System.out.println(arrayListSpy.get(0)); // Test0
		System.out.println(arrayListSpy.size()); // 1
		System.out.println(arrayListSpy.add("Test1")); //true 
		System.out.println(arrayListSpy.add("Test2")); //true 
		System.out.println(arrayListSpy.size()); // 3
		
		when(arrayListSpy.size()).thenReturn(5); 
		System.out.println(arrayListSpy.size()); // 5
		
		arrayListSpy.add("Test4");
		System.out.println(arrayListSpy.size()); // 5
		
		verify(arrayListSpy).add("Test4");
		
		
		
	}
	
}
