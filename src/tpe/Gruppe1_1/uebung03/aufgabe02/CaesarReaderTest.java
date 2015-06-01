package tpe.Gruppe1_1.uebung03.aufgabe02;

import static org.junit.Assert.*;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterReader;
import java.io.IOException;

import org.junit.Test;

public class CaesarReaderTest {

	@Test
	public void decryptAlphabetKey1() {
		
		String encryptMessage = "";
		
		FileWriter fw;
		FilterReader fr;
		int c;
		
		try {
			fw = new FileWriter("caesarReadTest.txt");
			
			fw.write("BCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöüA");
			
			fw.close();
			
			fr = new CaesarReader(new FileReader("caesarReadTest.txt"), 1);
			
			while ((c = fr.read()) != -1) { 
				encryptMessage += (char)c;
			}
			
			fr.close();
			
			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void decryptAlphabetKey0() {
		
		String encryptMessage = "";
		
		FileWriter fw;
		FilterReader fr;
		int c;
		
		try {
			fw = new FileWriter("caesarReadTest.txt");
			
			fw.write("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü");
			
			fw.close();
			
			fr = new CaesarReader(new FileReader("caesarReadTest.txt"), 0);
			
			while ((c = fr.read()) != -1) { 
				encryptMessage += (char)c;
			}
			
			fr.close();
			
			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void decryptAlphabetKey58() {
		
		String encryptMessage = "";
		
		FileWriter fw;
		FilterReader fr;
		int c;
		
		try {
			fw = new FileWriter("caesarReadTest.txt");
			
			fw.write("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü");
			
			fw.close();
			
			fr = new CaesarReader(new FileReader("caesarReadTest.txt"), 58);
			
			while ((c = fr.read()) != -1) { 
				encryptMessage += (char)c;
			}
			
			fr.close();
			
			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void decryptAlphabetKey57() {
		
		String encryptMessage = "";
		
		FileWriter fw;
		FilterReader fr;
		int c;
		
		try {
			fw = new FileWriter("caesarReadTest.txt");
			
			fw.write("üABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäö");
			
			fw.close();
			
			fr = new CaesarReader(new FileReader("caesarReadTest.txt"), 57);
			
			while ((c = fr.read()) != -1) { 
				encryptMessage += (char)c;
			}
			
			fr.close();
			
			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void decryptAlphabetKey59() {
		
		String encryptMessage = "";
		
		FileWriter fw;
		FilterReader fr;
		int c;
		
		try {
			fw = new FileWriter("caesarReadTest.txt");
			
			fw.write("BCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöüA");
			
			fw.close();
			
			fr = new CaesarReader(new FileReader("caesarReadTest.txt"), 59);
			
			while ((c = fr.read()) != -1) { 
				encryptMessage += (char)c;
			}
			
			fr.close();
			
			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void decryptAlphabetKeyMin1() {
		
		String encryptMessage = "";
		
		FileWriter fw;
		FilterReader fr;
		int c;
		
		try {
			fw = new FileWriter("caesarReadTest.txt");
			
			fw.write("üABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäö");
			
			fw.close();
			
			fr = new CaesarReader(new FileReader("caesarReadTest.txt"), -1);
			
			while ((c = fr.read()) != -1) { 
				encryptMessage += (char)c;
			}
			
			fr.close();
			
			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void decryptAlphabetKeyMin58() {
		
		String encryptMessage = "";
		
		FileWriter fw;
		FilterReader fr;
		int c;
		
		try {
			fw = new FileWriter("caesarReadTest.txt");
			
			fw.write("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü");
			
			fw.close();
			
			fr = new CaesarReader(new FileReader("caesarReadTest.txt"), -58);
			
			while ((c = fr.read()) != -1) { 
				encryptMessage += (char)c;
			}
			
			fr.close();
			
			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void decryptAlphabetKeyMin57() {
		
		String encryptMessage = "";
		
		FileWriter fw;
		FilterReader fr;
		int c;
		
		try {
			fw = new FileWriter("caesarReadTest.txt");
			
			fw.write("BCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöüA");
			
			fw.close();
			
			fr = new CaesarReader(new FileReader("caesarReadTest.txt"), -57);
			
			while ((c = fr.read()) != -1) { 
				encryptMessage += (char)c;
			}
			
			fr.close();
			
			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void decryptAlphabetKeyMin59() {
		
		String encryptMessage = "";
		
		FileWriter fw;
		FilterReader fr;
		int c;
		
		try {
			fw = new FileWriter("caesarReadTest.txt");
			
			fw.write("üABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäö");
			
			fw.close();
			
			fr = new CaesarReader(new FileReader("caesarReadTest.txt"), -59);
			
			while ((c = fr.read()) != -1) { 
				encryptMessage += (char)c;
			}
			
			fr.close();
			
			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void decryptWordKey1() {
		
		String encryptMessage = "";
		
		FileWriter fw;
		FilterReader fr;
		int c;
		
		try {
			fw = new FileWriter("caesarReadTest.txt");
			
			fw.write("Qbusjdl-Hfzfs_Hsvqqf 1.1");
			
			fw.close();
			
			fr = new CaesarReader(new FileReader("caesarReadTest.txt"), 1);
			
			while ((c = fr.read()) != -1) { 
				encryptMessage += (char)c;
			}
			
			fr.close();
			
			assertEquals("Patrick-Geyer_Gruppe 1.1", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void decryptWordKey0() {
		
		String encryptMessage = "";
		
		FileWriter fw;
		FilterReader fr;
		int c;
		
		try {
			fw = new FileWriter("caesarReadTest.txt");
			
			fw.write("Patrick-Geyer_Gruppe 1.1");
			
			fw.close();
			
			fr = new CaesarReader(new FileReader("caesarReadTest.txt"), 0);
			
			while ((c = fr.read()) != -1) { 
				encryptMessage += (char)c;
			}
			
			fr.close();
			
			assertEquals("Patrick-Geyer_Gruppe 1.1", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void decryptWordKey58() {
		
		String encryptMessage = "";
		
		FileWriter fw;
		FilterReader fr;
		int c;
		
		try {
			fw = new FileWriter("caesarReadTest.txt");
			
			fw.write("Patrick-Geyer_Gruppe 1.1");
			
			fw.close();
			
			fr = new CaesarReader(new FileReader("caesarReadTest.txt"), 58);
			
			while ((c = fr.read()) != -1) { 
				encryptMessage += (char)c;
			}
			
			fr.close();
			
			assertEquals("Patrick-Geyer_Gruppe 1.1", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void decryptWordKey57() {
		
		String encryptMessage = "";
		
		FileWriter fw;
		FilterReader fr;
		int c;
		
		try {
			fw = new FileWriter("caesarReadTest.txt");
			
			fw.write("OZsqhbj-Fdxdq_Fqtood 1.1");
			
			fw.close();
			
			fr = new CaesarReader(new FileReader("caesarReadTest.txt"), 57);
			
			while ((c = fr.read()) != -1) { 
				encryptMessage += (char)c;
			}
			
			fr.close();
			
			assertEquals("Patrick-Geyer_Gruppe 1.1", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void decryptWordKey59() {
		
		String encryptMessage = "";
		
		FileWriter fw;
		FilterReader fr;
		int c;
		
		try {
			fw = new FileWriter("caesarReadTest.txt");
			
			fw.write("Qbusjdl-Hfzfs_Hsvqqf 1.1");
			
			fw.close();
			
			fr = new CaesarReader(new FileReader("caesarReadTest.txt"), 59);
			
			while ((c = fr.read()) != -1) { 
				encryptMessage += (char)c;
			}
			
			fr.close();
			
			assertEquals("Patrick-Geyer_Gruppe 1.1", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void decryptWordKeyMin1() {
		
		String encryptMessage = "";
		
		FileWriter fw;
		FilterReader fr;
		int c;
		
		try {
			fw = new FileWriter("caesarReadTest.txt");
			
			fw.write("OZsqhbj-Fdxdq_Fqtood 1.1");
			
			fw.close();
			
			fr = new CaesarReader(new FileReader("caesarReadTest.txt"), -1);
			
			while ((c = fr.read()) != -1) { 
				encryptMessage += (char)c;
			}
			
			fr.close();
			
			assertEquals("Patrick-Geyer_Gruppe 1.1", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void decryptWordKeyMin58() {
		
		String encryptMessage = "";
		
		FileWriter fw;
		FilterReader fr;
		int c;
		
		try {
			fw = new FileWriter("caesarReadTest.txt");
			
			fw.write("Patrick-Geyer_Gruppe 1.1");
			
			fw.close();
			
			fr = new CaesarReader(new FileReader("caesarReadTest.txt"), -58);
			
			while ((c = fr.read()) != -1) { 
				encryptMessage += (char)c;
			}
			
			fr.close();
			
			assertEquals("Patrick-Geyer_Gruppe 1.1", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void decryptWordKeyMin57() {
		
		String encryptMessage = "";
		
		FileWriter fw;
		FilterReader fr;
		int c;
		
		try {
			fw = new FileWriter("caesarReadTest.txt");
			
			fw.write("Qbusjdl-Hfzfs_Hsvqqf 1.1");
			
			fw.close();
			
			fr = new CaesarReader(new FileReader("caesarReadTest.txt"), -57);
			
			while ((c = fr.read()) != -1) { 
				encryptMessage += (char)c;
			}
			
			fr.close();
			
			assertEquals("Patrick-Geyer_Gruppe 1.1", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void decryptWordKeyMin59() {
		
		String encryptMessage = "";
		
		FileWriter fw;
		FilterReader fr;
		int c;
		
		try {
			fw = new FileWriter("caesarReadTest.txt");
			
			fw.write("OZsqhbj-Fdxdq_Fqtood 1.1");
			
			fw.close();
			
			fr = new CaesarReader(new FileReader("caesarReadTest.txt"), -59);
			
			while ((c = fr.read()) != -1) { 
				encryptMessage += (char)c;
			}
			
			fr.close();
			
			assertEquals("Patrick-Geyer_Gruppe 1.1", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}

}
