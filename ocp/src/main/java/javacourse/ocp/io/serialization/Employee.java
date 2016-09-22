package javacourse.ocp.io.serialization;

import java.io.Serializable;

public class Employee extends Developer implements Serializable {
	
	private String name;
	private short age;
	
	public Employee(){}
	
	public Employee(String name, short age, Departament dpto, String language){
		super(language);
		this.name = name;
		this.age = age;
	}
	
	public short getAge() {
		return age;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString(){
		return name+age;
	}
}
