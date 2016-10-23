package javacourse.ocp.generics.basic;

public class GenericClass<T> {

	private T object;

	public GenericClass(T object) {
		this.object = object;
	}

	public T get() {
		return object;
	}

	public static void main(String[] args) {

		GenericClass<Integer> generic = new GenericClass<>(10);
		Integer value = generic.get();
		System.out.println(value);
	}
}

class OtherGenericClass<T1, T2> {

	private T1 object1;
	private T2 object2;

	public OtherGenericClass(T1 object) {
		this.object1 = object;
		this.object2 = null;
	}

	public OtherGenericClass(T1 object1, T2 object2) {
		this(object1);
		this.object2 = object2;
	}

	@Override
	public String toString() {
		StringBuilder strb = new StringBuilder();

		strb.append(object1);
		strb.append(":");
		strb.append(object2);

		return strb.toString();

	}

	public static void main(String[] args) {

		OtherGenericClass<Integer, String> generic = new OtherGenericClass<>(10);
		System.out.println(generic);
		
		// The same class using other types....
		OtherGenericClass<String, String> generic2 = new OtherGenericClass<>("Hello", "Java");
		System.out.println(generic2);

	}

}
