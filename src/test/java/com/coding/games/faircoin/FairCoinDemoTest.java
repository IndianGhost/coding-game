package com.coding.games.faircoin;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class FairCoinDemoTest {

	private FairCoinDemo fairCoinDemo = FairCoinDemo.getInstance();

	@DisplayName("Test the case of an even number")
	@Test
	public void should_succeed_even_number() {
		int expected = 4;
		int actual = fairCoinDemo.flipMultipleFairCoinsAtSameTime(10);
		assertEquals(expected, actual);
	}

	@DisplayName("Test the case of an odd number")
	@Test
	public void should_succeed_odd_number() {
		int expected = 5;
		int actual = fairCoinDemo.flipMultipleFairCoinsAtSameTime(17);
		assertEquals(expected, actual);
	}
}
