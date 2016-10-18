package javacourse.ocp.innerclasses.nested;

/**
 * 
 * Nested Class example accesing private members of the outer class.
 * 
 * @author Jose Blesa
 *
 */
public class NestedClassExample {

	private static int outerStaticValue = 10;
	private int outerInstanceValue = 20;
	
	static {
		System.out.println("Outer class static block initializer...");
		outerStaticValue = 5000;
	}

	private static int getOuterStaticValue() {
		return outerStaticValue;
	}
	
	private int getOuterInstanceValue() {
		return outerInstanceValue;
	}

	public static void main(String[] args) {

		System.out.println(NestedClassExample.outerStaticValue);
		System.out.println(NestedClassExample.NestedClass.getValue());
	}

	static class NestedClass {

		private static int outerStaticValue = 50;
		private static int nestedStaticValue = 30;
		private int nestedInstanceValue = 10;

		static {
			
			System.out.println("Nested class static block initializer...");
			
			// accessing private outer field member
			//NestedClassExample.outerStaticValue = 1000;
			nestedStaticValue = 100;
		} 

		public static int getValue() { // accessing private outer method.
			//return getOuterStaticValue();
			return nestedStaticValue;
		}
	}
}

class MyClass {

	// How to instanciate from outside the outer class....
	private NestedClassExample.NestedClass nested = new NestedClassExample.NestedClass();
	
	public void doSomething() {
		System.out.printf("%d%n", nested.getValue());
	}
	
	public static void main(String[] args) {
		
		MyClass mc = new MyClass();
		mc.doSomething();
	}
	

}
