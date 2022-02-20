package com.coding.games.pumper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class PumperUtilTest {
	
	@DisplayName("check time is invalid because of format")
	@Test
	public void time_is_invalid_because_of_format() {
		final String INVALID_TIME_1 = "23h 12m 2s";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			PumperUtil.checkTimeValidity(INVALID_TIME_1);
		});
		String expectedMessage = "Time " + INVALID_TIME_1 + " is invalid. The correct format is HH:MM:SS";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
		
		// This time is also considered as a format defect because it doesn't match the regex "^[0-2][0-9]:([0-5][0-9]:*){2}$"
		final String INVALID_TIME_2 = "53:72:75";
		exception = assertThrows(IllegalArgumentException.class, () -> {
			PumperUtil.checkTimeValidity(INVALID_TIME_2);
		});
		expectedMessage = "Time " + INVALID_TIME_2 + " is invalid. The correct format is HH:MM:SS";
		actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	@DisplayName("check time is invalid because of hours")
	@Test
	public void time_is_invalid_because_of_hours() {
		final String INVALID_TIME = "24:12:25";
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			PumperUtil.checkTimeValidity(INVALID_TIME);
		});
		
		String expectedMessage = "Hours have to be less or equals to 23";
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
	
	@DisplayName("check time is valid")
	@Test
	public void time_is_valid() {
		// if this test passed, it means no exception thrown. i.e, time string is valid
		final String VALID_TIME = "18:56:02";
		PumperUtil.checkTimeValidity(VALID_TIME);
	}
	
	@DisplayName("Test converting time from HH:MM:SS to seconds")
	@Test
	public void test_convert_time_to_seconds() {
		// GIVEN
		int result = PumperUtil.convertTimeToSeconds("02:15:40");
		// THEN
		int expected = 8140;
		assertEquals(expected, result);
	}
	
	@DisplayName("Test converting time from seconds to HH:MM:SS")
	@Test
	public void test_convert_seconds_to_time_format() {
		// GIVEN
		String result = PumperUtil.convertSecondsToTime(8140);
		// THEN
		String expected = "02:15:40";
		assertTrue(expected.equals(result));
	}
	
	@DisplayName("Test representation of hours or minutes or seconds")
	@Test
	public void test_time_unit_representation() {
		// GIVEN
		String result = PumperUtil.timeUnitPresentation(3);
		// THEN
		String expected = "03";
		assertTrue(expected.equals(result));
		
		// GIVEN
		result = PumperUtil.timeUnitPresentation(10);
		// THEN
		expected = "10";
		assertTrue(expected.equals(result));
	}
}
