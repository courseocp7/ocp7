package javacourse.ocp.concurrency.locks.trylock.solution;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Inventory {
	int inStock;
	String name;
	Lock lock = new ReentrantLock();

	Inventory(String name) {
		this.name = name;
	}

	public void stockIn(long qty) {
		inStock += qty;
	}

	public void stockOut(long qty) {
		inStock -= qty;
	}
}

public class Shipment extends Thread {
	Inventory loc1, loc2;
	int qty;

	Shipment(Inventory loc1, Inventory loc2, int qty) {
		this.loc1 = loc1;
		this.loc2 = loc2;
		this.qty = qty;
	}

	public void run() {
		if(loc1.lock.tryLock()) {
			doSomethingElse();
			if(loc2.lock.tryLock()) {
				loc2.stockOut(qty);
				loc1.stockIn(qty);
				System.out.println(loc1.inStock + ":" + loc2.inStock);
				loc1.lock.unlock();
				loc2.lock.unlock();
			} else {
				System.out.printf("Unable to get lock %s ", loc2.name);
			}
		} else {
			System.out.printf("Unable to get lock %s ", loc1.name);
		}
	}
	
	private void doSomethingElse(){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		Inventory loc1 = new Inventory("Seattle");
		loc1.inStock = 100;
		Inventory loc2 = new Inventory("LA");
		loc2.inStock = 200;
		Shipment s1 = new Shipment(loc1, loc2, 1);
		Shipment s2 = new Shipment(loc2, loc1, 10);
		
		s1.start();
		s2.start();
	}
}