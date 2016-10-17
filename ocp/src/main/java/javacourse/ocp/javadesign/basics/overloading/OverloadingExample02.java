package javacourse.ocp.javadesign.basics.overloading;

public class OverloadingExample02 {
	
	public static double compute(int value, double value2){
		System.out.printf("compunting int - double%n");
		return value + value2;
	}
	
	public static double compute(double value, int value2){
		System.out.printf("compunting double - int%n");
		return value + value2;
	}
	
	public static void main(String[] args) {
		
		//OverloadingExample02.compute(10, 20);
		
	}
	

}
