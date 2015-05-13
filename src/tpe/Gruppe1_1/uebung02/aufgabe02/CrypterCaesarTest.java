package tpe.Gruppe1_1.uebung02.aufgabe02;

import static org.junit.Assert.*;

import org.junit.Test;

public class CrypterCaesarTest {

	private Crypter crypter;
	
	@Test
	public void encryptAllLetterWithKey1() {
		
		crypter = new CrypterCaesar(1);
		
		assertEquals("B", crypter.encrypt("a"));
		assertEquals("C", crypter.encrypt("b"));
		assertEquals("D", crypter.encrypt("c"));
		assertEquals("E", crypter.encrypt("d"));
		assertEquals("F", crypter.encrypt("e"));
		assertEquals("G", crypter.encrypt("f"));
		assertEquals("H", crypter.encrypt("g"));
		assertEquals("I", crypter.encrypt("h"));
		assertEquals("J", crypter.encrypt("i"));
		assertEquals("K", crypter.encrypt("j"));
		assertEquals("L", crypter.encrypt("k"));
		assertEquals("M", crypter.encrypt("l"));
		assertEquals("N", crypter.encrypt("m"));
		assertEquals("O", crypter.encrypt("n"));
		assertEquals("P", crypter.encrypt("o"));
		assertEquals("Q", crypter.encrypt("p"));
		assertEquals("R", crypter.encrypt("q"));
		assertEquals("S", crypter.encrypt("r"));
		assertEquals("T", crypter.encrypt("s"));
		assertEquals("U", crypter.encrypt("t"));
		assertEquals("V", crypter.encrypt("u"));
		assertEquals("W", crypter.encrypt("v"));
		assertEquals("X", crypter.encrypt("w"));
		assertEquals("Y", crypter.encrypt("x"));
		assertEquals("Z", crypter.encrypt("y"));
		assertEquals("A", crypter.encrypt("z"));
		
		assertEquals("B", crypter.encrypt("A"));
		assertEquals("C", crypter.encrypt("B"));
		assertEquals("D", crypter.encrypt("C"));
		assertEquals("E", crypter.encrypt("D"));
		assertEquals("F", crypter.encrypt("E"));
		assertEquals("G", crypter.encrypt("F"));
		assertEquals("H", crypter.encrypt("G"));
		assertEquals("I", crypter.encrypt("H"));
		assertEquals("J", crypter.encrypt("I"));
		assertEquals("K", crypter.encrypt("J"));
		assertEquals("L", crypter.encrypt("K"));
		assertEquals("M", crypter.encrypt("L"));
		assertEquals("N", crypter.encrypt("M"));
		assertEquals("O", crypter.encrypt("N"));
		assertEquals("P", crypter.encrypt("O"));
		assertEquals("Q", crypter.encrypt("P"));
		assertEquals("R", crypter.encrypt("Q"));
		assertEquals("S", crypter.encrypt("R"));
		assertEquals("T", crypter.encrypt("S"));
		assertEquals("U", crypter.encrypt("T"));
		assertEquals("V", crypter.encrypt("U"));
		assertEquals("W", crypter.encrypt("V"));
		assertEquals("X", crypter.encrypt("W"));
		assertEquals("Y", crypter.encrypt("X"));
		assertEquals("Z", crypter.encrypt("Y"));
		assertEquals("A", crypter.encrypt("Z"));
		
	}
	

	
	
