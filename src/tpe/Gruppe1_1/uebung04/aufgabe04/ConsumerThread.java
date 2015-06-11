package tpe.Gruppe1_1.uebung04.aufgabe04;

public class ConsumerThread extends Thread {
	
	private Ringpuffer ringPuffer;
	private int time;
	private boolean run = true;

	
	ConsumerThread(Ringpuffer ringPuffer, int time) {
		
		this.ringPuffer = ringPuffer;
		this.time = time;
	}
	
	
	/**
	 * Read one Integer from the Ringpuffer and print it on the console
	 * After this the thread sleep his time
	 */
	public synchronized void run() {
		while(run){
			try {	
				synchronized (ringPuffer) {
					int obj = ringPuffer.get();
	
					if (obj != -1) {
						System.out.println(this.getName() + " hat die Zahl: " + obj + " aus dem Ringpuffer gelesen");
					} else {
						System.out.println(this.getName() + " konnte keine Zahl aus dem Ringpuffer gelesen werden");
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

