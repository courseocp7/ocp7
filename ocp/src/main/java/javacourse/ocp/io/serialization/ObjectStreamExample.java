package javacourse.ocp.io.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

public class ObjectStreamExample {

	public static void serializeObject(Object obj, String path) throws IOException {

		FileOutputStream output = new FileOutputStream(path);

		try (ObjectOutputStream outputObject = new ObjectOutputStream(output)) {
			outputObject.writeObject(obj);
			outputObject.writeInt(10);
			outputObject.writeBoolean(true);
			outputObject.flush();
		}
		
		System.out.println("serialized object!!!!");
	}

	public static Object getObject(String path) throws IOException, FileNotFoundException, ClassNotFoundException {

		FileInputStream input = new FileInputStream(path);
		Object returnedObject = null;

		try (ObjectInputStream inputObject = new ObjectInputStream(input)) {
			returnedObject = inputObject.readObject();
		}
		
		return returnedObject;
	}

	public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {

		Employee emp = new Employee("James", (short) 46, new Departament("IT"), "java");
		emp.setVar("changeit");
		ObjectStreamExample.serializeObject(emp, emp.toString());
		
		Employee emp2 = (Employee)ObjectStreamExample.getObject(emp.toString());
		
		System.out.println(emp2 == emp);
		System.out.println(emp2.getName());
		System.out.println(emp2.getAge());
		System.out.println(emp2.getCode());
		System.out.println(emp2.getVar());
	}
}
