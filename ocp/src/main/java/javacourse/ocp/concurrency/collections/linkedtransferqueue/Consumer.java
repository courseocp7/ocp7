package javacourse.ocp.concurrency.collections.linkedtransferqueue;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {

	protected TransferQueue<String> transferQueue;

	public Consumer(TransferQueue<String> queue) {
		this.transferQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				String data = transferQueue.take();
				System.out.println(Thread.currentThread().getName() + " take(): " + data);
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
