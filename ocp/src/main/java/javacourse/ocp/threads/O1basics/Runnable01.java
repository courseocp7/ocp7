package javacourse.ocp.threads.O1basics;

/**
 * Creating a Thread with imlpementing Runnable interface.
 * 
 * Thanks to java.lang.interface we can keep away both; the job (Runnable)
 * and the worker where executing the job (Thread).
 * 
 * This is the preferred mode to implement a Thread (best practice).
 * 
 * @author Jose Blesa
 *
 */
public class Runnable01 implements Runnable{
	
	@SuppressWarnings("unused")
	private int counter = 0;
	
	@Override
	public void run() {
		for (int counter = 0; counter < 100 ; counter++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " finished!" );
	}
	
	public static void main(String[] args) throws InterruptedException{
		
		Runnable bt = new Runnable01(); //This is the class 'target' with the logic....
		
		//Thread's Constructors.
		//We need a Thread class to execute the target (Runnable).
		Thread t01 = new Thread(bt, "t01");
		
		Thread t02 = new Thread(t01); //A Thread also IS-A Runnable!! 
		
		Thread t03 = new Thread(); //do nothing...
		
		Thread t04 = new Thread("MyThread"); //do nothing...
		
		//starting the threads.
		t01.start(); 
		t02.start(); 
		t03.start(); 
		t04.start();
		
		System.out.println(Thread.currentThread().getName() + " finished!" );
		
	}	
}