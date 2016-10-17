package javacourse.ocp.javadesign.basics.casting;

public class Programmer extends Employee {
	
	public void doCode() {
		System.out.println("Coding like a ninja coder!!!");
	}
	
	@Override
	public String toString() {
		return "I'm a Programmer!!!!";
	}
}