	@Test
	public void encryptAllLetterWithKey0() {
		
		crypter = new CrypterCaesar(0);
		
		assertEquals("A", crypter.encrypt("a"));
		assertEquals("B", crypter.encrypt("b"));
		assertEquals("C", crypter.encrypt("c"));
		assertEquals("D", crypter.encrypt("d"));
		assertEquals("E", crypter.encrypt("e"));
		assertEquals("F", crypter.encrypt("f"));
		assertEquals("G", crypter.encrypt("g"));
		assertEquals("H", crypter.encrypt("h"));
		assertEquals("I", crypter.encrypt("i"));
		assertEquals("J", crypter.encrypt("j"));
		assertEquals("K", crypter.encrypt("k"));
		assertEquals("L", crypter.encrypt("l"));
		assertEquals("M", crypter.encrypt("m"));
		assertEquals("N", crypter.encrypt("n"));
		assertEquals("O", crypter.encrypt("o"));
		assertEquals("P", crypter.encrypt("p"));
		assertEquals("Q", crypter.encrypt("q"));
		assertEquals("R", crypter.encrypt("r"));
		assertEquals("S", crypter.encrypt("s"));
		assertEquals("T", crypter.encrypt("t"));
		assertEquals("U", crypter.encrypt("u"));
		assertEquals("V", crypter.encrypt("v"));
		assertEquals("W", crypter.encrypt("w"));
		assertEquals("X", crypter.encrypt("x"));
		assertEquals("Y", crypter.encrypt("y"));
		assertEquals("Z", crypter.encrypt("z"));
		
		assertEquals("A", crypter.encrypt("A"));
		assertEquals("B", crypter.encrypt("B"));
		assertEquals("C", crypter.encrypt("C"));
		assertEquals("D", crypter.encrypt("D"));
		assertEquals("E", crypter.encrypt("E"));
		assertEquals("F", crypter.encrypt("F"));
		assertEquals("G", crypter.encrypt("G"));
		assertEquals("H", crypter.encrypt("H"));
		assertEquals("I", crypter.encrypt("I"));
		assertEquals("J", crypter.encrypt("J"));
		assertEquals("K", crypter.encrypt("K"));
		assertEquals("L", crypter.encrypt("L"));
		assertEquals("M", crypter.encrypt("M"));
		assertEquals("N", crypter.encrypt("N"));
		assertEquals("O", crypter.encrypt("O"));
		assertEquals("P", crypter.encrypt("P"));
		assertEquals("Q", crypter.encrypt("Q"));
		assertEquals("R", crypter.encrypt("R"));
		assertEquals("S", crypter.encrypt("S"));
		assertEquals("T", crypter.encrypt("T"));
		assertEquals("U", crypter.encrypt("U"));
		assertEquals("V", crypter.encrypt("V"));
		assertEquals("W", crypter.encrypt("W"));
		assertEquals("X", crypter.encrypt("X"));
		assertEquals("Y", crypter.encrypt("Y"));
		assertEquals("Z", crypter.encrypt("Z"));
		
	}
	
