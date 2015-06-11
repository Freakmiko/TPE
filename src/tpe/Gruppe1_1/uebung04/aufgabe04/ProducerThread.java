package tpe.Gruppe1_1.uebung04.aufgabe04;

import java.util.Random;

public class ProducerThread extends Thread {
	
	private Ringpuffer ringPuffer;
	private int time;
	private boolean run = true;
	Random random = new Random();

	ProducerThread(Ringpuffer ringPuffer, int time) {

		this.ringPuffer = ringPuffer;
		this.time = time;
	}

	/**
	 * It put one element into the Ringpuffer and print it on the console
	 * After this the thread sleep his time
	 */
	public synchronized void run() {
		while(run){
			try {
				synchronized (ringPuffer) {
					int tempObj = random.nextInt(100);
					
					if (ringPuffer.put(tempObj)) {
						System.out.println(this.getName() + " hat die Zahl " + tempObj + " in den Ringpuffer geschrieben");
					} else {
						System.out.println(this.getName() + " konnte keine Zahl in den Ringpuffer schreiben");
						ringPuffer.wait();
					}
				}
				sleep(time);
			} catch (InterruptedException e) {
				System.out.println(this.getName() + " wurde interrupted");
				run = false;
			}
		}
	}
}