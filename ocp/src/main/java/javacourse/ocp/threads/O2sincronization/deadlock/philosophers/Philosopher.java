package javacourse.ocp.threads.O2sincronization.deadlock.philosophers;

import java.util.Random;

public class Philosopher extends Thread {

	private int id;
	private Chopstick left, right;
	private Random random;

	public Philosopher(int id, Chopstick left, Chopstick right) {
		this.id = id;
		this.left = left;
		this.right = right;
		random = new Random();
	}

	@Override
	public void run() {

		try {
			Thread.sleep(random.nextInt(10)); //Thinking...
			while (true) {
				synchronized (left) { // Grab left  chopstick...
					System.out.printf("p%s -> c%s\n", id, left.getId());
                    synchronized (right) { // Grab right chopstick...
                    	System.out.printf("p%s -> c%s\n", id, right.getId());					
                    	Thread.sleep(random.nextInt(1000)); //eating...
                    }
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}