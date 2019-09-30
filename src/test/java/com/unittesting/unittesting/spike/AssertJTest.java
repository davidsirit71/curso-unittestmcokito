package com.unittesting.unittesting.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class AssertJTest {
	
	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(12,15,45);
		
//		assertThat(numbers, hasSize(3));
//		assertThat(numbers, hasItems(12,45));
//		assertThat(numbers, everyItem(greaterThan(10)));
//		assertThat(numbers, everyItem(lessThan(50)));
		assertThat(numbers).hasSize(3)
			.contains(12,15)
			.allMatch(x -> x > 10) // programacion funcional
			.allMatch(x -> x < 100)
			.noneMatch(x -> x < 0);
		
		assertThat("").isEmpty();
		assertThat("ABCDE").contains("BCD")
			.startsWith("ABC")
			.endsWith("CDE");
//		assertThat("", isEmptyString());
//		assertThat("ABCDE", containsString("BCD"));
//		assertThat("ABCDE", startsWith("ABC"));
//		assertThat("ABCDE", endsWith("DE"));
	}

}