	@Test
	public void encryptAllLetterWithKey26() {
		
		crypter = new CrypterCaesar(26);
		
		assertEquals("A", crypter.encrypt("a"));
		assertEquals("B", crypter.encrypt("b"));
		assertEquals("C", crypter.encrypt("c"));
		assertEquals("D", crypter.encrypt("d"));
		assertEquals("E", crypter.encrypt("e"));
		assertEquals("F", crypter.encrypt("f"));
		assertEquals("G", crypter.encrypt("g"));
		assertEquals("H", crypter.encrypt("h"));
		assertEquals("I", crypter.encrypt("i"));
		assertEquals("J", crypter.encrypt("j"));
		assertEquals("K", crypter.encrypt("k"));
		assertEquals("L", crypter.encrypt("l"));
		assertEquals("M", crypter.encrypt("m"));
		assertEquals("N", crypter.encrypt("n"));
		assertEquals("O", crypter.encrypt("o"));
		assertEquals("P", crypter.encrypt("p"));
		assertEquals("Q", crypter.encrypt("q"));
		assertEquals("R", crypter.encrypt("r"));
		assertEquals("S", crypter.encrypt("s"));
		assertEquals("T", crypter.encrypt("t"));
		assertEquals("U", crypter.encrypt("u"));
		assertEquals("V", crypter.encrypt("v"));
		assertEquals("W", crypter.encrypt("w"));
		assertEquals("X", crypter.encrypt("x"));
		assertEquals("Y", crypter.encrypt("y"));
		assertEquals("Z", crypter.encrypt("z"));
		

		assertEquals("A", crypter.encrypt("A"));
		assertEquals("B", crypter.encrypt("B"));
		assertEquals("C", crypter.encrypt("C"));
		assertEquals("D", crypter.encrypt("D"));
		assertEquals("E", crypter.encrypt("E"));
		assertEquals("F", crypter.encrypt("F"));
		assertEquals("G", crypter.encrypt("G"));
		assertEquals("H", crypter.encrypt("H"));
		assertEquals("I", crypter.encrypt("I"));
		assertEquals("J", crypter.encrypt("J"));
		assertEquals("K", crypter.encrypt("K"));
		assertEquals("L", crypter.encrypt("L"));
		assertEquals("M", crypter.encrypt("M"));
		assertEquals("N", crypter.encrypt("N"));
		assertEquals("O", crypter.encrypt("O"));
		assertEquals("P", crypter.encrypt("P"));
		assertEquals("Q", crypter.encrypt("Q"));
		assertEquals("R", crypter.encrypt("R"));
		assertEquals("S", crypter.encrypt("S"));
		assertEquals("T", crypter.encrypt("T"));
		assertEquals("U", crypter.encrypt("U"));
		assertEquals("V", crypter.encrypt("V"));
		assertEquals("W", crypter.encrypt("W"));
		assertEquals("X", crypter.encrypt("X"));
		assertEquals("Y", crypter.encrypt("Y"));
		assertEquals("Z", crypter.encrypt("Z"));
	}
	
	@Test
	public void encryptAllLetterWithKey27() {
		
		crypter = new CrypterCaesar(27);
		
		assertEquals("B", crypter.encrypt("a"));
		assertEquals("C", crypter.encrypt("b"));
		assertEquals("D", crypter.encrypt("c"));
		assertEquals("E", crypter.encrypt("d"));
		assertEquals("F", crypter.encrypt("e"));
		assertEquals("G", crypter.encrypt("f"));
		assertEquals("H", crypter.encrypt("g"));
		assertEquals("I", crypter.encrypt("h"));
		assertEquals("J", crypter.encrypt("i"));
		assertEquals("K", crypter.encrypt("j"));
		assertEquals("L", crypter.encrypt("k"));
		assertEquals("M", crypter.encrypt("l"));
		assertEquals("N", crypter.encrypt("m"));
		assertEquals("O", crypter.encrypt("n"));
		assertEquals("P", crypter.encrypt("o"));
		assertEquals("Q", crypter.encrypt("p"));
		assertEquals("R", crypter.encrypt("q"));
		assertEquals("S", crypter.encrypt("r"));
		assertEquals("T", crypter.encrypt("s"));
		assertEquals("U", crypter.encrypt("t"));
		assertEquals("V", crypter.encrypt("u"));
		assertEquals("W", crypter.encrypt("v"));
		assertEquals("X", crypter.encrypt("w"));
		assertEquals("Y", crypter.encrypt("x"));
		assertEquals("Z", crypter.encrypt("y"));
		assertEquals("A", crypter.encrypt("z"));
		
		assertEquals("B", crypter.encrypt("A"));
		assertEquals("C", crypter.encrypt("B"));
		assertEquals("D", crypter.encrypt("C"));
		assertEquals("E", crypter.encrypt("D"));
		assertEquals("F", crypter.encrypt("E"));
		assertEquals("G", crypter.encrypt("F"));
		assertEquals("H", crypter.encrypt("G"));
		assertEquals("I", crypter.encrypt("H"));
		assertEquals("J", crypter.encrypt("I"));
		assertEquals("K", crypter.encrypt("J"));
		assertEquals("L", crypter.encrypt("K"));
		assertEquals("M", crypter.encrypt("L"));
		assertEquals("N", crypter.encrypt("M"));
		assertEquals("O", crypter.encrypt("N"));
		assertEquals("P", crypter.encrypt("O"));
		assertEquals("Q", crypter.encrypt("P"));
		assertEquals("R", crypter.encrypt("Q"));
		assertEquals("S", crypter.encrypt("R"));
		assertEquals("T", crypter.encrypt("S"));
		assertEquals("U", crypter.encrypt("T"));
		assertEquals("V", crypter.encrypt("U"));
		assertEquals("W", crypter.encrypt("V"));
		assertEquals("X", crypter.encrypt("W"));
		assertEquals("Y", crypter.encrypt("X"));
		assertEquals("Z", crypter.encrypt("Y"));
		assertEquals("A", crypter.encrypt("Z"));
	}
	
