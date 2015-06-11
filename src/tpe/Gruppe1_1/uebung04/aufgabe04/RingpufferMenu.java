package tpe.Gruppe1_1.uebung04.aufgabe04;

import static gdi.MakeItSimple.println;
import static gdi.MakeItSimple.readInt;

public class RingpufferMenu extends Thread {

	static int size = 0;
	static int minutes = 0;
	static Ringpuffer puffer;
	static Thread timer;

	public static void main(String[] args) {

		while (size <= 0) {
			println("Geben Sie die Größe des Ringpuffers an: ");
			size = readInt();
		}
		puffer = new Ringpuffer(size);

		while (minutes <= 0) {
			println("Geben Sie die Dauer des Timers in Minuten an:");
			minutes = readInt();
			timer = new TimerThread(minutes);
		}
		
		
		Thread producerSlow = new ProducerThread(puffer, 10000);
		Thread producerNormal = new ProducerThread(puffer, 7000);
		Thread producerFast = new ProducerThread(puffer, 4000);
		
		Thread consumerSlow = new ConsumerThread(puffer, 10000);
		Thread consumerFast = new ConsumerThread(puffer, 4000);
		
		timer.setName("TimerThread");
		
		producerSlow.setName("ErzeugerThread langsame");
		producerNormal.setName("ErzeugerThread normal");
		producerFast.setName("ErzeugerThread schnell");
		
		consumerSlow.setName("VerbraucherThread langsam");
		consumerFast.setName("VerbaucherThread schnell");
		
		println("Die Threads laufen nun: " + minutes + " Minute/n");
		
		timer.start();
		producerSlow.start();
		producerNormal.start();
		producerFast.start();
		
		consumerSlow.start();
		consumerFast.start();
		

		while (timer.isAlive()){
			
		}
		
		producerSlow.interrupt();
		producerNormal.interrupt();
		producerFast.interrupt();
		consumerSlow.interrupt();
		consumerFast.interrupt();

		
		println("Das Programm wurde beendet");
	}
}
