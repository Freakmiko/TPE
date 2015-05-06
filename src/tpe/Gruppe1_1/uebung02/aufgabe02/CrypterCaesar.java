package tpe.Gruppe1_1.uebung02.aufgabe02;

public class CrypterCaesar implements Crypter {
	
	private int key = 3;
	private char[] clearLetter = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private char[] encryptedLetter = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

	
	public CrypterCaesar(int key){
		try{
			if(key >= 0){
				//take modulo to make the calculation simple
				this.key = (key % clearLetter.length);
			}else{
				throw new IllegalArgumentException(""+key);
			}
		}catch(IllegalArgumentException ex){
			System.out.println("***Fehler aufgetreten***"); 
			System.out.println(ex.getMessage()+" ist kein gültiger Schlüssel");
		}
		
	}
	
	/**
	 * This method take a string and encrypt it. For this we move each letter in the alphabet,
	 * on the basis of the key, to the right.
	 * @param message is the message we want to encrypt
	 * @return we get back a string with the encrypted message
	 */
	@Override
	public String encrypt(String message) {
		
		String encryptedMessag = "";
		int index = 0;
		
		for(int i = 0; i < message.length(); i++){
			char letter = message.charAt(i);
			
			//search the current char in our Arrays to check if we need to encrypt the char
			while(index < clearLetter.length && (letter != clearLetter[index] && letter != encryptedLetter[index])){
				index++;
			}
			
			//if we have find the char in one of the Arrays we encrypt it
			//else we just take it like it is
			if(index < clearLetter.length){
				encryptedMessag +=  encryptedLetter [(index + key) % clearLetter.length];
			}else{
				encryptedMessag += message.charAt(i);
			}
				
			
			index = 0;
			
		}
		
		
		return encryptedMessag;
	}
	

	/**
	 * This method take a string, which should be encrypted, and decrypt it. 
	 * For this we move each letter in the alphabet, on the basis of the key, to the left.
	 * @param cypherText is the message we want to decrypt
	 * @return we get back a string with the decrypted message
	 */
	@Override
	public String decrypt(String cypherText) {
		
		String decryptedText = "";
		int index = 0;
		
		for(int i = 0; i < cypherText.length(); i++){
			char letter = cypherText.charAt(i);
			
			//search the current char in our Array to check if we need to decrypt the char
			while(index < clearLetter.length && letter != encryptedLetter[index]){
				index++;
			}
			
			//if we have find the char in the Arrays we decrypt it
			//else we just take it like it is
			if(index < clearLetter.length){
				decryptedText += clearLetter[(index + (clearLetter.length - key) )%clearLetter.length];
			}else{
				decryptedText += cypherText.charAt(i);
			}
				
			
			index = 0;
		}
		
		return decryptedText;
	}

}