	@Test
	public void encryptAllLetterWithKey25() {
		
		crypter = new CrypterCaesar(25);
		
		assertEquals("Z", crypter.encrypt("a"));
		assertEquals("A", crypter.encrypt("b"));
		assertEquals("B", crypter.encrypt("c"));
		assertEquals("C", crypter.encrypt("d"));
		assertEquals("D", crypter.encrypt("e"));
		assertEquals("E", crypter.encrypt("f"));
		assertEquals("F", crypter.encrypt("g"));
		assertEquals("G", crypter.encrypt("h"));
		assertEquals("H", crypter.encrypt("i"));
		assertEquals("I", crypter.encrypt("j"));
		assertEquals("J", crypter.encrypt("k"));
		assertEquals("K", crypter.encrypt("l"));
		assertEquals("L", crypter.encrypt("m"));
		assertEquals("M", crypter.encrypt("n"));
		assertEquals("N", crypter.encrypt("o"));
		assertEquals("O", crypter.encrypt("p"));
		assertEquals("P", crypter.encrypt("q"));
		assertEquals("Q", crypter.encrypt("r"));
		assertEquals("R", crypter.encrypt("s"));
		assertEquals("S", crypter.encrypt("t"));
		assertEquals("T", crypter.encrypt("u"));
		assertEquals("U", crypter.encrypt("v"));
		assertEquals("V", crypter.encrypt("w"));
		assertEquals("W", crypter.encrypt("x"));
		assertEquals("X", crypter.encrypt("y"));
		assertEquals("Y", crypter.encrypt("z"));
		
		assertEquals("Z", crypter.encrypt("A"));
		assertEquals("A", crypter.encrypt("B"));
		assertEquals("B", crypter.encrypt("C"));
		assertEquals("C", crypter.encrypt("D"));
		assertEquals("D", crypter.encrypt("E"));
		assertEquals("E", crypter.encrypt("F"));
		assertEquals("F", crypter.encrypt("G"));
		assertEquals("G", crypter.encrypt("H"));
		assertEquals("H", crypter.encrypt("I"));
		assertEquals("I", crypter.encrypt("J"));
		assertEquals("J", crypter.encrypt("K"));
		assertEquals("K", crypter.encrypt("L"));
		assertEquals("L", crypter.encrypt("M"));
		assertEquals("M", crypter.encrypt("N"));
		assertEquals("N", crypter.encrypt("O"));
		assertEquals("O", crypter.encrypt("P"));
		assertEquals("P", crypter.encrypt("Q"));
		assertEquals("Q", crypter.encrypt("R"));
		assertEquals("R", crypter.encrypt("S"));
		assertEquals("S", crypter.encrypt("T"));
		assertEquals("T", crypter.encrypt("U"));
		assertEquals("U", crypter.encrypt("V"));
		assertEquals("V", crypter.encrypt("W"));
		assertEquals("W", crypter.encrypt("X"));
		assertEquals("X", crypter.encrypt("Y"));
		assertEquals("Y", crypter.encrypt("Z"));
	}
	
