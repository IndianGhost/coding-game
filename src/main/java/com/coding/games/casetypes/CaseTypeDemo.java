package com.coding.games.casetypes;

import static java.util.Objects.isNull;
import static com.coding.games.casetypes.CaseTypeUtils.checkVariableValidity;

public class CaseTypeDemo {
	
	private static CaseTypeDemo instance;
	private CaseTypeDemo() {}
	
	public static CaseTypeDemo getInstance() {
		if(isNull(instance)) {
			instance = new CaseTypeDemo();
		}
		return instance;
	}
	
	public CaseTypeEnum whichCaseType(String variable) throws IllegalArgumentException {
		checkVariableValidity(variable);

		if(Character.isUpperCase(variable.charAt(0))) {
			return CaseTypeEnum.PascalCase;
		} if(variable.contains("_")) {
			return CaseTypeEnum.snake_case;
		} else {
			return CaseTypeEnum.camelCase;
		}
	}
}
