package javacourse.ocp.concurrency.exercises.implicitlock.problem.task;

import java.util.concurrent.TimeUnit;

/**
 * 
 * This class simulates a control class that stores the statistics of access to
 * a building, controlling the number of people inside the building
 *
 */
public class BuildStats {

	/**
	 * Number of people inside the building
	 */
	private long numPeople;

	/**
	 * Method that simulates when people come in into the building
	 */
	public void comeIn() {
		System.out.printf("%s: A person enters.\n", Thread.currentThread().getName());
		numPeople++;
		generateCard();
	}

	/**
	 * Method that simulates when people leave the building
	 */
	public void goOut() {
		System.out.printf("%s: A person leaves.\n", Thread.currentThread().getName());
		numPeople--;
		generateReport();
	}

	/**
	 * Method that simulates the generation of a card when people come in into
	 * the building
	 */
	private void generateCard() {
		try {
			TimeUnit.MILLISECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method that simulates the generation of a report when people leaves the
	 * building
	 */
	private void generateReport() {
		try {
			TimeUnit.MILLISECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method that print the number of people inside the building
	 */
	public void printStats() {
		System.out.printf("%d persons in the building.\n", numPeople);
	}

}
