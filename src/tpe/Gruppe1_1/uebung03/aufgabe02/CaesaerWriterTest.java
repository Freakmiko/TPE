package tpe.Gruppe1_1.uebung03.aufgabe02;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.Test;

public class CaesaerWriterTest {

	@Test
	public void encryptAlphabetKey1() {
		
		String encryptMessage = "";
		
		PrintWriter  pw;
		BufferedReader br;
		
		try {
			pw = new PrintWriter(new CaesarWriter (new FileWriter("caesarWriteTest.txt"), 1));
			
			pw.write("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü");
			
			pw.close();
			
			br = new BufferedReader(new FileReader("caesarWriteTest.txt"));
			
			encryptMessage = br.readLine();
			
			br.close();
			
			assertEquals("BCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöüA", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void encryptAlphabetKey0() {
		
		String encryptMessage = "";
		
		PrintWriter  pw;
		BufferedReader br;
		
		try {
			pw = new PrintWriter(new CaesarWriter (new FileWriter("caesarWriteTest.txt"), 0));
			
			pw.write("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü");
			
			pw.close();
			
			br = new BufferedReader(new FileReader("caesarWriteTest.txt"));
			
			encryptMessage = br.readLine();
			
			br.close();
			
			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void encryptAlphabetKey58() {
		
		String encryptMessage = "";
		
		PrintWriter  pw;
		BufferedReader br;
		
		try {
			pw = new PrintWriter(new CaesarWriter (new FileWriter("caesarWriteTest.txt"), 58));
			
			pw.write("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü");
			
			pw.close();
			
			br = new BufferedReader(new FileReader("caesarWriteTest.txt"));
			
			encryptMessage = br.readLine();
			
			br.close();
			
			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void encryptAlphabetKey57() {
		
		String encryptMessage = "";
		
		PrintWriter  pw;
		BufferedReader br;
		
		try {
			pw = new PrintWriter(new CaesarWriter (new FileWriter("caesarWriteTest.txt"), 57));
			
			pw.write("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü");
			
			pw.close();
			
			br = new BufferedReader(new FileReader("caesarWriteTest.txt"));
			
			encryptMessage = br.readLine();
			
			br.close();
			
			assertEquals("üABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäö", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void encryptAlphabetKey59() {
		
		String encryptMessage = "";
		
		PrintWriter  pw;
		BufferedReader br;
		
		try {
			pw = new PrintWriter(new CaesarWriter (new FileWriter("caesarWriteTest.txt"), 59));
			
			pw.write("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü");
			
			pw.close();
			
			br = new BufferedReader(new FileReader("caesarWriteTest.txt"));
			
			encryptMessage = br.readLine();
			
			br.close();
			
			assertEquals("BCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöüA", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void encryptAlphabetKeyMin1() {
		
		String encryptMessage = "";
		
		PrintWriter  pw;
		BufferedReader br;
		
		try {
			pw = new PrintWriter(new CaesarWriter (new FileWriter("caesarWriteTest.txt"), -1));
			
			pw.write("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü");
			
			pw.close();
			
			br = new BufferedReader(new FileReader("caesarWriteTest.txt"));
			
			encryptMessage = br.readLine();
			
			br.close();
			
			assertEquals("üABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäö", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void encryptAlphabetKeyMin58() {
		
		String encryptMessage = "";
		
		PrintWriter  pw;
		BufferedReader br;
		
		try {
			pw = new PrintWriter(new CaesarWriter (new FileWriter("caesarWriteTest.txt"), -58));
			
			pw.write("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü");
			
			pw.close();
			
			br = new BufferedReader(new FileReader("caesarWriteTest.txt"));
			
			encryptMessage = br.readLine();
			
			br.close();
			
			assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void encryptAlphabetKeyMin57() {
		
		String encryptMessage = "";
		
		PrintWriter  pw;
		BufferedReader br;
		
		try {
			pw = new PrintWriter(new CaesarWriter (new FileWriter("caesarWriteTest.txt"), -57));
			
			pw.write("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü");
			
			pw.close();
			
			br = new BufferedReader(new FileReader("caesarWriteTest.txt"));
			
			encryptMessage = br.readLine();
			
			br.close();
			
			assertEquals("BCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöüA", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void encryptAlphabetKeyMin59() {
		
		String encryptMessage = "";
		
		PrintWriter  pw;
		BufferedReader br;
		
		try {
			pw = new PrintWriter(new CaesarWriter (new FileWriter("caesarWriteTest.txt"), -59));
			
			pw.write("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäöü");
			
			pw.close();
			
			br = new BufferedReader(new FileReader("caesarWriteTest.txt"));
			
			encryptMessage = br.readLine();
			
			br.close();
			
			assertEquals("üABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzÄÖÜäö", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void encryptWordsKey1() {
		
		String encryptMessage = "";
		
		PrintWriter  pw;
		BufferedReader br;
		
		try {
			pw = new PrintWriter(new CaesarWriter (new FileWriter("caesarWriteTest.txt"), 1));
			
			pw.write("Patrick-Geyer_Gruppe 1.1");
			
			pw.close();
			
			br = new BufferedReader(new FileReader("caesarWriteTest.txt"));
			
			encryptMessage = br.readLine();
			
			br.close();
			
			assertEquals("Qbusjdl-Hfzfs_Hsvqqf 1.1", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void encryptWordsKey0() {
		
		String encryptMessage = "";
		
		PrintWriter  pw;
		BufferedReader br;
		
		try {
			pw = new PrintWriter(new CaesarWriter (new FileWriter("caesarWriteTest.txt"), 0));
			
			pw.write("Patrick-Geyer_Gruppe 1.1");
			
			pw.close();
			
			br = new BufferedReader(new FileReader("caesarWriteTest.txt"));
			
			encryptMessage = br.readLine();
			
			br.close();
			
			assertEquals("Patrick-Geyer_Gruppe 1.1", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void encryptWordsKey58() {
		
		String encryptMessage = "";
		
		PrintWriter  pw;
		BufferedReader br;
		
		try {
			pw = new PrintWriter(new CaesarWriter (new FileWriter("caesarWriteTest.txt"), 58));
			
			pw.write("Patrick-Geyer_Gruppe 1.1");
			
			pw.close();
			
			br = new BufferedReader(new FileReader("caesarWriteTest.txt"));
			
			encryptMessage = br.readLine();
			
			br.close();
			
			assertEquals("Patrick-Geyer_Gruppe 1.1", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void encryptWordsKey57() {
		
		String encryptMessage = "";
		
		PrintWriter  pw;
		BufferedReader br;
		
		try {
			pw = new PrintWriter(new CaesarWriter (new FileWriter("caesarWriteTest.txt"), 57));
			
			pw.write("Patrick-Geyer_Gruppe 1.1");
			
			pw.close();
			
			br = new BufferedReader(new FileReader("caesarWriteTest.txt"));
			
			encryptMessage = br.readLine();
			
			br.close();
			
			assertEquals("OZsqhbj-Fdxdq_Fqtood 1.1", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void encryptWordsKey59() {
		
		String encryptMessage = "";
		
		PrintWriter  pw;
		BufferedReader br;
		
		try {
			pw = new PrintWriter(new CaesarWriter (new FileWriter("caesarWriteTest.txt"), 59));
			
			pw.write("Patrick-Geyer_Gruppe 1.1");
			
			pw.close();
			
			br = new BufferedReader(new FileReader("caesarWriteTest.txt"));
			
			encryptMessage = br.readLine();
			
			br.close();
			
			assertEquals("Qbusjdl-Hfzfs_Hsvqqf 1.1", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void encryptWordsKeyMin1() {
		
		String encryptMessage = "";
		
		PrintWriter  pw;
		BufferedReader br;
		
		try {
			pw = new PrintWriter(new CaesarWriter (new FileWriter("caesarWriteTest.txt"), -1));
			
			pw.write("Patrick-Geyer_Gruppe 1.1");
			
			pw.close();
			
			br = new BufferedReader(new FileReader("caesarWriteTest.txt"));
			
			encryptMessage = br.readLine();
			
			br.close();
			
			assertEquals("OZsqhbj-Fdxdq_Fqtood 1.1", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void encryptWordsKeyMin58() {
		
		String encryptMessage = "";
		
		PrintWriter  pw;
		BufferedReader br;
		
		try {
			pw = new PrintWriter(new CaesarWriter (new FileWriter("caesarWriteTest.txt"), -58));
			
			pw.write("Patrick-Geyer_Gruppe 1.1");
			
			pw.close();
			
			br = new BufferedReader(new FileReader("caesarWriteTest.txt"));
			
			encryptMessage = br.readLine();
			
			br.close();
			
			assertEquals("Patrick-Geyer_Gruppe 1.1", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void encryptWordsKeyMin57() {
		
		String encryptMessage = "";
		
		PrintWriter  pw;
		BufferedReader br;
		
		try {
			pw = new PrintWriter(new CaesarWriter (new FileWriter("caesarWriteTest.txt"), -57));
			
			pw.write("Patrick-Geyer_Gruppe 1.1");
			
			pw.close();
			
			br = new BufferedReader(new FileReader("caesarWriteTest.txt"));
			
			encryptMessage = br.readLine();
			
			br.close();
			
			assertEquals("Qbusjdl-Hfzfs_Hsvqqf 1.1", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}
	
	@Test
	public void encryptWordsKeyMin59() {
		
		String encryptMessage = "";
		
		PrintWriter  pw;
		BufferedReader br;
		
		try {
			pw = new PrintWriter(new CaesarWriter (new FileWriter("caesarWriteTest.txt"), -59));
			
			pw.write("Patrick-Geyer_Gruppe 1.1");
			
			pw.close();
			
			br = new BufferedReader(new FileReader("caesarWriteTest.txt"));
			
			encryptMessage = br.readLine();
			
			br.close();
			
			assertEquals("OZsqhbj-Fdxdq_Fqtood 1.1", encryptMessage);
			
			
		} catch (IOException e) {
			System.out.println("Fehler mit der Datei");
		}
		
	}

}
