package main;

/**
 * Encryption class used to decrypt data
 * 
 * @author andersliltorp
 *
 */
public class encryption {
	/**
	 * decrypt method that decrypts bytes and returns them as a string
	 * 
	 * @param b
	 * @return decrypted string
	 */
	public String decrypt(byte[] b) {
		// Defines the decryption value of the byte
		byte ff = (byte) 3.1470;
		// Generates for loop containing decryption value
		for (int i = 0; i < b.length; i++) {
			b[i] = (byte) (b[i] ^ ff);
		}
		// Generates new String without any white spaces following or leading
		String decrypted = new String(b).trim();
		// Returns decrypted String
		return decrypted;
	}
}
