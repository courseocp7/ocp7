package javacourse.ocp.concurrency.collections.exercises.nonblocking.core;

import java.util.concurrent.ConcurrentLinkedDeque;

import javacourse.ocp.concurrency.collections.exercises.nonblocking.task.AddTask;
import javacourse.ocp.concurrency.collections.exercises.nonblocking.task.PollTask;

/**
 * Main class of the example. First, execute 100 AddTask objects to
 * add 1000000 elements to the list and the execute 100 PollTask objects
 * to delete all those elements.
 * 
 * ConcurrentLinkDeque offers other methods:
 * 
 * The following methods don't remove the element:
 * 
 * 	getFirst() / getLast(); -> if the list is empty throws NoSuchElementException
 * 	peek() / peekFirst() / peekLast() -> if the list is empty return null.
 * 
 * The following methods remove the element from the list:
 * 
 * 	remove(), removeFirst(), removeLast(); -> if the list is empty NoSuchElementException is thrown.
 *
 */
public class Main {

	/**
	 * Main method of the class
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		
		// Create a ConcurrentLinkedDeque to work with it in the example
		ConcurrentLinkedDeque<String> list=new ConcurrentLinkedDeque<>();
		// Create an Array of 100 threads
		Thread threads[]=new Thread[100];

		// Create 100 AddTask objects and execute them as threads
		for (int i=0; i<threads.length; i++){
			AddTask task=new AddTask(list);
			threads[i]=new Thread(task);
			threads[i].start();
		}
		System.out.printf("Main: %d AddTask threads have been launched\n",threads.length);
		
		// Wait for the finalization of the threads
		for (int i=0; i<threads.length; i++) {
				threads[i].join();
		}
		
		// Write to the console the size of the list
		System.out.printf("Main: Size of the List: %d\n",list.size());
		
		// Create 100 PollTask objects and execute them as threads
		for (int i=0; i<threads.length; i++){
			PollTask task=new PollTask(list);
			threads[i]=new Thread(task);
			threads[i].start();
		}
		System.out.printf("Main: %d PollTask threads have been launched\n",threads.length);
		
		// Wait for the finalization of the threads
		for (int i=0; i<threads.length; i++) {
			threads[i].join();
		}
		
		// Write to the console the size of the list
		System.out.printf("Main: Size of the List: %d\n",list.size());
	}
}
