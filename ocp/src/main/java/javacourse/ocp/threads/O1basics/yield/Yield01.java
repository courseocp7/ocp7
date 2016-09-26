package javacourse.ocp.threads.O1basics.yield;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

/**
 * 
 * This class demonstrates how works the yield static method...
 *
 * 
 * @author Jose Blesa
 *
 */

public class Yield01 implements Runnable {

	private final List<Integer> numbersToAdd;
	private long subtotal;
	private static long _total;

	public Yield01(List<Integer> numbers) {
		this.numbersToAdd = numbers;
		this.subtotal = 0;
	}

	public long getSubTotal() {
		return subtotal;
	}

	public void run() {
		
		System.out.println("generating subtotal..." + Thread.currentThread().getName());

		for (int number : numbersToAdd) {
			System.out.println("It's my turn :" + Thread.currentThread().getName() + "-" + Thread.currentThread().getPriority());
			subtotal += number;
			Thread.yield();
			//comment the previous line and uncomment this block to compare the behavior.
			/*
			try { 
				Thread.sleep(1);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
			*/
		}
	}
	
	private static long getTotal(){
		return _total;
	}

	private static List<Integer> getListWithRandomNumbers(int count, int maxNumber) {

		List<Integer> numbers = new ArrayList<>(count);
		final Random random = new Random();

		for (int x = 0; x < count; x++) {
			int number = random.nextInt(maxNumber);
			//System.out.println("number generated : " + number);
			numbers.add(number);
			_total+=number;
		}
		return numbers;
	}

	public static void main(String[] args) {

		List<Integer> numbers =  Yield01.getListWithRandomNumbers(20, 10);
	
		System.out.println("Total = " + Yield01.getTotal());
		
		Yield01 runnable01 = new Yield01(numbers.subList(  0, 2));
		Yield01 runnable02 = new Yield01(numbers.subList(2, 4));
		Yield01 runnable03 = new Yield01(numbers.subList(200, 300));
		Yield01 runnable04 = new Yield01(numbers.subList(300, 400));
		Yield01 runnable05 = new Yield01(numbers.subList(400, 500));
		Yield01 runnable06 = new Yield01(numbers.subList(500, 600));
		Yield01 runnable07 = new Yield01(numbers.subList(600, 700));
		Yield01 runnable08 = new Yield01(numbers.subList(700, 800));		
		
		
		Thread t01 = new Thread(runnable01, "runnable01");
		Thread t02 = new Thread(runnable02, "runnable02");
		Thread t03 = new Thread(runnable03, "runnable03");
		Thread t04 = new Thread(runnable04, "runnable04");		
		Thread t05 = new Thread(runnable05, "runnable05");
		Thread t06 = new Thread(runnable06, "runnable06");
		Thread t07 = new Thread(runnable07, "runnable07");
		Thread t08 = new Thread(runnable08, "runnable08");			
		
		
		long start = System.currentTimeMillis();
		
		t01.start();t01.setPriority(8);
		t02.start();t02.setPriority(8);
		t03.start();t03.setPriority(8);
		t04.start();t04.setPriority(8);
		t05.start();t05.setPriority(8);
		t06.start();t06.setPriority(8);
		t07.start();t07.setPriority(2);
		t08.start();t08.setPriority(2);		
		
		
		try {
			t01.join();
			t02.join();
			t03.join();
			t04.join();			
			t05.join();
			t06.join();
			t07.join();
			t08.join();			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("subtotal01 = " + runnable01.getSubTotal());
		System.out.println("subtotal02 = " + runnable02.getSubTotal());
		System.out.println("subtotal03 = " + runnable03.getSubTotal());
		System.out.println("subtotal04 = " + runnable04.getSubTotal());		
		System.out.println("subtotal05 = " + runnable05.getSubTotal());
		System.out.println("subtotal06 = " + runnable06.getSubTotal());
		System.out.println("subtotal07 = " + runnable07.getSubTotal());
		System.out.println("subtotal08 = " + runnable08.getSubTotal());		
		
		System.out.println((end - start) / 1000);

	}

}
