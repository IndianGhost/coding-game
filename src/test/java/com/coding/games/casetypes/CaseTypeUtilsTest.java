package com.coding.games.casetypes;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.coding.games.common.test.CommonTestUtils;

public class CaseTypeUtilsTest {
	
	@Test
	public void should_succeed() {
		String[] validValues = new String[]{"snake_case", "camelCase", "PascalCase"};
		for (String value : validValues) {
			CaseTypeUtils.checkVariableValidity(value);
		}
	}
	
	@Test
	public void should_fail_because_of_case_type() {
		String variable = "snake case";
		String expectedMessage = variable + ": must be only in camelCase or snake_case or PascalCase";
		testHelper(variable, expectedMessage);
	}
	
	@Test
	public void should_fail_because_of_length() {
		String variable = CommonTestUtils.LONG_GENERIC_TEXT;
		String expectedMessage = "The length of provided text must be between 1 and 1001";
		testHelper(variable, expectedMessage);
	}
	
	private void testHelper(String variable, String expectedMessage) {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			CaseTypeUtils.checkVariableValidity(variable);
		});
		String actualMessage = exception.getMessage();
		assertTrue(expectedMessage.equals(actualMessage));
	}
}