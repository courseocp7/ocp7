package javacourse.ocp.threads.O1basics;

/**
 * This class demonstrate two important things:
 * 
 * A Runnable class can behave as a regular class:
 * 
 *    - You can invoke the run method. But you aren't executing it in a new thread.
 *    - You can invoke other methods as any other regular class.
 * 
 * @author Jose Blesa
 *
 */
public class Runnable03 implements Runnable{
	
	private int counter = 0;
	
	public void addToCounter(int number){
		counter = number;
	}
	
	@Override
	public void run() {
		
		System.out.println("Starting counter from: " + counter );
		
		for (; counter < 100 ; counter++){
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " finished!" );
	}
	
	public static void main(String[] args) throws InterruptedException{
		
		Runnable bt = new Runnable03();
		((Runnable03)bt).addToCounter(50);
		
		bt.run(); 
		
		Thread t01 = new Thread(bt);
		t01.start();
		

	}	
}