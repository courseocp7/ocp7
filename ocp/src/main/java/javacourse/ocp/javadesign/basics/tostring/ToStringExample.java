package javacourse.ocp.javadesign.basics.tostring;

class Employee {
	static int employeeType = 10;

	@Override
	public String toString() {
		return String.valueOf(employeeType);
	}
}

class Programmer extends Employee {
	static int employeeType = 20;

}

public class ToStringExample {

	public static void main(String[] args) {

		Employee emp = new Programmer();
		System.out.println(emp);

	}
}