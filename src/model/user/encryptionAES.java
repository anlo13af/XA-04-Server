package model.user;

import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;

import sun.misc.*;

/**
 * encryptionAES class to encrypt and decrypt passwords
 * 
 * @author andersliltorp
 *
 */
public class encryptionAES {

	private static String algorithm = "AES";
	private static byte[] keyValue = new byte[] { 'D', 'I', 'S', 'T', '@', 'D',
			'O', 'E', 'K', '4', 'E', 'V', 'A', 'H', '!', '!' };

	/**
	 * Encrypts a given String
	 * 
	 * @param plainText
	 * @return Encrypted string
	 * @throws Exception
	 */
	public static String encrypt(String plainText) throws Exception {
		// generate key
		Key key = generateKey();
		Cipher chiper = Cipher.getInstance(algorithm);
		chiper.init(Cipher.ENCRYPT_MODE, key);
		byte[] encVal = chiper.doFinal(plainText.getBytes());
		String encryptedValue = new BASE64Encoder().encode(encVal);
		return encryptedValue;
	}

	/**
	 * Decrypts a given String
	 * 
	 * @param encryptedText
	 * @return Decrypted string
	 * @throws Exception
	 */
	public static String decrypt(String encryptedText) throws Exception {
		// generate key
		Key key = generateKey();
		Cipher chiper = Cipher.getInstance(algorithm);
		chiper.init(Cipher.DECRYPT_MODE, key);
		byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedText);
		byte[] decValue = chiper.doFinal(decordedValue);
		String decryptedValue = new String(decValue);
		return decryptedValue;
	}

	/**
	 * Generates the key used for encryption and decryption
	 * 
	 * @return the key
	 * @throws Exception
	 */
	private static Key generateKey() throws Exception {
		Key key = new SecretKeySpec(keyValue, algorithm);
		return key;
	}

}
