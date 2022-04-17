package com.coding.games.encryptedmessage;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import com.coding.games.common.test.CommonTestUtils;

@TestInstance(Lifecycle.PER_CLASS)
public class EncryptedMessageUtilsTest {

	private final String INVALID_MESSAGE = CommonTestUtils.LONG_GENERIC_TEXT;

	@DisplayName("Test invalid message")
	@Test
	public void should_fail_too_long_msg() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			EncryptedMessageUtils.checkMessageValidity(INVALID_MESSAGE);
		});
		String expected = "message must be less or equal to 1000 characters";
		String actual = exception.getMessage();
		assertTrue(expected.equals(actual));
	}

	@DisplayName("test valid message")
	@Test
	public void should_succeed_message() {
		String message = "Hello World";
		EncryptedMessageUtils.checkMessageValidity(message);
	}

	@DisplayName("Test invalid key because of length")
	@Test
	public void should_fail_because_key_too_long() {
		String messageOfException = "key must be less or equal to 52 alphabetic characters";
		testKeyException(INVALID_MESSAGE, messageOfException);
	}

	@DisplayName("Test invalid key because of alphabetic characters")
	@Test
	public void should_fail_because_of_alphabetic_chars() {
		final String KEY = "Lorem 121 ipsum dolor sit 152";
		String messageOfException = "key must contain only alphabetic characters";
		testKeyException(KEY, messageOfException);
	}

	@DisplayName("Test invalid key because of duplicated characters")
	@Test
	public void should_fail_because_of_duplicated_char() {
		final String KEY = "LoremIpsumDolorSit";
		String messageOfException = "key must be without any duplicated character";
		testKeyException(KEY, messageOfException);
	}

	@DisplayName("Test invalid key because of number of uppercase characters")
	@Test
	public void should_fail_because_of_number_of_upper_chars() {
		final String KEY = "lOREMiPSUMdOLORsITEIUSMODTEMPORINCIDIDUNTUTLABOREETW";
		String messageOfException = "key must contain uppercase characters less or equal to 26";
		testKeyException(KEY, messageOfException);
	}

	@DisplayName("Test invalid key because of number of lowercase characters")
	@Test
	public void should_fail_because_of_number_of_lower_chars() {
		final String KEY = "LoremIpsumDolorSiteiusmodtemporincididuntutlaboreetw";
		String messageOfException = "key must contain lowercase characters less or equal to 26";
		testKeyException(KEY, messageOfException);
	}

	@DisplayName("Test valid key")
	@Test
	public void should_succeed_key() {
		String key = "HeloWrd";
		EncryptedMessageUtils.checkKeyValidity(key);
	}

	private void testKeyException(String messageOrKey, String messageOfException) {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			EncryptedMessageUtils.checkKeyValidity(messageOrKey);
		});
		String expected = messageOfException;
		String actual = exception.getMessage();
		assertTrue(expected.equals(actual));
	}
}
