package tpe.Gruppe1_1.uebung02.aufgabe02;

import static org.junit.Assert.*;

import org.junit.Test;

public class CrypterReverseTest {
	
	private Crypter crypter;

	@Test
	public void encryptABC() {
		
		crypter = new CrypterReverse();
		
		assertEquals("ZYXWVUTSRQPONMLKJIHGFDCBA", crypter.encrypt("ABCDFGHIJKLMNOPQRSTUVWXYZ"));
		assertEquals("zyxwvutsrqponmlkjihgfedcba", crypter.encrypt("abcdefghijklmnopqrstuvwxyz"));
		
	}
	
	
	@Test
	public void encryptEmpty() {
		
		crypter = new CrypterReverse();
		
		assertEquals("", crypter.encrypt(""));
		
	}
	
	@Test
	public void encryptSpace() {
		
		crypter = new CrypterReverse();
		
		assertEquals(" ", crypter.encrypt(" "));
		
	}
	
	@Test
	public void encryptSpecialSign() {
		
		crypter = new CrypterReverse();
		
		assertEquals("!\"§$%&/()=?´-:;-.,", crypter.encrypt(",.-;:-´?=)(/&%$§\"!"));
		
	}
	
	@Test
	public void encryptWords() {
		
		crypter = new CrypterReverse();
		
		assertEquals("RHEKMU", crypter.encrypt("UMKEHR"));
		assertEquals("kcirtaP", crypter.encrypt("Patrick"));
		assertEquals("leahciM", crypter.encrypt("Michael"));
		assertEquals("!tleW ollaH", crypter.encrypt("Hallo Welt!"));
		
	}
	
	
	
	@Test
	public void decryptABC() {
		
		crypter = new CrypterReverse();
		
		assertEquals("ABCDFGHIJKLMNOPQRSTUVWXYZ", crypter.decrypt("ZYXWVUTSRQPONMLKJIHGFDCBA"));
		assertEquals("abcdefghijklmnopqrstuvwxyz", crypter.decrypt("zyxwvutsrqponmlkjihgfedcba"));
		
	}
	
	
	@Test
	public void decryptEmpty() {
		
		crypter = new CrypterReverse();
		
		assertEquals("", crypter.decrypt(""));
		
	}
	
	@Test
	public void decryptspace() {
		
		crypter = new CrypterReverse();
		
		assertEquals(" ", crypter.decrypt(" "));
		
	}
	
	@Test
	public void decryptSpecialSign() {
		
		crypter = new CrypterReverse();
		
		assertEquals(",.-;:-´?=)(/&%$§\"!", crypter.decrypt("!\"§$%&/()=?´-:;-.,"));
		
	}
	
	@Test
	public void decryptWords() {
		
		crypter = new CrypterReverse();
		
		assertEquals("UMKEHR", crypter.decrypt("RHEKMU"));
		assertEquals("Patrick", crypter.decrypt("kcirtaP"));
		assertEquals("Michael", crypter.decrypt("leahciM"));
		assertEquals("Hallo Welt!", crypter.decrypt("!tleW ollaH"));
		
	}
	

}
