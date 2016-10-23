package javacourse.ocp.generics.methods;

import java.util.ArrayList;
import java.util.Collection;

public class GenericMethodExample {
	
	public static <T> T addElement(T element, Collection<T> collection){
		
		collection.add(element);
		return element;
	}
	
	
	public static void main(String[] args) {
		
		GenericMethodExample.addElement(10, new ArrayList<Integer>());
		//GenericMethodExample.addElement("pepe", new ArrayList<Integer>());
		
	}

}


class GenericClassWithAGenericMethod<T> {
	
	T value;
	
	public GenericClassWithAGenericMethod(T value) {
		this.value = value;
	}
	
	public T getValue(){
		return value;
	}
	
	/*
	 * Generic method...
	 */
	public <T2> T2 addElement(T2 element, Collection<T2> collection){
		
		collection.add(element);
		return element;
	}
	
	
	public static void main(String[] args) {
		
		GenericClassWithAGenericMethod<String> clazz = new GenericClassWithAGenericMethod<>("Java");
		String value = clazz.getValue();
		System.out.println(value);
		
		int num = clazz.addElement(10, new ArrayList<Integer>());
		System.out.println(num);
		
	}
	
}