	@Test
	public void encryptWordsKey1() throws Exception {
		
		crypter = new CrypterCaesar(1);
		
		assertEquals("DBFTBS", crypter.encrypt("caesar"));
		assertEquals("QBUSJDL", crypter.encrypt("patrick"));
		assertEquals("NJDIBFM", crypter.encrypt("michael"));
		
		assertEquals("IBMMP XFMU!", crypter.encrypt("Hallo Welt!"));
		assertEquals("QBUSJDL-HFZFS-HSVQQF-1.1", crypter.encrypt("Patrick-Geyer-Gruppe-1.1"));
		
		assertEquals("ABC", crypter.encrypt("ZAB"));
		assertEquals("YZA", crypter.encrypt("XYZ"));
		
		assertEquals("", crypter.encrypt(""));	
		assertEquals(" ", crypter.encrypt(" "));	
	}
	
	
	@Test
	public void encryptWordsKey0() throws Exception {
		
		crypter = new CrypterCaesar(0);
		
		assertEquals("CAESAR", crypter.encrypt("caesar"));
		assertEquals("PATRICK", crypter.encrypt("patrick"));
		assertEquals("MICHAEL", crypter.encrypt("michael"));
		
		assertEquals("HALLO WELT!", crypter.encrypt("Hallo Welt!"));
		assertEquals("PATRICK-GEYER-GRUPPE-1.1", crypter.encrypt("Patrick-Geyer-Gruppe-1.1"));
		
		assertEquals("ZAB", crypter.encrypt("ZAB"));
		assertEquals("XYZ", crypter.encrypt("XYZ"));
		
		assertEquals("", crypter.encrypt(""));	
		assertEquals(" ", crypter.encrypt(" "));	
	}
	
	
	@Test
	public void encryptWordsKey26() throws Exception {
		
		crypter = new CrypterCaesar(0);
		
		assertEquals("CAESAR", crypter.encrypt("caesar"));
		assertEquals("PATRICK", crypter.encrypt("patrick"));
		assertEquals("MICHAEL", crypter.encrypt("michael"));
		
		assertEquals("HALLO WELT!", crypter.encrypt("Hallo Welt!"));
		assertEquals("PATRICK-GEYER-GRUPPE-1.1", crypter.encrypt("Patrick-Geyer-Gruppe-1.1"));
		
		assertEquals("ZAB", crypter.encrypt("ZAB"));
		assertEquals("XYZ", crypter.encrypt("XYZ"));
		
		assertEquals("", crypter.encrypt(""));	
		assertEquals(" ", crypter.encrypt(" "));	
		
	}
	
	@Test
	public void encryptWordsKey27() throws Exception {

		crypter = new CrypterCaesar(1);
		
		assertEquals("DBFTBS", crypter.encrypt("caesar"));
		assertEquals("QBUSJDL", crypter.encrypt("patrick"));
		assertEquals("NJDIBFM", crypter.encrypt("michael"));
		
		assertEquals("IBMMP XFMU!", crypter.encrypt("Hallo Welt!"));
		assertEquals("QBUSJDL-HFZFS-HSVQQF-1.1", crypter.encrypt("Patrick-Geyer-Gruppe-1.1"));
		
		assertEquals("ABC", crypter.encrypt("ZAB"));
		assertEquals("YZA", crypter.encrypt("XYZ"));
		
		assertEquals("", crypter.encrypt(""));	
		assertEquals(" ", crypter.encrypt(" "));
	}
	
