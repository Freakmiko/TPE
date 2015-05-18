package tpe.Gruppe1_1.uebung03.aufgabe02;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class CaesarWriter extends FilterWriter{
	
	private char[] alphabetArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü".toCharArray();
	private int encryptKey;

	public CaesarWriter(Writer out, int key) {
		super(out);
		
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
	 * Writes a single character and encrypt it. For this we move the character in the alphabet,
	 * on the basis of the key.
	 * @param c - int specifying a character to be written   
	 * @throws IOException  If an I/O error occurs 
	 */
	public void write(int c) throws IOException{
		int index = 0;
		
		//Search the Char, which we will encrypt, in our alphabet Array
		while(index < alphabetArray.length && (char)c != alphabetArray[index]){
			index++;
		}
		
		//If we find the char in our array we encrypt it and write it
		//else we just write it
		if(index < alphabetArray.length){
			super.write(alphabetArray[(index + encryptKey) % alphabetArray.length]); 
		}else{
			super.write((char)c); 
		}
	}
	
	public void write(char[] cbuf, int off, int len) throws IOException{
		
		for(int i = 0; i < len; ++i){
			write(cbuf[off+i]);
		}
	}
	
	public void write( String str, int off, int len) throws IOException{
		
		write(str.toCharArray(), off, len);
		
	}

}
