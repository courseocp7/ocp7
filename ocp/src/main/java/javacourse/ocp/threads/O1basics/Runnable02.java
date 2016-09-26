package javacourse.ocp.threads.O1basics;

/**
 * This class demonstrate how we can use the isAlive method from an thread
 * instance. (This method only exists at runtime so we need to use an instance).
 * 
 * @author Jose Blesa
 *
 */
public class Runnable02 implements Runnable {

	@SuppressWarnings("unused")
	private int counter = 0;

	@Override
	public void run() {
		for (int counter = 0; counter < 10; counter++) {
			try {
				Thread.sleep(2 * 1000);
			} catch (InterruptedException ie) {
				System.out.format(" %s was interrupted while sleeping",
									Thread.currentThread().getName());
				continue;
			}
		}

		System.out.println(Thread.currentThread().getName() + " finished!");
	}

	public static void main(String[] args) throws InterruptedException {

		Runnable bt = new Runnable02();
		
		Thread t01 = new Thread(bt, "t01");
		
		t01.start();

		while (t01.isAlive()) {
			System.out.println("t01 is alive!!!");
			Thread.sleep(1000);
		}

		System.out.println("t01 is death!!!");

	}
}