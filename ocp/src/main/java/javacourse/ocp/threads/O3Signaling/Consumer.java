package javacourse.ocp.threads.O3Signaling;

import java.util.Random;

/**
 * 
 * @author Jose Blesa
 *
 */
public class Consumer implements Runnable {

	private EventStorage storage;

	public Consumer(EventStorage storage) {
		this.storage = storage;
	}

	@Override
	public void run() {
		
		Random rnd = new Random();
		
		while(true){
			try {
				Thread.sleep(rnd.nextInt(10) * 1000);
				storage.get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

}
