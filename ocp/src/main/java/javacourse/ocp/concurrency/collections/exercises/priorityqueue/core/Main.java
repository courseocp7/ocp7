package javacourse.ocp.concurrency.collections.exercises.priorityqueue.core;

import java.util.concurrent.PriorityBlockingQueue;

import javacourse.ocp.concurrency.collections.exercises.priorityqueue.task.Event;
import javacourse.ocp.concurrency.collections.exercises.priorityqueue.task.Task;

/**
 * Main class of the example. Executes five threads that store their events in a
 * common priority queue and writes them in the console to verify the correct
 * operation of the PriorityBlockingQueue class
 * 
 * Other methods offered by PriorityBlockingQueue:
 * 
 * clear() : removes all the elements of the queue.
 *  
 * take() : returns and removes the first element of the queue. 
 * If the queue is empty, the method blocks its thread until the queue has elements. 
 * 
 * put(E e) : E is the class used to parameterize the PriorityBlockingQueue class.
 * This method inserts the element passed as a parameter into the queue. 
 * 
 * peek() : This method returns the first element of the queue, but doesn't remove it.
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Priority queue to store the events
		 */
		PriorityBlockingQueue<Event> queue = new PriorityBlockingQueue<>();

		/*
		 * An array to store the five Thread objects
		 */
		Thread taskThreads[] = new Thread[5];

		/*
		 * Create the five threads to execute five tasks
		 */
		for (int i = 0; i < taskThreads.length; i++) {
			Task task = new Task(i, queue);
			taskThreads[i] = new Thread(task);
		}

		/*
		 * Start the five threads
		 */
		for (int i = 0; i < taskThreads.length; i++) {
			taskThreads[i].start();
		}

		/*
		 * Wait for the finalization of the five threads
		 */
		for (int i = 0; i < taskThreads.length; i++) {
			try {
				taskThreads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		/*
		 * Write the events in the console
		 */
		System.out.printf("Main: Queue Size: %d\n", queue.size());
		for (int i = 0; i < taskThreads.length * 1000; i++) {
			Event event = queue.poll();
			System.out.printf("Thread %s: Priority %d\n", event.getThread(), event.getPriority());
		}
		System.out.printf("Main: Queue Size: %d\n", queue.size());
		System.out.printf("Main: End of the program\n");
	}
}
