package com.mpersd.techshop.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtil {

	public static String hashPassword(String password) throws NoSuchAlgorithmException{
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte[] mdArray = md.digest();
        
        StringBuilder sb = new StringBuilder(mdArray.length * 2);
        for(byte b : mdArray){
            int v = b & 0xff;
            
            if(v<16){
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString();
    }
   
    public static String hashAndSalt(String password) throws NoSuchAlgorithmException{
		String secret = "SkSW+1KaQ5UPRIRGseO8GXLotK6nD97opnZ3SC5+OY8=";
		
    	return hashPassword(password+secret);	
    }
}
