/**
 * 
 */
package com.viruksham.utils.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @author bala
 * 
 */
public class SecurityUtil {

	private static final int NUM_OF_BYTES_IN_SALT = 12;

	public static byte[] generateSalt() {

		Random rand = new Random();
		byte[] salt = new byte[NUM_OF_BYTES_IN_SALT];

		rand.nextBytes(salt);
		return salt;
	}

	public static String generatePassword(String password, byte[] salt)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {

		String result = "";
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(salt);
			m.update(password.getBytes("UTF8"));
			byte s[] = m.digest();
			for (int i = 0; i < s.length; i++) {
				result += Integer.toHexString((0x000000ff & s[i]) | 0xffffff00)
						.substring(6);
			}
		}
		catch (UnsupportedEncodingException e) {
			throw e;
		}
		catch (NoSuchAlgorithmException e) {
			throw e;
		}

		return result;
	}
}
