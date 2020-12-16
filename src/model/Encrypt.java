package model;

import org.apache.commons.codec.digest.DigestUtils;

public class Encrypt {

	
	public String Encrypt(String text) {		

	String textEncrypted=DigestUtils.sha1Hex(text); 
	return textEncrypted;
	
	}
}