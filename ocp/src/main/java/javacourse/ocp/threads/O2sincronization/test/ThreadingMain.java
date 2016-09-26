package javacourse.ocp.threads.O2sincronization.test;

public class ThreadingMain extends Thread {
	private static int counter = 0;

	public static void main(String[] args) {
		counter = 0;
		Thread th1 = new ThreadingMain();
		Thread th2 = new ThreadingMain();
		th1.start();
		th2.start();
	}

	public void run() {
		while (counter < 4) {
			synchronized (this) {
				counter++;
				System.out.print(counter + " ");
			}
		}
	}
}
