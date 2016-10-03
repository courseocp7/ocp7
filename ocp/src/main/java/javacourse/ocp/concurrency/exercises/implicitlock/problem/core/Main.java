package javacourse.ocp.concurrency.exercises.implicitlock.problem.core;

import java.util.Date;

import javacourse.ocp.concurrency.exercises.implicitlock.problem.task.BuildStats;
import javacourse.ocp.concurrency.exercises.implicitlock.problem.task.Sensor1;
import javacourse.ocp.concurrency.exercises.implicitlock.problem.task.Sensor2;

/**
 * Main class of the example. Creates an object with the statistics of the
 * building and executes two threads that simulates two sensors in the building
 *
 */
public class Main {

	/**
	 * Main method of the example
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Create a new object for the statistics
		BuildStats stats=new BuildStats();

		// Create a Sensor1 object and a Thread to run it
		Sensor1 sensor1=new Sensor1(stats);
		Thread thread1=new Thread(sensor1,"Sensor 1");

		// Create a Sensor 2 object and a Thread to run it
		Sensor2 sensor2=new Sensor2(stats);
		Thread thread2=new Thread(sensor2,"Sensor 2");
		
		// Create a Sensor 2 object and a Thread to run it
		Sensor2 sensor3=new Sensor2(stats);
		Thread thread3=new Thread(sensor2,"Sensor 3");		
		
		// Create a Sensor 2 object and a Thread to run it
		Sensor2 sensor4=new Sensor2(stats);
		Thread thread4=new Thread(sensor1,"Sensor 4");		
		
		// Get the actual time
		Date date1=new Date();
		
		//Starts the threads
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		
		try {
			// Wait for the finalization of the threads
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		//Get the actual time and print the execution time
		Date date2=new Date();
		stats.printStats();
		System.out.println("Execution Time: "+((date2.getTime()-date1.getTime())/1000));

	}

}
