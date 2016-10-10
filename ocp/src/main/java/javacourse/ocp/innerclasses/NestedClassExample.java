package javacourse.ocp.innerclasses;

/**
 * 
 * Nested Class example accesing private members of the outer class.
 * 
 * @author Jose Blesa
 *
 */
public class NestedClassExample {

	private static int value = 10;
	private int otherValue = 20;

	public static void main(String[] args) {

		// NestedClass nested1 = new NestedClass();

		System.out.println(NestedClassExample.value);
		System.out.println(NestedClassExample.NestedClass.getValue());
		// System.out.println(NestedClassExample.value);
		// System.out.println(nested1.getValue());

	}

	static class NestedClass {

		static {
			value = 20;
		}

		public static int getValue() {
			return NestedClassExample.value;
		}
	}
}

class MyClass {

	private NestedClassExample.NestedClass nested = new NestedClassExample.NestedClass();

}
