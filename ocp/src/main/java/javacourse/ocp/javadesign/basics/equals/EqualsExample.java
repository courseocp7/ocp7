package javacourse.ocp.javadesign.basics.equals;

class Customer {
	String id;
	
	public Customer(String id) {
		this.id = id;
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj != null && obj instanceof Customer) {
			Customer c = (Customer) obj;
			return (id.equals(c.id));
		} else {
			return false;
		}
	}
}

public class EqualsExample {
	
	public static void main(String[] args) {
		
		Customer c01 = new Customer("ERTW");
		Customer c02 = new Customer("PORT");
		Customer c03 = c01;
		Customer c04 = new Customer("ERTW");
		Customer c05= new Customer(new String("ERTW"));
		
		System.out.printf("Is it reflexive?%n");
		System.out.printf("Is c01 equals to itself ?%b%n%n", c01.equals(c01));
		
		System.out.printf("Is it transitive ?%n");		
		System.out.printf("Is c01 equals to c03 ? %b%n", c01.equals(c03));
		System.out.printf("Is c03 equals to c04 ? %b%n", c03.equals(c04));
		System.out.printf("So, c01 has to be equals to c04 -> %b%n%n", c01.equals(c04));
		
		System.out.printf("Is it simetric?%n");
		System.out.printf("Is c01 equals to c03 ? %b%n", c01.equals(c03));
		System.out.printf("So, c03 equals has to be equals to c01 -> %b%n%n", c03.equals(c01));
		
		System.out.printf("Is c01 equals to c02 ? %b%n", c01.equals(c02));
		System.out.printf("Is c04 equals to c05 ? %b%n%n", c04.equals(c05));
		
		System.out.printf("Is c01 equals to NULL ? %b%n",c01.equals(null));
		
	}
	

	

}
