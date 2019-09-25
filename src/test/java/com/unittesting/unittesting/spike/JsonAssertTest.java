package com.unittesting.unittesting.spike;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {
	
	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
	
	@Test
	public void jsonAssert_StrictTrue_ExactMatchExceptForSpaces() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":  10,\"quantity\":  100}";
		
		JSONAssert.assertEquals(expectedResponse, actualResponse, true);
		
		// true: hace una comparacion del contenido de los json y debe ser igual aunque pueden haber espacios

	}
	
	@Test
	public void jsonAssert_StrictFalse_ExceptForSpaces() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":  10}";
		
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
		
		// false: los espacios no influyes, y se pueden omitir campos

	}
	
	@Test
	public void jsonAssert_WithoutEscapeCharacters() throws JSONException {
		String expectedResponse = "{id:1, name:Ball, price:  10}";
		
		JSONAssert.assertEquals(expectedResponse, actualResponse, false);
		
		// false: sin caracteres de escape, solo se usan si hay espacio es algun nombre 
		// del key o del value ejemplo  \"name\":\"Ball de billar\"

	}

}
