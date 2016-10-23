package javacourse.ocp.generics.inference;

class MyClass<T> {
	
	public <X> void doSomething(X x) {
		System.out.println(x.getClass());
	}


	public static void main(String args[]) {
		
		MyClass<String> mc = new MyClass<>();// inferring from reference variable type parameter...
		
		mc.<Integer>doSomething(new Integer(10)); // implicit type parameter.
		//mc.<>doSomething(new Integer(10));
		mc.doSomething("String"); // inferring from actual parameter...
	}
}