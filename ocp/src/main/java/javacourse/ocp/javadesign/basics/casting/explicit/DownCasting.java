package javacourse.ocp.javadesign.basics.casting.explicit;

import javacourse.ocp.javadesign.basics.casting.Employee;
import javacourse.ocp.javadesign.basics.casting.Programmer;

public class DownCasting {
	
	public static void doSomething(Employee emp){
		Programmer programmer = (Programmer) emp; // Down casting...
		System.out.println(programmer);
	}
	
	public static void main(String[] args) {
		
		Programmer program = (Programmer)null; // we can cast null...
		//doSomething(new Employee()); //downcasting... 
		//doSomething(new Director()); //not related...
		doSomething(new Programmer());

	}
	
}
