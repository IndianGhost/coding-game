package com.coding.games.encryptedmessage;

public class EncryptedMessageUtils {
	public static final String KEY_REGEX_ALPHABETIC_AND_LENGTH = "^[a-zA-Z]{0,52}$";

	public static void checkMessageValidity(String message) throws IllegalArgumentException {
		if (message.length() > 1000) {
			throw new IllegalArgumentException("message must be less or equal to 1000 characters");
		}
	}

	public static void checkKeyValidity(String key) {
		if (key.length() > 52) {
			throw new IllegalArgumentException("key must be less or equal to 52 alphabetic characters");
		}
		if (!key.matches(KEY_REGEX_ALPHABETIC_AND_LENGTH)) {
			throw new IllegalArgumentException("key must contain only alphabetic characters");
		}

		int countUppercase = 0;
		int countLowercase = 0;
		for (int i = 0; i < key.length(); i++) {
			if (Character.isUpperCase(key.charAt(i))) {
				countUppercase++;
			} else {
				countLowercase++;
			}
		}
		if (countUppercase > 26) {
			throw new IllegalArgumentException("key must contain uppercase characters less or equal to 26");
		}
		if (countLowercase > 26) {
			throw new IllegalArgumentException("key must contain lowercase characters less or equal to 26");
		}
		if (isAnyCharacterDuplicated(key)) {
			throw new IllegalArgumentException("key must be without any duplicated character");
		}
	}

	private static boolean isAnyCharacterDuplicated(String key) {
		for (int i = 0; i < key.length(); i++) {
			for (int j = i + 1; j < key.length(); j++) {
				if (key.charAt(i) == key.charAt(j)) {
					return true;
				}
			}
		}
		return false;
	}
}