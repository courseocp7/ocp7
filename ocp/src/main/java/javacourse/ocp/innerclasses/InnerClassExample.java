package javacourse.ocp.innerclasses;

import javacourse.ocp.innerclasses.InnerClassExample.InnerClass;

public class InnerClassExample {

	InnerClass inner = new InnerClass();
	private int value = 10;

	private static void doSomethingFromOuter() {
		// InnerClass inner = new InnerClass();
		InnerClass inner = new InnerClassExample().new InnerClass();

	}

	void doNothing() {
		InnerClass inner = new InnerClass();
	}

	class InnerClass {

		void doSomething() {
			System.out.println(value);
			System.out.println(this);
			System.out.println(InnerClassExample.this);
			doSomethingFromOuter();
			
		}
	}
}

class OutherClass {

	void doMore() {

		InnerClassExample outer = new InnerClassExample();
		InnerClass inner = outer.new InnerClass();

	}

}
