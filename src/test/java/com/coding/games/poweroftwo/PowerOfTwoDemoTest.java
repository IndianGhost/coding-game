package com.coding.games.poweroftwo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class PowerOfTwoDemoTest {
	private PowerOfTwoDemo powerOfTwoDemo;
	
	@BeforeAll
	public void init() {
		powerOfTwoDemo = PowerOfTwoDemo.getInstance();
	}
	
	@DisplayName("Test case of illegal argument")
	@Test
	public void should_fail_because_illegal_argument() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			powerOfTwoDemo.wichPowerOfTwo(0);
		});
		String expectedMessage = "The argument n should be : 1<=n<=2147483647";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	@DisplayName("Test case of number not a power of two")
	@Test
	public void number_not_power_of_two() {
		final int EXPECTED_RESULT = -1;
		
		// Number less than two
		int result = powerOfTwoDemo.wichPowerOfTwo(1);
		assertEquals(EXPECTED_RESULT, result);
		
		// Even numbers not a power of two
		result = powerOfTwoDemo.wichPowerOfTwo(22);
		assertEquals(EXPECTED_RESULT, result);
		
		// Odd numbers
		result = powerOfTwoDemo.wichPowerOfTwo(45);
		assertEquals(EXPECTED_RESULT, result);
		
		result = powerOfTwoDemo.wichPowerOfTwo(45);
		assertEquals(EXPECTED_RESULT, result);
	}
	
	@DisplayName("Test case of number is power of two")
	@Test
	public void number_is_power_of_two() {
		int expected = 3;
		int result = powerOfTwoDemo.wichPowerOfTwo(8);
		assertEquals(expected, result);
	}
}
