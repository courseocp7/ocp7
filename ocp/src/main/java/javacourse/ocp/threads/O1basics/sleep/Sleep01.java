package javacourse.ocp.threads.O1basics.sleep;

/**
 * This class demonstrate the use of a sleep static method.
 * 
 * We rely on the sleep method to allow all the threads the chance to
 * be executed.     
 * 
 * @author Jose Blesa
 *
 */

public class Sleep01 implements Runnable {

	public void run() {
		
		for(int x = 0; x < 10; x++){
			System.out.println(Thread.currentThread().getName() + "-" + x);
			
			try {
				Thread.sleep(1000);
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){
		
		Sleep01 r01 = new Sleep01();
		
		Thread t01 = new  Thread(r01, "T01");
		Thread t02 = new  Thread(r01, "T02");
		Thread t03 = new  Thread(r01, "T03");
		
		t01.start();
		t02.start();
		t03.start();
	}

}
