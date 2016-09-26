package javacourse.ocp.threads.O1basics.yield;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

/**
 * 
 * In this class something goes wrong when we try to slice the sum of all the
 * numbers included in a list between several threads.
 * 
 * @author Jose Blesa
 *
 */

public class YieldExample01 implements Runnable {

	private List<Integer> numbers;
	private int subtotal = 0;
	private static long total = 0;

	public YieldExample01(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public void run() {

		for (int number : numbers) {
			subtotal += number;
			//System.out.printf("generating subtotal from %s : %d \n", Thread.currentThread().getName(), subtotal);
			Thread.yield();
			try {
				Thread.sleep(10);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		System.out.printf("thread %s finished! \n", Thread.currentThread().getName());
	}

	public int getSubTotal() {
		return subtotal;
	}

	public static long getTotal() {
		return total;
	}

	/**
	 * This method calculates the variable member 'subtotal' as the sum of all
	 * numbers in the list
	 * 
	 * @param count
	 *            the quantity of numbers to return
	 * @param maxNumber
	 *            the maximum value of the numbers
	 * 
	 * @return a list of numbers between 0 and maxNumber
	 */
	private static List<Integer> getListWithRandomNumbers(int count, int maxNumber) {

		List<Integer> numbers = new ArrayList<>(count);
		final Random random = new Random();

		for (int x = 0; x < count; x++) {
			int number = random.nextInt(maxNumber);
			//System.out.printf("number generated : %d \n", number);
			numbers.add(number);
			total += number;
		}
		return numbers;
	}

	public static void main(String[] args) {

		List<Integer> numbers = YieldExample01.getListWithRandomNumbers(1000, 5);
		System.out.printf("Total = %d \n", YieldExample01.getTotal());
		
		Runnable[] runnables = {
		new YieldExample01(numbers.subList(0,   100)),
		new YieldExample01(numbers.subList(100, 200)),
		new YieldExample01(numbers.subList(200, 300)),
		new YieldExample01(numbers.subList(300, 400)),
		new YieldExample01(numbers.subList(400, 500)),
		new YieldExample01(numbers.subList(500, 600)),
		new YieldExample01(numbers.subList(600, 700)),
		new YieldExample01(numbers.subList(700, 800)),
		new YieldExample01(numbers.subList(800, 900)),
		new YieldExample01(numbers.subList(900, 1000))
		};
		
		Thread[] threads = new Thread[runnables.length];
		int[] priorities = {1,1,5,5,5,5,5,5,5,5};
		
		for(int x = 0; x < runnables.length; x++){
			threads[x] = new Thread(runnables[x]);
			threads[x].setPriority(priorities[x]);
			threads[x].start();
		}
		
		for(int x = 0; x < threads.length; x++){
			try {
				threads[x].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		for(int x = 0; x < runnables.length; x++){
		
			((YieldExample01)runnables[x]).getSubTotal();
		}
	}
}
