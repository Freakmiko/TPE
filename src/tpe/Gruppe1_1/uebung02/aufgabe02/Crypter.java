package tpe.Gruppe1_1.uebung02.aufgabe02;

public interface Crypter {
	
	/**
	 * This method take a string and encrypt it.
	 * @param message is the message we want to encrypt
	 * @return we get back a string with the encrypted message
	 */
	public String encrypt(String message);
	
	/**
	 * This method take a string, which should be encrypted, and decrypt it.
	 * @param cypherText is the message we want to decrypt
	 * @return we get back a string with the decrypted message
	 */
	public String decrypt(String cypherText);

}
