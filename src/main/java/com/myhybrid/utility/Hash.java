package com.myhybrid.utility;

import org.mindrot.jbcrypt.BCrypt;

public class Hash {
	
	public static String hashItem(String plainText){
	    return BCrypt.hashpw(plainText, BCrypt.gensalt());
	} 
	
	public static boolean compareHashItem(String plainText, String hashedText) {
		return BCrypt.checkpw(plainText, hashedText);
	}

}
