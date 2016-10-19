package javacourse.ocp.innerclasses.inner;

public class MethodInnerExample {
	
	private int num = 50;

	public void doSomething() {
		final int num = 23;

		class Inner { // method inner class
			
			/*static*/ int num = 23;
			
			public void print() {
				System.out.println("Inside method inner class " + MethodInnerExample.this.num); //  we can access private from outer...
				System.out.println("Inside method inner class " + num); //  we can't access non-final enclosing var...
			}
			
			/*static*/ void doOtherThings(){
				System.out.println("Inside method inner class " + MethodInnerExample.this.num); //  we can access private from outer...
			}
			
		} // end of inner class

		// Accessing the inner class
		Inner inner = new Inner();
		inner.print();
	}

	public static void main(String args[]) {
		MethodInnerExample outer = new MethodInnerExample();
		outer.doSomething();
	}
}
