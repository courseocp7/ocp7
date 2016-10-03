package javacourse.ocp.threads.O3Signaling.solution;

import java.util.LinkedList;
/**
 * 
 * @author Jose Blesa
 *
 */
public class EventStorage {

	private int maxSize;
	private LinkedList<Event> storage;

	public EventStorage(int maxSize) {

		this.maxSize = maxSize;
		storage = new LinkedList<Event>();
	}
	
	public synchronized void set(Event e) throws InterruptedException {
		
		while (storage.size() == maxSize){
			wait();
		}
		
		storage.offer(e);
		System.out.format("Set: %s %d%n", Thread.currentThread().getName(), storage.size());
		notifyAll();
	}
	
	public synchronized Event get() throws InterruptedException {
		
		while (storage.size() == 0){
			wait();
		}
		Event e = storage.poll();
		System.out.format("Get: %s %d%n", Thread.currentThread().getName(), storage.size());
		notifyAll();
		return e;
	}	
}