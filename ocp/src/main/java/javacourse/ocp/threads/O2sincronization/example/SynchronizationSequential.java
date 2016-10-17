package javacourse.ocp.threads.O2sincronization.example;

import java.util.concurrent.TimeUnit;

public class SynchronizationSequential extends Thread {

	public void run() {

		synchronized (this) {
			System.out.printf("%s doing something...%n", Thread.currentThread().getName());
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.printf("%s done!...%n", Thread.currentThread().getName());
		}

	}

	public static void main(String[] args) throws InterruptedException {

		SynchronizationSequential task = new SynchronizationSequential();
		SynchronizationSequential task2 = new SynchronizationSequential();

		Thread worker1 = new Thread(task, "worker1");
		Thread worker2 = new Thread(task, "worker2");

		worker1.start();
		worker2.start();
		
		do {
			System.out.printf("%s is %s -  %s is %s%n", worker1.getName(), worker1.getState(), worker2.getName(),
					worker2.getState());
			TimeUnit.MILLISECONDS.sleep(100);

		} while (worker1.isAlive() && worker2.isAlive());


		/*
		task.start();
		task2.start();
		
		do {
			System.out.printf("%s is %s -  %s is %s%n", task.getName(), task.getState(), task2.getName(),
					task2.getState());
			TimeUnit.MILLISECONDS.sleep(100);

		} while (task.isAlive() && task2.isAlive());
		*/
		
	}

}
