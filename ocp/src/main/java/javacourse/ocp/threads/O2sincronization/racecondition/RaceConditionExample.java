package javacourse.ocp.threads.O2sincronization.racecondition;

public class RaceConditionExample extends Thread {
	
		final Counter counter;
		
		public RaceConditionExample(Counter counter) {
			this.counter = counter;
		}
		
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                counter.increment();
            }
        }
	
	    public static void main(String[] args) throws InterruptedException {
	    	
	    	Counter counter = new Counter();

	        RaceConditionExample t1 = new RaceConditionExample(counter);
	        RaceConditionExample t2 = new RaceConditionExample(counter);
	        
	        t1.start();
	        t2.start();
	        t1.join();
	        t2.join();

	        System.out.println(counter.getCount());
	    }
	}
