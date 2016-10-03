package javacourse.ocp.threads.O3Signaling.solution;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		
		EventStorage storage = new EventStorage(10);
		
		Producer producer = new Producer(storage);
		Consumer consumer = new Consumer(storage);
		
		Thread t0 = new Thread(producer, "Producer01");
		Thread t1 = new Thread(consumer, "Consumer01");
		
		t0.start(); t1.start();
		t0.join(); t1.join();
		/*
		while(t0.isAlive() || t1.isAlive() ){
			Thread.sleep(5000);
			
			System.out.format("%s %s%n", t0.getName(), t0.getState());
			System.out.format("%s %s%n", t1.getName(), t1.getState());
		}
		*/
		
		
		
		
		
	}

}
