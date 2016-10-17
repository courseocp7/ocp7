package javacourse.ocp.javadesign.basics.casting.implicit;

import javacourse.ocp.javadesign.basics.casting.Employee;
import javacourse.ocp.javadesign.basics.casting.Programmer;

/**
 * 
 * @author Jose Blesa
 *
 */
public class ImplicitCastingExample {
	
	public static void main(String[] args) {
		
		Employee emp = new Programmer(); //Implicit casting
		System.out.println(emp);
		
		emp.doSomething();
		//emp.doCode(); //Won't compile...
		
	}
	
	

}