	@Test
	public void encryptWordsKey25() throws Exception {
		
		crypter = new CrypterCaesar(25);
		
		assertEquals("BZDRZQ", crypter.encrypt("caesar"));
		assertEquals("OZSQHBJ", crypter.encrypt("patrick"));
		assertEquals("LHBGZDK", crypter.encrypt("michael"));
		
		assertEquals("GZKKN VDKS!", crypter.encrypt("Hallo Welt!"));
		assertEquals("OZSQHBJ-FDXDQ-FQTOOD-1.1", crypter.encrypt("Patrick-Geyer-Gruppe-1.1"));
		
		assertEquals("YZA", crypter.encrypt("ZAB"));
		assertEquals("WXY", crypter.encrypt("XYZ"));
		
		assertEquals("", crypter.encrypt(""));	
		assertEquals(" ", crypter.encrypt(" "));	
	}
		
	
	@Test
	public void decryptAllLetterWithKey1() {
		
		crypter = new CrypterCaesar(1);
		
		assertEquals("z", crypter.decrypt("A"));
		assertEquals("a", crypter.decrypt("B"));
		assertEquals("b", crypter.decrypt("C"));
		assertEquals("c", crypter.decrypt("D"));
		assertEquals("d", crypter.decrypt("E"));
		assertEquals("e", crypter.decrypt("F"));
		assertEquals("f", crypter.decrypt("G"));
		assertEquals("g", crypter.decrypt("H"));
		assertEquals("h", crypter.decrypt("I"));
		assertEquals("i", crypter.decrypt("J"));
		assertEquals("j", crypter.decrypt("K"));
		assertEquals("k", crypter.decrypt("L"));
		assertEquals("l", crypter.decrypt("M"));
		assertEquals("m", crypter.decrypt("N"));
		assertEquals("n", crypter.decrypt("O"));
		assertEquals("o", crypter.decrypt("P"));
		assertEquals("p", crypter.decrypt("Q"));
		assertEquals("q", crypter.decrypt("R"));
		assertEquals("r", crypter.decrypt("S"));
		assertEquals("s", crypter.decrypt("T"));
		assertEquals("t", crypter.decrypt("U"));
		assertEquals("u", crypter.decrypt("V"));
		assertEquals("v", crypter.decrypt("W"));
		assertEquals("w", crypter.decrypt("X"));
		assertEquals("x", crypter.decrypt("Y"));
		assertEquals("y", crypter.decrypt("Z"));
		
	}
	
	
	@Test
	public void decryptAllLetterWithKey0() {
		
		crypter = new CrypterCaesar(0);
		
		assertEquals("a", crypter.decrypt("A"));
		assertEquals("b", crypter.decrypt("B"));
		assertEquals("c", crypter.decrypt("C"));
		assertEquals("d", crypter.decrypt("D"));
		assertEquals("e", crypter.decrypt("E"));
		assertEquals("f", crypter.decrypt("F"));
		assertEquals("g", crypter.decrypt("G"));
		assertEquals("h", crypter.decrypt("H"));
		assertEquals("i", crypter.decrypt("I"));
		assertEquals("j", crypter.decrypt("J"));
		assertEquals("k", crypter.decrypt("K"));
		assertEquals("l", crypter.decrypt("L"));
		assertEquals("m", crypter.decrypt("M"));
		assertEquals("n", crypter.decrypt("N"));
		assertEquals("o", crypter.decrypt("O"));
		assertEquals("p", crypter.decrypt("P"));
		assertEquals("q", crypter.decrypt("Q"));
		assertEquals("r", crypter.decrypt("R"));
		assertEquals("s", crypter.decrypt("S"));
		assertEquals("t", crypter.decrypt("T"));
		assertEquals("u", crypter.decrypt("U"));
		assertEquals("v", crypter.decrypt("V"));
		assertEquals("w", crypter.decrypt("W"));
		assertEquals("x", crypter.decrypt("X"));
		assertEquals("y", crypter.decrypt("Y"));
		assertEquals("z", crypter.decrypt("Z"));
		
	}
	
