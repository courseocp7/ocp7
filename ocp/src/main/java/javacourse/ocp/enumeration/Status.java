package javacourse.ocp.enumeration;

public enum Status implements MyInterface{
	
	OFF(0), ON(1);
	
	private final int value;
	
	private Status(int value) {
		this.value = value;
	}
	
	@Override
	public int doSomething() {
		System.out.printf("Doing something....%n");
		return value;
	}
	
	public int getValue(){
		return value;
	}
	
	public static void main(String[] args) {
		
		System.out.println(Status.valueOf("ON"));
		
		System.out.printf("%d%n", Status.ON.ordinal());
		System.out.printf("%d%n", Status.OFF.ordinal());
		
		System.out.println(Status.OFF.values() + "\n");
		System.out.println(Status.OFF.values()[0] + "\n");
		
		System.out.printf("%d%n",Status.ON.doSomething());
		
	}
}

interface MyInterface {
	
	int doSomething();
	
}