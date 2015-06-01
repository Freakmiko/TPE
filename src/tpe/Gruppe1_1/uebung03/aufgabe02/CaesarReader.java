package tpe.Gruppe1_1.uebung03.aufgabe02;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class CaesarReader extends FilterReader{
	
	private char[] alphabetArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü".toCharArray();
	private int encryptKey;

	public CaesarReader(Reader in, int key) {
		super(in);
		
		//take the Key Modulo, so it easier to use it
		if(key >= 0){
			encryptKey = key % alphabetArray.length;
		}else{
			//take the Key Modulo and plus the Array length so we got a positive
			//shifting which gives the same result as the negative shifting
			encryptKey = (key % alphabetArray.length) + alphabetArray.length;
		}
		
	}	
	
	/**
	 * Reads a single character, which should be encrypted, and decrypt it. 
	 * For this we move each letter in the alphabet, on the basis of the key
	 * @return The encrypt character, as an integer in the range 0 to 65535, or -1 if the end of the stream has been reached 
	 * @throws IOException If an I/O error occurs 
	 */
	@Override
	public int read() throws IOException {
		int returnValue;
		int index = 0;
		
		returnValue = super.read();
		
		if(returnValue != -1){
			while(index < alphabetArray.length && (char)returnValue != alphabetArray[index]){
				index++;
			}
			
			//if we have find the char in the Arrays we decrypt it
			//else we just take it like it is
			if(index < alphabetArray.length){
				returnValue = alphabetArray[(index + (alphabetArray.length - encryptKey) )%alphabetArray.length];
			}
		}
		
		
		return returnValue;
	}
}
