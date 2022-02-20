package com.coding.games.pumper;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class PumperDemoTest {
	private PumperDemo pumperDemo;
	
	@BeforeAll
	public void init() {
		pumperDemo = PumperDemo.getInstance();
	}
	
	@DisplayName("Test for 1 pumper")
	@Test
	public void test_for_one_pumer() {
		String expected = "01:02:15";
		Pumper pumper = new Pumper(expected);
		String actual = pumperDemo.executePumpersTogether(1, new Pumper[] {pumper});
		assertTrue(actual.equals(expected));
	}
	
	@DisplayName("Test for many pumpers")
	@Test
	public void test_for_many_pumpers() {
		String expected = "00:12:00";
		Pumper pumper1 = new Pumper("00:30:00");
		Pumper pumper2 = new Pumper("00:20:00");
		String actual = pumperDemo.executePumpersTogether(2, new Pumper[] {pumper1, pumper2});
		assertTrue(actual.equals(expected));
		
		// Let's add a third pumper
		Pumper pumper3 = new Pumper("00:15:00");
		actual = pumperDemo.executePumpersTogether(3, new Pumper[] {pumper1, pumper2, pumper3});
		expected = "00:06:40";
		assertTrue(actual.equals(expected));
	}
	
	@DisplayName("Test for illegal parameters")
	@Test
	public void should_fail_because_of_illegal_parameter() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			Pumper pumper = new Pumper();
			Pumper pumpers[] = new Pumper[] {pumper};
			pumperDemo.executePumpersTogether(2, pumpers);
		});
		String expectedMessage = "First argument is number of pumpers. Therefore, the second argument has to be a vector containing the same number of pumpers";
		String actualMessage = exception.getMessage();
		assertTrue(actualMessage.equals(expectedMessage));
	}
}
