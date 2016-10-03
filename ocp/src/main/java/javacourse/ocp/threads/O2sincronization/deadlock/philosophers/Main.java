package javacourse.ocp.threads.O2sincronization.deadlock.philosophers;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		Philosopher[] philosophers = new Philosopher[5];
		Chopstick[] chopsticks = new Chopstick[5];

		for (int i = 0; i < 5; i++) {
			chopsticks[i] = new Chopstick(i);
		}
		for (int i = 0; i < 5; i++) {
			philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % 5]);
			philosophers[i].start();
		}
		
		while(isAlive(philosophers));
		
		/*
		for (int i = 0; i < 5; i++) {
			philosophers[i].join();
		}
		*/
	}
	
	private static boolean isAlive(Philosopher[] philosophers) throws InterruptedException{
		
		boolean isSomeoneAlive = false;
		Thread.sleep(2000);
		
		for(Thread t: philosophers ) {
			if(isSomeoneAlive = t.isAlive()){
				System.out.format("%s : %s%n", t.getName(), t.getState());
			}
			
		}
		return isSomeoneAlive;
	}

}
