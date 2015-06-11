package tpe.Gruppe1_1.uebung04.aufgabe04;

public class Ringpuffer {
	
	private Integer[] puffer;
	private int putIndex = 0;
	private int getIndex = 0;
	private boolean[] isWriteable;
	
	
	public Ringpuffer(int size){
		
		this.puffer = new Integer[size];
		this.isWriteable = new boolean[size];
		
		for (int i = 0; i != size; i++){
			this.isWriteable[i] = true;
		}
	}
	
	
	
	/**
	 * Put an Integer into the RingPuffer, if we have space.
	 * 
	 * @param obj The Integer to be put in.
	 * @return returns true if the insert was successful. Else we return false.
	 */
	public synchronized boolean put(int obj) {
		
		if(putIndex >= puffer.length){
			putIndex = putIndex%puffer.length;
		}
		
		if(isWriteable[putIndex]){
			
			puffer[putIndex] = obj;
			isWriteable[putIndex] = false;
			
			putIndex++;
			
			notifyAll();
			return true;
			
		}else{
			return false;
		}
		
	}
	
	/**
	 * Get a Integer inside the RingPuffer, at the read Index.
	 * 
	 * @return Returns the Integer at the read Index. Returns -1 if the cant read a new Integer
	 */
	public synchronized Integer get() {
		
		if(getIndex >= puffer.length){
			getIndex = getIndex%puffer.length;
		}
		
		if(!isWriteable[getIndex]){
			
			Integer tempObj = puffer[getIndex];
			isWriteable[getIndex] = true;
			getIndex++;
			
			notifyAll();
			return tempObj;
		}else{
			return -1;
		}
	}

}
