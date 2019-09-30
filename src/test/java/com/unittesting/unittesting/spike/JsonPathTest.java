package com.unittesting.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {
	
	@Test
	public void learning() {
		
		String responseFromService = "[" + 
				"{\"id\":10000, \"name\":\"Pencil\", \"quantity\":5}," + 
				"{\"id\":10001, \"name\":\"Pen\", \"quantity\":5}," + 
				"{\"id\":10002, \"name\":\"Eraser\", \"quantity\":5}" + 
				"]";
		
		
		DocumentContext context = JsonPath.parse(responseFromService);
		int length = context.read("$.length()");
		assertThat(length).isEqualTo(3);
		
		System.out.println(context.read("$..id").toString());
		
		List<Integer> ids = context.read("$..id");
		assertThat(ids).containsExactly(10000,10001,10002);
		
		System.out.println("nota1: " + context.read("$.[1]").toString());
		System.out.println("nota2: " + context.read("$.[0:1]").toString());
		System.out.println("nota3: " + context.read("$.[?(@.name=='Eraser')]").toString());
		System.out.println("nota4: " + context.read("$.[?(@.quantity=='5')]").toString());
		
	}
	

}
