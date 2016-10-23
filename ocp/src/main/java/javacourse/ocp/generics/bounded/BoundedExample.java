package javacourse.ocp.generics.bounded;

public class BoundedExample implements MyInterface {
	
	protected String doSomething(){
		return "doing something as employee";
	}
	
	public static void main(String[] args) {}
}

class Programmer extends BoundedExample {
	
	protected String doSomething(){
		return "coding!!";
	}
	
}
class Architect extends BoundedExample {
	
	protected String doSomething(){
		return "designg the system!!!";
	}
}

interface MyInterface {} 

class Manager {
	
	protected String doSomething(){
		return "managing!!!";
	}
}

class Work<T extends BoundedExample & MyInterface> { // We need to bound this parameter...
	
	private T t;
	
	public Work(T t) {
		this.t = t;
	}
	
	public String doIt() {
		return t.doSomething();
		//System.out.println(t.doSomething());
	}
	
	public static void main(String[] args) {
		
		Work<BoundedExample> work = new Work<>(new BoundedExample());
		System.out.println(work.doIt());
		
		Work<Programmer> programmer = new Work<>(new Programmer());
		System.out.println(programmer.doIt());
	}
}

