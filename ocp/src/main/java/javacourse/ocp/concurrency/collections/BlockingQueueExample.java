package javacourse.ocp.concurrency.collections;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueExample {

	public static void main(String[] args) {

		ArrayBlockingQueue<Integer> numbers = new ArrayBlockingQueue<>(1);

		/*
		numbers.add(20);
		numbers.add(10);
		*/
		boolean result;
		result = numbers.offer(20);
		result = numbers.offer(10);
		System.out.println(result);

		/*
		try {
			numbers.put(20);
			numbers.put(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
		
		System.out.print(numbers);
		
	}

}
