package com.coding.games.casetypes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaseTypeUtils {
	
	public static final String CASE_TYPE_REGEX = "[A-Za-z0-9\\_]*$"; 
	
	public static void checkVariableValidity(String variable) throws IllegalArgumentException {
		if(variable.length() < 1 || variable.length() > 1001) {
			throw new IllegalArgumentException("The length of provided text must be between 1 and 1001");
		}
		
		Pattern pattern = Pattern.compile(CASE_TYPE_REGEX);
		Matcher matcher = pattern.matcher(variable);
		if(!matcher.matches()) {
			throw new IllegalArgumentException(variable + ": must be only in camelCase or snake_case or PascalCase");
		}
	}
}
