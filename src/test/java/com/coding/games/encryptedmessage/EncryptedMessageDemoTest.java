package com.coding.games.encryptedmessage;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class EncryptedMessageDemoTest {
	private final EncryptedMessageDemo encryptedMessageDemo = EncryptedMessageDemo.getInstance();
	
	@DisplayName("Test Encryption")
	@Test
	public void test_valid_encryption() {
		String expected = "elooW rWdoH";
		String message = "Hello World";
		String keyEncryption = "HeloWrd";
		
		String result = encryptedMessageDemo.encryptMessage(message, keyEncryption);
		assertTrue(expected.equals(result));
	}
}
