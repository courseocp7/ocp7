package javacourse.ocp.threads.O3Signaling;

import java.util.LinkedList;
/**
 * 
 * @author Jose Blesa
 *
 */
public class EventStorageImpl implements EventStorage {

	private int maxSize;
	private LinkedList<Event> storage;

	public EventStorageImpl(int maxSize) {

		this.maxSize = maxSize;
		storage = new LinkedList<Event>();
	}

	@Override
	public void set(Event e) throws InterruptedException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Event get() throws InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}
}