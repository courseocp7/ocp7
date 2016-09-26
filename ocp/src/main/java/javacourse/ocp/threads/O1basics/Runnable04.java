package javacourse.ocp.threads.O1basics;

/**
 * This class demonstrate what happens when we change the state of a Runnable
 * class while it is executing in a Thread. 
 * 
 * @author Jose Blesa
 *
 */
public class Runnable04 implements Runnable{
	
	private int counter = 0;
	
	public void addToCounter(int number){
		counter = number;
	}
	
	@Override
	public void run() {
		
		System.out.println("Starting counter from: " + counter );
		
		//10 seconds...
		for (; counter < 10 ; counter++){
			System.out.println(counter);
			try {
				Thread.sleep(1 * 1000); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + " finished!" );
	}
	
	public static void main(String[] args) throws InterruptedException{
		
		Thread.currentThread().setName("Principal");
		
		Runnable bt = new Runnable04();
		((Runnable04)bt).addToCounter(0);
		
		Thread t01 = new Thread(bt, "t01");
		t01.start();
		
		Thread.sleep(5000);
		((Runnable04)bt).addToCounter(0);
	}	
}