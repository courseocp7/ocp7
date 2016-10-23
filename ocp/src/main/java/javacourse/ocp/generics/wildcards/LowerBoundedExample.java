package javacourse.ocp.generics.wildcards;

import java.util.ArrayList;
import java.util.List;


interface Employee{}
class Programmer implements Employee {}
class Architect implements Employee {}


public class LowerBoundedExample{
	
	private List<? super Employee> myList = null;
	
	public LowerBoundedExample(List<? super Employee> list) {
		this.myList = list;
	}
	
	public void printAll(){
		
		for (Object num : myList){
			System.out.println(num);
		}
	}
	
	public void addElement(Employee emp) {
		myList.add(emp);
	}
	
	public static void main(String[] args) {
		
		List<? super Employee> list = new ArrayList<Employee>(); 
		
		list.add(new Programmer());
		list.add(new Architect());
		
		LowerBoundedExample example = new LowerBoundedExample(list);
		
		example.addElement(new Programmer());
		example.printAll();
	}
}
