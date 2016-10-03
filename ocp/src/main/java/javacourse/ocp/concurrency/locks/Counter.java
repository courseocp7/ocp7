package javacourse.ocp.concurrency.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
	
	private int count = 0;

    public void increment() {
    	
    	count++;
        otherIncrement();
    }
    
    public void otherIncrement() {
    	count++;
    	try {
			Thread.sleep(500); //Simulating some long-timed task....
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public int getCount() {
        return count;
    }
}
