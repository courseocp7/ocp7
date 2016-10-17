package javacourse.ocp.javadesign.basics.hashcode;

import java.util.HashMap;
import java.util.Map;

public class HashCodeExample {

	int number;

	HashCodeExample(int number) {
		this.number = number;
	}

	public int hashCode() {
		int sum = 0;
		long num = number;
		do {
			sum += num % 10;
			num /= 10;
		} while (num != 0);
		return sum;
	}
	
	
	public static void main(String[] args) {
		
		Map<HashCodeExample, String> map = new HashMap<>();
		HashCodeExample num1 = new HashCodeExample(1200);
		System.out.printf("num1 hasCode = %d%n", num1.hashCode());
		
		HashCodeExample num2 = new HashCodeExample(2500);
		HashCodeExample num3 = new HashCodeExample(57123);
		map.put(num1, "John");
		map.put(num2, "Mary");
		map.put(num3, "Sam");
		
	}
}




