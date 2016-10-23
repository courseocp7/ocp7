package javacourse.ocp.generics.extending;

public class BaseGenericClass<T> {
	
	private T id;
	
	public T getId(){
		return id;
	}
	
	protected BaseGenericClass(T id) {
		this.id = id;
	}

}