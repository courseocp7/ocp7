package javacourse.ocp.threads.O1basics;

/**
 * This example shows how implement a Thread extending from Thread class
 * 
 * This way has a lot of negative points.
 *    - From a object oriented point of view: you cannot extend nothing more!!!
 *       So, this class IS-A Thread and nothing more!
 *    - If this class is extended by other, that class IS-A Thread too!!
 *    - Other point is that your are mixing the processing with the 'job to do'
 * 
 * @author Jose Blesa
 *
 */
public class BasicThread extends Thread {

	@SuppressWarnings("unused")
	private int counter = 0;

	@Override

	//This is the method that JVM executes when starts the thread.
	public void run() {
		for (int counter = 0; counter < 10; counter++) {
			System.out.println(counter);
		}
		System.out.println(Thread.currentThread().getName() + " finished!");
	}

	public static void main(String[] args) throws InterruptedException {

		BasicThread bt = new BasicThread(); //Instantiating the thread class 
		bt.start(); //stating a new thread

	}
}