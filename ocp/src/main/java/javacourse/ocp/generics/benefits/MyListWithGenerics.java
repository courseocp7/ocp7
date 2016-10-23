package javacourse.ocp.generics.benefits;

import java.util.List;
import java.util.ArrayList;

public class MyListWithGenerics<T> {

	private List<T> list;

	public MyListWithGenerics(List<T> list) {
		this.list = list;
	}

	/**
	 * adds an element at the top of the list.
	 * 
	 * @param element
	 */
	public void addElement(T element) {
		this.list.add(0, element);
	}

	/**
	 * Return the first element from the top of the list.
	 * 
	 * @return Object or null if the list is empty
	 */
	public T popElement() {

		T returned = null;

		if (this.list.size() > 0) {
			returned = this.list.remove(0);
		}

		return returned;

	}

	public int getSize() {
		return this.list.size();
	}

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		MyListWithGenerics<Integer> myList = new MyListWithGenerics<>(list);
		
		myList.addElement(10);
		//myList.addElement("wrong");
		
		System.out.println(myList.getSize());

		Integer num = myList.popElement();
		//String value = (String)myList.popElement();
		
		System.out.println(10 == num);
		
		System.out.println(myList.getSize());
	}
}