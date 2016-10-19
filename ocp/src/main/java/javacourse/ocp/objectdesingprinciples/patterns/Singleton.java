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

		if (instance == null) { 
			synchronized (Singleton.class) {
				if (instance == null) { // double checking...
					instance = new Singleton02();
				}
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


enum SingletonAsEnum {
	
	SINGLETON(0);
	
	{
		System.out.println("init block...");
	}
	
	private int num;
	
	private SingletonAsEnum(int num) {
		this.num = num;
	}
	
	public void setNum(int num){
		this.num = num;
	}
	
	void doSomething(){
		System.out.printf("doing something from Singleton instance %d", this.num);
	}
	
	
	public static void main(String[] args) {
		
		SingletonAsEnum instance = SingletonAsEnum.SINGLETON;
		SingletonAsEnum instance2 = SingletonAsEnum.SINGLETON;
		
		
		System.out.println(instance == instance2);
		
		instance.setNum(50);
		instance2.doSomething();
		
	}
	
}


