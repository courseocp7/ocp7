package javacourse.ocp.javadesign.basics.overloading;

/**
 * 
 * @author Jose Blesa
 *
 */
class MostSpecificOverload {

	public static void doSomething(String obj) {
		System.out.println("doSomething with... String");
	}

	public static void doSomething(Object obj) {
		System.out.println("doSomething with... Object");
	}
}

/**
 * 
 * @author Jose Blesa
 *
 */
class MostSpecificOverload02 {

	public static void doSomething(String obj) {
		System.out.println("doSomething with... String");
	}

	public static void doSomething(Object obj) {
		System.out.println("doSomething with... Object");
	}

	public static void doSomething(StringBuffer obj) {
		System.out.println("doSomething with... StringBuffer");
	}
}

/**
 * 
 * @author Jose Blesa
 *
 */
class MostSpecificOverload03 {

	public static void doSomething(Object obj, Object obj2) {
		System.out.println("doSomething with... Object - Object...");
	}

	public static void doSomething(String str, Object obj) {
		System.out.println("doSomething with... Object - String");
	}
}

/**
 * 
 * @author Jose Blesa
 *
 */
class MostSpecificOverload04 {

	public static void doSomething(String... str) {
		System.out.println("doSomething with... String...");
	}

	public static void doSomething(Object obj) {
		System.out.println("doSomething with... Object");
	}
}

/**
 * 
 * @author Jose Blesa
 *
 */
class VarArgsOverload {

	static void vararg(int x) {
		System.out.println("int ");
	}

	static void vararg(Integer x) {
		System.out.println("Integer");
	}

	static void vararg(int... x) {
		System.out.println("int..");
	}

}

/**
 * 
 * @author Jose Blesa
 *
 */
class VarArgsOverload02 {

	static void vararg(Integer x) {
		System.out.println("int ");
	}

	static void vararg(double x) {
		System.out.println("double");
	}
}

/**
 * 
 * @author Jose Blesa
 *
 */
class VarArgsOverload03 {

	static void vararg(int i, double d) { // try to put the d param as vararg...
		System.out.println("int - double ");
	}

	static void vararg(double d, int i) {
		System.out.println("double - int");
	}
	
	static void vararg(int... i) {
		System.out.println("int...");
	}
}

public class OverloadingExample03 {

	public static void main(String[] args) {

		// MostSpecificOverload.doSomething(null);
		// MostSpecificOverload02.doSomething(null);
		// MostSpecificOverload03.doSomething(null, null);
		// MostSpecificOverload04.doSomething("pepe");

		// VarArgsOverload.vararg(10);
		//VarArgsOverload02.vararg(10);
		//VarArgsOverload03.vararg(10, 10);

	}
}