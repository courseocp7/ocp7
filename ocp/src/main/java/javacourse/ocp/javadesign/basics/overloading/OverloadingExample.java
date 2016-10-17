package javacourse.ocp.javadesign.basics.overloading;

/**
 * 
 * Overloading example
 * 
 * @author Jose Blesa
 *
 */
public class OverloadingExample {

	// Comment this code and see what happens!!!

	public static void doSomething(Employee... employees) {
		System.out.printf("%s employees doing something...%n", Number.values()[employees.length]);
	}

	public static void doSomething(Employee employee) {
		System.out.printf("One employee doing something...%n");
	}

	public static void doSomething(Employee employee, Employee employee2) {
		System.out.printf("Two employees doing something...%n");
	}

	/*
	public static void doSomething(Programmer employee) {
		System.out.printf("I'm programming in java!!!%n");
	}
	*/

	public static void doSomething(Manager employee) {
		System.out.printf("I'm managing the project!!!%n");
	}

	public static void main(String[] args) {

		OverloadingExample.doSomething(new Programmer());
		OverloadingExample.doSomething(new Employee());
		OverloadingExample.doSomething(new Employee(), new Employee());
		OverloadingExample.doSomething(new Employee(), new Employee(), new Employee());

	}
}

enum Number {
	ZERO,ONE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE
}

class Employee {}

class Programmer extends Employee {}

class Manager extends Employee {}