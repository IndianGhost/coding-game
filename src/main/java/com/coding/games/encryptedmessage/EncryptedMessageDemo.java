package com.coding.games.encryptedmessage;

import static java.util.Objects.isNull;
import static com.coding.games.encryptedmessage.EncryptedMessageUtils.checkMessageValidity;
import static com.coding.games.encryptedmessage.EncryptedMessageUtils.checkKeyValidity;

public class EncryptedMessageDemo {
	
	private static EncryptedMessageDemo instance;
	private EncryptedMessageDemo() {}
	
	public static EncryptedMessageDemo getInstance() {
		if(isNull(instance)) {
			instance = new EncryptedMessageDemo();
		}
		return instance;
	}
	
	public String encryptMessage(String message, String keyEncryption) {
		
		checkMessageValidity(message);
		checkKeyValidity(keyEncryption);
		
		StringBuilder messageBuilder = new StringBuilder(message);
		for(int i = 0; i < keyEncryption.length(); i++) {
			
			for(int j = 0; j < message.length(); j++) {
				
				if(keyEncryption.charAt(i) == message.charAt(j)) {
					if(i == keyEncryption.length() - 1) {
						messageBuilder.setCharAt(j, keyEncryption.charAt(0));
					} else {
						messageBuilder.setCharAt(j, keyEncryption.charAt(i+1));
					}
				}
			}
		}
		
		return messageBuilder.toString();
	}
}
