package tpe.Gruppe1_1.uebung02.aufgabe02;

import static gdi.MakeItSimple.*;

public class SecretMessage {
	
	public static void main(String[] args){
		
		Crypter crypter;
		String encryptMessage = "XHMSNYYXYJQQJS";
		String decryptedMessage = "";
		
		
		crypter = new CrypterReverse();
		decryptedMessage = crypter.decrypt(encryptMessage);
		
		crypter = new CrypterCaesar(5);
		decryptedMessage = crypter.decrypt(decryptedMessage);
		
		crypter = new CrypterReverse();
		decryptedMessage = crypter.decrypt(decryptedMessage);
		
		println(decryptedMessage);
		
	}

}
