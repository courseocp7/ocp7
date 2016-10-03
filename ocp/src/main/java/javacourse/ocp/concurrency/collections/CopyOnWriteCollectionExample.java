package javacourse.ocp.concurrency.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 
 * Example of how CopyOnWriteCollection behaves when it's modified while
 * traversing.
 * 
 * @author Jose Blesa
 *
 */
public class CopyOnWriteCollectionExample {

	public static void main(String[] args) throws InterruptedException {

		//final CopyOnWriteArrayList<Integer> numbers = new CopyOnWriteArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		final ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

		// new thread to concurrently modify the list
		new Thread(new MyRunnable(numbers)).start();
		
		Iterator<Integer> itera = numbers.iterator();

		for (int i : numbers) {
			System.out.println(i);
			// sleep a little to let other thread finish adding an element
			// before iteration is complete
			Thread.sleep(100);
		}
	}

}

class MyRunnable implements Runnable {

	List<Integer> numbers;

	public MyRunnable(List<Integer> numbers) {

		this.numbers = numbers;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(250);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		numbers.add(10);
		System.out.println("numbers:" + numbers);
	}

}
