package com.coding.games.casetypes;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.ArgumentMatchers;
import org.mockito.MockedStatic;

@TestInstance(Lifecycle.PER_CLASS)
public class CaseTypeDemoTest {
	
	private final CaseTypeDemo caseTypeDemo = CaseTypeDemo.getInstance();
	

	@BeforeAll
	public void init() {
		try(MockedStatic<CaseTypeUtils> utilities = mockStatic(CaseTypeUtils.class)) {
			utilities.when(() -> {
				CaseTypeUtils.checkVariableValidity(ArgumentMatchers.anyString());
			})
			.thenCallRealMethod();
		}
	}
	
	@Test
	public void should_return_snake_case() {
		CaseTypeEnum expected = CaseTypeEnum.snake_case;
		CaseTypeEnum actual = caseTypeDemo.whichCaseType("indian_ghost");
		assertEquals(expected, actual);
	}
	
	@Test
	public void shouldReturnCamelCase() {
		CaseTypeEnum expected = CaseTypeEnum.camelCase;
		CaseTypeEnum actual = caseTypeDemo.whichCaseType("indianGhost");
		assertEquals(expected, actual);
	}
	
	@Test
	public void ShouldReturnPascalCase() {
		CaseTypeEnum expected = CaseTypeEnum.PascalCase;
		CaseTypeEnum actual = caseTypeDemo.whichCaseType("IndianGhost");
		assertEquals(expected, actual);
	}
}
