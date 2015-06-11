package tpe.Gruppe1_1.uebung04.aufgabe04;

import static org.junit.Assert.*;

import org.junit.*;

public class RingpufferTest {

	private Ringpuffer puffer;

	

	@Test
	public void fillRingpuffer4full() throws Exception {
		puffer = new Ringpuffer(4);
		
		puffer.put(1);
		puffer.put(2);
		puffer.put(3);
		puffer.put(4);
		
		assertEquals(new Integer(1), puffer.get());
		assertEquals(new Integer(2), puffer.get());
		assertEquals(new Integer(3), puffer.get());
		assertEquals(new Integer(4), puffer.get());
	}
	
	@Test
	public void fillInFullRingpuffer4() throws Exception {
		puffer = new Ringpuffer(4);
		
		puffer.put(1);
		puffer.put(2);
		puffer.put(3);
		puffer.put(4);
		
		assertEquals(false, puffer.put(5));
	}

	@Test
	public void get5InRingpuffer4full() throws Exception {
		puffer = new Ringpuffer(4);
		
		puffer.put(1);
		puffer.put(2);
		puffer.put(3);
		puffer.put(4);
		
		assertEquals(new Integer(1), puffer.get());
		assertEquals(new Integer(2), puffer.get());
		assertEquals(new Integer(3), puffer.get());
		assertEquals(new Integer(4), puffer.get());
		assertEquals(new Integer(-1), puffer.get());
	}
	
	@Test
	public void fillRingpuffer4half() throws Exception {
		puffer = new Ringpuffer(4);
		
		puffer.put(1);
		puffer.put(2);
		
		assertEquals(new Integer(1), puffer.get());
		assertEquals(new Integer(2), puffer.get());
		assertEquals(new Integer(-1), puffer.get());
	}
	
	@Test
	public void fillRingpuffer4fullTake1AndFillAgain() throws Exception {
		puffer = new Ringpuffer(4);
		
		puffer.put(1);
		puffer.put(2);
		puffer.put(3);
		puffer.put(4);
		
		assertEquals(new Integer(1), puffer.get());
		assertEquals(new Integer(2), puffer.get());
		
		puffer.put(5);
		puffer.put(6);
		
		assertEquals(new Integer(3), puffer.get());
		assertEquals(new Integer(4), puffer.get());
		assertEquals(new Integer(5), puffer.get());
		assertEquals(new Integer(6), puffer.get());
		assertEquals(new Integer(-1), puffer.get());
	}
}