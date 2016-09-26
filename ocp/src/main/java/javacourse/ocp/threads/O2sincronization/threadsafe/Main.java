package javacourse.ocp.threads.O2sincronization.threadsafe;

/**
 * 
 * Problems with thread-safe members
 * 
 * @author Jose Blesa
 *
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		final NameList nl = new NameList();
		
		nl.add("John");
		
		class NameDropper extends Thread {
			public void run() {
				String name = null;
				try {
					name = nl.removeFirst();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(name);
			}
		}
		
		Thread t1 = new NameDropper();
		Thread t2 = new NameDropper();
		t1.start();
		t2.start();
		
		do{
			if(t1.isAlive()) {
				System.out.format("%s : %s%n", t1.getName(), t1.getState());
			}
			
			if(t2.isAlive()) {
				System.out.format("%s : %s%n", t2.getName(), t2.getState());
			}
			Thread.sleep(1000);
		}while(t1.isAlive() || t2.isAlive());
		
		
	}
}
