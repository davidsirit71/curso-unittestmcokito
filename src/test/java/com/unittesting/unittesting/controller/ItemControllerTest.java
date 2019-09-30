package com.unittesting.unittesting.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.unittesting.unittesting.business.ItemBusinessService;
import com.unittesting.unittesting.model.Item;


@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ItemBusinessService businessService; 
	
	@Test
	public void dummyItem_basic() throws Exception {
		// Que hacer:
		
		// call GET route "/dummy-item"  application/json y luego 
		RequestBuilder request = MockMvcRequestBuilders
				.get("/dummy-item")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())		// se puede utilizar status().is(200)
				//.andExpect(content().string("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}")) // si se usa string la comparacion es exacta
				.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}")) // con json pueden haber algunos espacios 
				.andReturn();																			 // incluso se pueden omitir algunas propiedades
		
//		JSONAssert.assertEquals(expected, actual, strict);  // viene de entrar dentro de .json
		
		// verify la respueata es "Hello World" , no es necesrio el assert porque 
		// la respuesta es muy simple sy se hace arriba
//		assertEquals("Hello World", result.getResponse().getContentAsString());
		
		
	}
	
	@Test
	public void itemFromBussinessService_basic() throws Exception {
		when(businessService.retrieveHardcodedItem()).thenReturn(new Item(2, "Item2", 10, 10)); // esto es proque no interesa 
																							    // la logica de servico en este test
		RequestBuilder request = MockMvcRequestBuilders
				.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())		
				.andExpect(content().json("{id: 2, name: Item2, price: 10}")) 
				.andReturn();
		
	}
	
	@Test
	public void retirveAllItems_basic() throws Exception {
		when(businessService.retriveAllItems()).thenReturn(
				Arrays.asList(new Item(2, "Item2", 10, 10))); 
															
		RequestBuilder request = MockMvcRequestBuilders
				.get("/all-items-from-database")
				.accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().isOk())		
				.andExpect(content().json("[{id: 2, name: Item2, price: 10}]")) 
				.andReturn();
		
	}


}
