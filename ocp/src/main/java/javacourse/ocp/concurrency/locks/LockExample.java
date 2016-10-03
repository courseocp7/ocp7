package javacourse.ocp.concurrency.locks;

public class LockExample extends Thread {
	
		final Counter counter;
		
		public LockExample(Counter counter) {
			this.counter = counter;
		}
		
        @Override
        public void run() {
            for (int i = 0; i < 20; i++) {
                counter.increment();
            }
        }
	
	    public static void main(String[] args) throws InterruptedException {
	    	
	    	Counter counter = new Counter();

	        LockExample t1 = new LockExample(counter);
	        LockExample t2 = new LockExample(counter);
	        
	        t1.start();
	        t2.start();
	        
	        t1.join();
	        t2.join();

	        System.out.println(counter.getCount());
	    }
	}
