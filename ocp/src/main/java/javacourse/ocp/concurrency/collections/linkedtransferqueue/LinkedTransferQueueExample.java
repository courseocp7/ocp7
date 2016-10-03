package javacourse.ocp.concurrency.collections.linkedtransferqueue;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

public class LinkedTransferQueueExample {

	public static void main(String[] args) {
		final TransferQueue<String> transferQueue = new LinkedTransferQueue<String>();

		Producer producer = new Producer(transferQueue);
		new Thread(producer).start();

		Consumer consumer1 = new Consumer(transferQueue);
		new Thread(consumer1).start();

		Consumer consumer2 = new Consumer(transferQueue);
		new Thread(consumer2).start();
	}
}