package javacourse.ocp.threads.O2sincronization.example;

import java.util.concurrent.TimeUnit;

public class SynchronizationVisibility extends Thread {

	private volatile boolean stop;

	public void run() {

		//synchronized (this) {
			while (!stop) {
				try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.printf("%s doing something...%n", Thread.currentThread().getName());
			}
		//}
	}

	public /*synchronized*/ void stopThread() {
		stop = true;
		System.out.printf("%s setting stop flag to %b...%n", Thread.currentThread().getName(), stop);
	}

	public static void main(String[] args) throws InterruptedException {

		SynchronizationVisibility task = new SynchronizationVisibility();

		/*
		Thread worker1 = new Thread(task, "worker1");
		Thread worker2 = new Thread(task, "worker2");
		
		worker1.start();
		worker2.start();
		*/
		
		task.start();
		
		TimeUnit.SECONDS.sleep(3);
		task.stopThread();

	}

}
