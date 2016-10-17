package javacourse.ocp.javadesign.basics;

abstract class OverwrittedClass {
	
	protected String doSomething(){
		return "doing something...";
	}
}

public abstract class OverwittenExample extends OverwrittedClass {
	
	@Override
	protected String doSomething(){
		return "doing something different";
	} 
}