	@Test
	public void decryptAllLetterWithKey26() {
		
		crypter = new CrypterCaesar(26);
		
		assertEquals("a", crypter.decrypt("A"));
		assertEquals("b", crypter.decrypt("B"));
		assertEquals("c", crypter.decrypt("C"));
		assertEquals("d", crypter.decrypt("D"));
		assertEquals("e", crypter.decrypt("E"));
		assertEquals("f", crypter.decrypt("F"));
		assertEquals("g", crypter.decrypt("G"));
		assertEquals("h", crypter.decrypt("H"));
		assertEquals("i", crypter.decrypt("I"));
		assertEquals("j", crypter.decrypt("J"));
		assertEquals("k", crypter.decrypt("K"));
		assertEquals("l", crypter.decrypt("L"));
		assertEquals("m", crypter.decrypt("M"));
		assertEquals("n", crypter.decrypt("N"));
		assertEquals("o", crypter.decrypt("O"));
		assertEquals("p", crypter.decrypt("P"));
		assertEquals("q", crypter.decrypt("Q"));
		assertEquals("r", crypter.decrypt("R"));
		assertEquals("s", crypter.decrypt("S"));
		assertEquals("t", crypter.decrypt("T"));
		assertEquals("u", crypter.decrypt("U"));
		assertEquals("v", crypter.decrypt("V"));
		assertEquals("w", crypter.decrypt("W"));
		assertEquals("x", crypter.decrypt("X"));
		assertEquals("y", crypter.decrypt("Y"));
		assertEquals("z", crypter.decrypt("Z"));
		
	}
	
	@Test
	public void decryptAllLetterWithKey27() {
		
		crypter = new CrypterCaesar(27);
		
		assertEquals("z", crypter.decrypt("A"));
		assertEquals("a", crypter.decrypt("B"));
		assertEquals("b", crypter.decrypt("C"));
		assertEquals("c", crypter.decrypt("D"));
		assertEquals("d", crypter.decrypt("E"));
		assertEquals("e", crypter.decrypt("F"));
		assertEquals("f", crypter.decrypt("G"));
		assertEquals("g", crypter.decrypt("H"));
		assertEquals("h", crypter.decrypt("I"));
		assertEquals("i", crypter.decrypt("J"));
		assertEquals("j", crypter.decrypt("K"));
		assertEquals("k", crypter.decrypt("L"));
		assertEquals("l", crypter.decrypt("M"));
		assertEquals("m", crypter.decrypt("N"));
		assertEquals("n", crypter.decrypt("O"));
		assertEquals("o", crypter.decrypt("P"));
		assertEquals("p", crypter.decrypt("Q"));
		assertEquals("q", crypter.decrypt("R"));
		assertEquals("r", crypter.decrypt("S"));
		assertEquals("s", crypter.decrypt("T"));
		assertEquals("t", crypter.decrypt("U"));
		assertEquals("u", crypter.decrypt("V"));
		assertEquals("v", crypter.decrypt("W"));
		assertEquals("w", crypter.decrypt("X"));
		assertEquals("x", crypter.decrypt("Y"));
		assertEquals("y", crypter.decrypt("Z"));
		
	}
	
	@Test
	public void decryptAllLetterWithKey25() {
		
		crypter = new CrypterCaesar(25);
		
		assertEquals("b", crypter.decrypt("A"));
		assertEquals("c", crypter.decrypt("B"));
		assertEquals("d", crypter.decrypt("C"));
		assertEquals("e", crypter.decrypt("D"));
		assertEquals("f", crypter.decrypt("E"));
		assertEquals("g", crypter.decrypt("F"));
		assertEquals("h", crypter.decrypt("G"));
		assertEquals("i", crypter.decrypt("H"));
		assertEquals("j", crypter.decrypt("I"));
		assertEquals("k", crypter.decrypt("J"));
		assertEquals("l", crypter.decrypt("K"));
		assertEquals("m", crypter.decrypt("L"));
		assertEquals("n", crypter.decrypt("M"));
		assertEquals("o", crypter.decrypt("N"));
		assertEquals("p", crypter.decrypt("O"));
		assertEquals("q", crypter.decrypt("P"));
		assertEquals("r", crypter.decrypt("Q"));
		assertEquals("s", crypter.decrypt("R"));
		assertEquals("t", crypter.decrypt("S"));
		assertEquals("u", crypter.decrypt("T"));
		assertEquals("v", crypter.decrypt("U"));
		assertEquals("w", crypter.decrypt("V"));
		assertEquals("x", crypter.decrypt("W"));
		assertEquals("y", crypter.decrypt("X"));
		assertEquals("z", crypter.decrypt("Y"));
		assertEquals("a", crypter.decrypt("Z"));
		
	}
	
