package javacourse.ocp.generics.extending;

//public class ChildGenericClass<T, T2> extends BaseGenericClass<T3> { //Won't compile...
public class ChildGenericClass<T, T2> extends BaseGenericClass/*<T>*/ {

	private T2 entity;

	public ChildGenericClass(T id, T2 entity) {
		super((id));
		this.entity = entity;
	}

	public T2 getEntity() {
		return entity;
	}

	public void printEntity() {
		System.out.println(getEntity());
	}

	public static void main(String[] args) {

		//ChildGenericClass<Integer, String> child = new ChildGenericClass<>(10, "Java");
		ChildGenericClass<String, String> child = new ChildGenericClass<>("ocp", "Java");
		
		Integer value = (Integer)child.getId();
		//String value = child.getId();
		//Integer value  = child.getId(); 
		
		System.out.println(value);

	}

}