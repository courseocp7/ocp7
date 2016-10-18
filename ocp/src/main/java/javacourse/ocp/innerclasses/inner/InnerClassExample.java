package javacourse.ocp.innerclasses.inner;

import java.io.Closeable;
import java.io.IOException;

import javacourse.ocp.innerclasses.inner.InnerClassExample.InnerClass;

public class InnerClassExample {
	
	static {
		System.out.println("Outer static init block....");
	}
	
	{
		System.out.println("Outer init block...");
	}

	private int value = 50; // private variable member...
	InnerClass inner; //inner class as another member of the outer class...
	OtherInnerClass otherInner = new OtherInnerClass();

	public void doSomethingInstanceFromOuter() {
		inner = new InnerClass(); // instantiating inner class member...
		//inner.doSomethingFromInnerClass(); // using inner object...
	}
	
	private static void doSomethingStaticFromOuter() {
		System.out.println("Doing something from outer static method...");
	}
	
	public static void main(String[] args) {}
	
	/**
	 * Inner class....
	 * 
	 * @author Jose Blesa
	 *
	 */
	class InnerClass {
		
		/* static */ {
			value = 100;
			System.out.println("inner init block...");
		}
		
		private /*static*/ int value = 10; //Shadowing...

		void doSomethingFromInnerClass() {
			System.out.println(value);//accessing to private outer variable member...

			//Shadowing handling...
			System.out.println(this.value);//accessing to private inner class member... 
			System.out.println(InnerClassExample.this.value);//accessing to private member of the outer class...
			
			InnerClassExample.doSomethingStaticFromOuter();//calling private static outer method....
			doSomethingInstanceFromOuter(); //calling private instance outer member...
		}
		
		/*static*/ void doOtherThing() {
			System.out.println("Doing other thing from outer...");
		}
	}
	
	/**
	 * Other inner class.... extending and implementing...
	 * 
	 * @author Jose Blesa
	 *
	 */
	class OtherInnerClass extends InnerClass implements Closeable {
		
		@Override
		public void close() throws IOException {}
		
	}
}

/**
 * 
 * Try to execute this class...
 * 
 * @author Jose Blesa
 *
 */
class MyClass {
	
	public static void main(String[] args) {
		
		InnerClassExample outer = new InnerClassExample();
		InnerClass inner = outer.new InnerClass();
		
		inner.doSomethingFromInnerClass();
		outer.doSomethingInstanceFromOuter();
		
		outer.inner.doOtherThing();
		
	}
}
