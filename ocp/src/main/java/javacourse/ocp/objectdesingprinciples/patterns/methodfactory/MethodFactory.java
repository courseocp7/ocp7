package javacourse.ocp.objectdesingprinciples.patterns.methodfactory;

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
 * Simple Method Factory
 * 
 * @author Jose Blesa
 *
 */
public abstract class MethodFactory {
	
	public MyInterface getInstance() {
		return create();
	}
	
	protected abstract MyInterface create(); 
	
	public static void main(String[] args) {
		
		MyInterface client = new MyClassFactory().create();
		client.doSomething();
		
	}
}

/**
 * 
 * @author Jose Blesa
 *
 */
class MyClassFactory extends MethodFactory {

	@Override
	protected MyInterface create() {
		return new MyClass();
	}
}

/**
 * 
 * @author Jose Blesa
 *
 */
class MyOtherClassFactory extends MethodFactory {

	@Override
	protected MyInterface create() {
		return new MyOtherClass();
	}
}