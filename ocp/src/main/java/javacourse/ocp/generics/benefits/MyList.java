package javacourse.ocp.generics.benefits;

import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public class MyList {

	private final List list;

	public MyList(List list) {
		this.list = list;
	}

	/**
	 * adds an element at the top of the list.
	 * 
	 * @param element
	 */
	@SuppressWarnings("unchecked")
	public void addElement(Object element) {
			this.list.add(0, element);
	}

	/**
	 * Return the first element from the top of the list.
	 * 
	 * @return Object or null if the list is empty
	 */
	public Object popElement() {

		Object returned = null;

		if (this.list.size() > 0) {
			returned = this.list.remove(0);
		}

		return returned;

	}

	public int getSize() {
		return this.list.size();
	}

	public static void main(String[] args) {

		ArrayList list = new ArrayList();
		MyList myList = new MyList(list);
		
		myList.addElement(10);
		//myList.addElement("pepe");
		
		System.out.println(myList.getSize());

		int num = (Integer) myList.popElement(); // We need to do a explicit
		System.out.println(10 == num);
		
		System.out.println(myList.getSize());

	}
}