package javacourse.ocp.threads.O3Signaling.solution;

import java.util.Random;

/**
 * 
 * @author Jose Maria
 *
 */
public class Producer implements Runnable {

	private EventStorage storage;

	public Producer(EventStorage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {

		Random rnd = new Random();

		while(true){
			try {
				Thread.sleep(rnd.nextInt(10) * 1000);
				storage.set(new Event(Thread.currentThread().getName() + rnd.nextInt(10000)));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
