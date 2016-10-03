package javacourse.ocp.concurrency.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 
 * @author Jose Blesa
 *
 */
public class O1SampleExecutorService {

	public static void main(String[] args) {

		ExecutorService execService = Executors.newSingleThreadExecutor();

		execService.execute(new MyThread());
		Future<Integer> result = execService.submit(new MyCallable(100));

		try {
			System.out.printf("%d%n", result.get());
			System.out.printf("done!");
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

		execService.shutdown();
	}
}

class MyThread implements Runnable {

	@Override
	public void run() {
		for (int x = 0; x < 10; x++) {
			try {
				Thread.sleep(1000);
				System.out.printf("%d%n", x);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}
		}
	}
}

class MyCallable implements Callable<Integer> {

	private int number;

	public MyCallable(int number) {
		this.number = number;
	}

	@Override
	public Integer call() throws Exception {
		int result = 0;
		
		System.out.printf("executing %s%n", Thread.currentThread().getName());
		Thread.sleep(3000);
		
		for (; number > 1;) {
			result += (number * --number);
		}

		return result;

	}

}