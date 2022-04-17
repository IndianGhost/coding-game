package com.coding.games.loseweight;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class LoseWeightTest {
	private LoseWeight loseWeight = new LoseWeight();

	@DisplayName("Test how many week to reach an ideal weight")
	@Test
	public void test() {
		int numberOfWeek = loseWeight.numberOfWeekToReachIdealWeight(85, 82.5);
		int expected = 3;
		assertEquals(expected, numberOfWeek);

		// In case the actual weight is less than the ideal weight, it's obvious that you don't have to lose weight ;) Eat well!
		numberOfWeek = loseWeight.numberOfWeekToReachIdealWeight(60, 68);
		expected = 0;
		assertEquals(expected, numberOfWeek);
	}
}
