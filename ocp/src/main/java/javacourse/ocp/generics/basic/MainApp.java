package javacourse.ocp.generics.basic;

/**
 * This class demonstrate the use of a non generic class and a generic class.
 * It's easy to see the benefit when using a generic class and how the code is more
 * readable.
 *
 * @author Jose Blesa
 *
 */

public class MainApp {
	
	public static void main(String[] args){
		
		// Non generic class version...
		NonGenericClass ngc = new NonGenericClass(new Integer(10));
		
		Integer number = (Integer)ngc.get();
		System.out.println(number);
		
		// Generic class version...
		GenericClass<String> gc = new GenericClass<>("Hello generic class!");
		
		String miString = gc.get();
		System.out.println(miString);
		
		// Now the same class is managing Integer type...
		GenericClass<Integer> otherGenericClass = new GenericClass<Integer>(10);
		int miNumber = otherGenericClass.get();
		System.out.println(miNumber);
		
	}

}
