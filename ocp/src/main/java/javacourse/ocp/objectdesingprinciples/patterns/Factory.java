package javacourse.ocp.objectdesingprinciples.patterns;

interface MyInterface {
	void doSomething();
}

class MyClass implements MyInterface {
	
	@Override
	public void doSomething() {
		System.out.println("doing something from MyClass");
	}
}

class MyOtherClass implements MyInterface {
	
	@Override
	public void doSomething() {
		System.out.println("doing something from MyOtherClass");
	}
}

/**
 * 
 * Simple Factory
 * 
 * @author Jose Blesa
 *
 */
public class Factory {
	
	private Factory() {}
	public enum Type { MYCLASS, MYOTHERCLASS }
	
	public static MyInterface getInstance(Type t) {
		
		if(t == Type.MYCLASS) {
			return new MyClass();
		} else if(t == Type.MYOTHERCLASS){
			return new MyOtherClass();
		} else 
			return null;
	}
	
	public static void main(String[] args) {
		
		MyInterface client = Factory.getInstance(Factory.Type.MYCLASS);
		client.doSomething();
	}
	
	
}