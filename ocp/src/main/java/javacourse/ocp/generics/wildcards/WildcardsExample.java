package javacourse.ocp.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class WildcardsExample {
	
	public static void printAll(List<?> myList){
		
		for (Object num : myList){ // Attention here!!! Object typed...
			System.out.println(num);
		}
	}
	
	public static void printAllEnhanced(List<? extends Number> myList){
		
		for (Number num : myList){
			System.out.println(num);
		}
	}
	
	public static void main(String[] args) {
		
		//List<Number> myList = new ArrayList<Integer>();
		List<Integer> myList = new ArrayList<Integer>();
		
		myList.add(10);
		myList.add(20);
		
		WildcardsExample.printAll(myList);
		
		
		List<Float> myListFloats = new ArrayList<Float>();
		myListFloats.add(10.30F);
		myListFloats.add(15.90F);
		
		WildcardsExample.printAllEnhanced(myListFloats);
		
		List<String> myListStrings = new ArrayList<String>();
		myListStrings.add("Java");
		myListStrings.add("Oracle");
		
		//WildcardsExample.printAllEnhanced(myListStrings);
		
		//List<? extends Number> numberList = new ArrayList<Integer>();
		//numberList.add.. // we can't add nothing...

	}
}