	@Test
	public void decryptWordsKey1() throws Exception {
		
		crypter = new CrypterCaesar(1);
		
		assertEquals("caesar", crypter.decrypt("DBFTBS"));
		assertEquals("patrick", crypter.decrypt("QBUSJDL"));
		assertEquals("michael", crypter.decrypt("NJDIBFM"));
		
		assertEquals("gallo velt!", crypter.decrypt("HBMMP WFMU!"));
		assertEquals("oatrick-feyer-fruppe-1.1", crypter.decrypt("PBUSJDL-GFZFS-GSVQQF-1.1"));
		
		assertEquals("", crypter.decrypt(""));	
		assertEquals(" ", crypter.decrypt(" "));	
	}
	
	
	@Test
	public void decryptWordsKey0() throws Exception {
		
		crypter = new CrypterCaesar(0);
		
		assertEquals("caesar", crypter.decrypt("CAESAR"));
		assertEquals("patrick", crypter.decrypt("PATRICK"));
		assertEquals("michael", crypter.decrypt("MICHAEL"));
		
		assertEquals("hallo welt!", crypter.decrypt("HALLO WELT!"));
		assertEquals("patrick-geyer-gruppe-1.1", crypter.decrypt("PATRICK-GEYER-GRUPPE-1.1"));
		
		assertEquals("", crypter.decrypt(""));	
		assertEquals(" ", crypter.decrypt(" "));	
	}
	
	@Test
	public void decryptWordsKey26() throws Exception {
		
		crypter = new CrypterCaesar(26);
		
		assertEquals("caesar", crypter.decrypt("CAESAR"));
		assertEquals("patrick", crypter.decrypt("PATRICK"));
		assertEquals("michael", crypter.decrypt("MICHAEL"));
		
		assertEquals("hallo welt!", crypter.decrypt("HALLO WELT!"));
		assertEquals("patrick-geyer-gruppe-1.1", crypter.decrypt("PATRICK-GEYER-GRUPPE-1.1"));
		
		assertEquals("", crypter.decrypt(""));	
		assertEquals(" ", crypter.decrypt(" "));	
	}
	
	@Test
	public void decryptWordsKey27() throws Exception {
		
		crypter = new CrypterCaesar(27);
		
		assertEquals("caesar", crypter.decrypt("DBFTBS"));
		assertEquals("patrick", crypter.decrypt("QBUSJDL"));
		assertEquals("michael", crypter.decrypt("NJDIBFM"));
		
		assertEquals("gallo velt!", crypter.decrypt("HBMMP WFMU!"));
		assertEquals("oatrick-feyer-fruppe-1.1", crypter.decrypt("PBUSJDL-GFZFS-GSVQQF-1.1"));
		
		assertEquals("", crypter.decrypt(""));	
		assertEquals(" ", crypter.decrypt(" "));	
	}
	
	@Test
	public void decryptWordsKey25() throws Exception {
		
		crypter = new CrypterCaesar(25);
		
		assertEquals("caesar", crypter.decrypt("BZDRZQ"));
		assertEquals("patrick", crypter.decrypt("OZSQHBJ"));
		assertEquals("michael", crypter.decrypt("LHBGZDK"));
		
		assertEquals("iallo xelt!", crypter.decrypt("HZKKN WDKS!"));
		assertEquals("qatrick-heyer-hruppe-1.1", crypter.decrypt("PZSQHBJ-GDXDQ-GQTOOD-1.1"));
		
		assertEquals("", crypter.decrypt(""));	
		assertEquals(" ", crypter.decrypt(" "));	
	}
		

}
