package javacourse.ocp.concurrency.forkjoin.examples.basic.core;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

import javacourse.ocp.concurrency.forkjoin.examples.basic.task.Task;
import javacourse.ocp.concurrency.forkjoin.examples.basic.util.Product;
import javacourse.ocp.concurrency.forkjoin.examples.basic.util.ProductListGenerator;

/**
 * Main class of the example. It creates a list of products, a ForkJoinPool and 
 * a task to execute the actualization of products. 
 *
 */
public class Main {

	/**
	 * Main method of the example
	 * @param args
	 */
	public static void main(String[] args) {

		// Create a list of products
		ProductListGenerator generator=new ProductListGenerator();
		List<Product> products=generator.generate(10000);
		
		// Create a task
		Task task=new Task(products, 0, products.size(), 0.20);
		
		// Create a ForkJoinPool
		ForkJoinPool pool=new ForkJoinPool(); //default: the same threads than cores...
		
		// Execute the Task ... asynchronous!!!
		// To synchronous executing use invoke method...
		long start = System.currentTimeMillis();
		pool.execute(task);

		// Write information about the pool
		do {
			System.out.printf("Main: Thread Count: %d\n",pool.getActiveThreadCount());
			System.out.printf("Main: Thread Steal: %d\n",pool.getStealCount());
			System.out.printf("Main: Paralelism: %d\n",pool.getParallelism());
			try {
				TimeUnit.MILLISECONDS.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (!task.isDone());
		
		System.out.printf("total time : %d msecs ", System.currentTimeMillis() - start);
	
		// Shutdown the pool
		pool.shutdown();
		
		// Check if the task has completed normally
		if (task.isCompletedNormally()){
			System.out.printf("Main: The process has completed normally.\n");
		}

		// Expected result: 12. Write products which price is not 12
		for (int i=0; i<products.size(); i++){
			Product product=products.get(i);
			if (product.getPrice()!=12) {
				System.out.printf("Product %s: %f\n",product.getName(),product.getPrice());
			}
		}
		
		// End of the program
		System.out.println("Main: End of the program.\n");

	}

}
