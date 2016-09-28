package javacourse.ocp.threads.O1basics.join;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

/**
 *
 * This class demonstrate the use of Thread.join() method
 * 
 * @author Jose Blesa
 *
 */

public class JoinExample01 implements Runnable {

	private List<Integer> numbers;
	private int subtotal = 0;
	private static long total = 0;

	public JoinExample01(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public void run() {

		for (int number : numbers) {
			subtotal += number;
			System.out.printf("generating subtotal from %s : %d%n", Thread.currentThread().getName(), subtotal);			
			try {
				Thread.sleep(10);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}

	public int getSubTotal() {
		return subtotal;
	}
	
	public static long getTotal() {
		return total;
	}	

	/**
	 * This method calculates the variable member 'subtotal' as the sum of all numbers
	 * in the list
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
			System.out.printf("number generated : %d%n" , number);
			numbers.add(number);
			total += number;
		}
		return numbers;
	}

	public static void main(String[] args) {

		List<Integer> numbers = JoinExample01.getListWithRandomNumbers(10, 10);
		System.out.printf("Total = %d \n", JoinExample01.getTotal());

		JoinExample01 runnable01 = new JoinExample01(numbers.subList(0, 4));
		JoinExample01 runnable02 = new JoinExample01(numbers.subList(4, 10));

		Thread t01 = new Thread(runnable01);
		Thread t02 = new Thread(runnable02);

		t01.start();
		t02.start();
		
		try {
		t01.join();
		t02.join();
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}

		System.out.printf("subtotal01 = %d \n", runnable01.getSubTotal());
		System.out.printf("subtotal02 = %d \n", runnable02.getSubTotal());
	}

}
