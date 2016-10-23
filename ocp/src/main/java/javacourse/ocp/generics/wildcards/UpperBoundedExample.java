package javacourse.ocp.generics.wildcards;

import java.util.ArrayList;
import java.util.List;


class SeniorProgrammer extends Programmer {}
class JuniorProgrammer extends Programmer {}

public class UpperBoundedExample{
	
	private List<? extends Employee> myList = null;
	
	public UpperBoundedExample(List<? extends Employee> list) {
		this.myList = list;
	}
	
	public void printAll(){
		
		for (Employee emp : myList){
			System.out.println(emp);
		}
	}
	
	/*
	public void addElement(Employee emp) {
		myList.add(emp);
	}
	*/
	
	public static void main(String[] args) {
		
		//List<? extends Employee> list = new ArrayList<Programmer>(); 
		//list.add(new Programmer());
		//list.add(new Architect());
		
		List<Programmer> list = new ArrayList<Programmer>();
		
		list.add(new Programmer());
		list.add(new SeniorProgrammer());
		list.add(new JuniorProgrammer());
		
		UpperBoundedExample example = new UpperBoundedExample(list);
		
		example.printAll();
	}
}
