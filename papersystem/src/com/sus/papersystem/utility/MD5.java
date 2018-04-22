package com.sus.papersystem.utility;

import java.security.MessageDigest;
import java.util.Base64;

public class MD5 {
	public static String getMD5(String password) {
		String result = null;
		try {
			MessageDigest md = MessageDigest.getInstance("md5");
			byte[] bytes = md.digest(password.getBytes("UTF-8"));
			result = Base64.getEncoder().encodeToString(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
