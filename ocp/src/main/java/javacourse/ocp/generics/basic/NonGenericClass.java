package javacourse.ocp.generics.basic;

public class NonGenericClass {
	
	private Object object;
	
	public NonGenericClass(Object object) {
		this.object = object;
	}
	
	public Object get(){
		return object;
	}
}