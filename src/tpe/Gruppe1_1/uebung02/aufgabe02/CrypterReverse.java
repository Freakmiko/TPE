package tpe.Gruppe1_1.uebung02.aufgabe02;

public class CrypterReverse implements Crypter {

	
	/**
	 * This method take a string and encrypt it. For this we turn the whole String
	 * @param message is the message we want to encrypt
	 * @return we get back a string with the encrypted message
	 */
	@Override
	public String encrypt(String message) {
		
		String encryptMessage = "";
		
		//Go from behind through the String and ad each char in a the encrypted String
		for(int i = message.length()-1; i >= 0; i--){
			encryptMessage += message.charAt(i);
		}
		
		return encryptMessage;
	}

	/**
	 * This method take a string, which should be encrypted, and decrypt it. For this we turn the whole String
	 * @param cypherText is the message we want to decrypt
	 * @return we get back a string with the decrypted message
	 */
	@Override
	public String decrypt(String cypherText) {
		String decryptMessage = "";
		
		//Go from behind through the String and ad each char in a the decrypted String
		for(int i = cypherText.length()-1; i >= 0; i--){
			decryptMessage += cypherText.charAt(i);
		}
		
		return decryptMessage;
	}

}
