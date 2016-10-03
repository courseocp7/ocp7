package javacourse.ocp.concurrency.collections.linkedtransferqueue;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {

	protected TransferQueue<String> transferQueue;
	final Random random = new Random();

	public Producer(TransferQueue<String> queue) {
		this.transferQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String data = UUID.randomUUID().toString();
				System.out.println("Put: " + data);
				transferQueue.transfer(data);
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
