package com.coding.games.encryptedmessage;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class EncryptedMessageUtilsTest {
	
	/**
	 * TODO: Please use {CommonTestUtils.LONG_GENERIC_TEXT} instead !
	 */
	@Deprecated
	private final String INVALID_MESSAGE = new StringBuilder("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do")
			.append("eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut")
			.append("enim ad minim veniam, quis nostrud exercitation ullamco")
			.append("laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure")
			.append("dolor in reprehenderit in voluptate velit esse cillum dolore eu")
			.append("fugiat nulla pariatur. Excepteur sint occaecat cupidatat non")
			.append("proident, sunt in culpa qui officia deserunt mollit anim id est laborum.")
			.append("It's difficult to find examples of lorem ipsum in use before Letraset made it popular as a ")
			.append("dummy text in the 1960s, although McClintock says he remembers coming across the lorem ")
			.append("ipsum passage in a book of old metal type samples. So far he hasn't relocated where he once ")
			.append("saw the passage, but the popularity of Cicero in the 15th century supports the theory that the ")
			.append("filler text has been used for centuries.")
			.append("And anyways, as Cecil Adams reasoned, “[Do you really] think graphic arts supply houses were ")
			.append("hiring classics scholars in the 1960s?” Perhaps. But it seems reasonable to imagine that there ")
			.append("was a version in use far before the age of Letraset.")
			.toString();
	
	@DisplayName("Test invalid message")
	@Test
	public void should_fail_too_long_msg() {
		Exception exception = assertThrows(IllegalArgumentException.class,() -> {
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
		Exception exception = assertThrows(IllegalArgumentException.class,() -> {
			EncryptedMessageUtils.checkKeyValidity(messageOrKey);
		});
		String expected = messageOfException;
		String actual = exception.getMessage();
		assertTrue(expected.equals(actual));
	}
}