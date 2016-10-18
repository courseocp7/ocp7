package javacourse.ocp.objectdesingprinciples.patterns;

/**
 * 
 * @author Jose Blesa
 *
 */
public class Singleton {

	static {
		System.out.println("static init block");
	}

	{
		System.out.println("init block");
	}

	private static Singleton instance = null;

	private Singleton() {
	}

	public static Singleton getInstance() {

		if (instance == null) {
			instance = new Singleton();
		}

		return instance;
	}

	public static void main(String[] args) {

		Singleton s = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();

		System.out.println(s == s2);

	}
}

/**
 * 
 * @author Jose Blesa
 *
 */
class Singleton02 {

	static {
		System.out.println("static init block");
	}

	{
		System.out.println("init block");
	}

	private volatile static Singleton02 instance = null;

	private Singleton02() {
	}

	public static Singleton02 getInstance() {

		synchronized (Singleton.class) {
			if (instance == null) {
				instance = new Singleton02();
			}
		}

		return instance;
	}

	public static void main(String[] args) {

		Singleton s = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();

		System.out.println(s == s2);

	}
}
