package tpe.Gruppe1_1.uebung04.aufgabe04;

public class TimerThread extends Thread {

	private int time;
	
	
	TimerThread(int time) {
		this.time = time*60000;
	}
	
	/**
	 * this Thread is waiting the time in minutes.
	 */
	public synchronized void run() {

		try {
			sleep(time);
		} catch (InterruptedException e) {
			System.out.println(this.getName() + " wurde interrupted");
		}

	}
}