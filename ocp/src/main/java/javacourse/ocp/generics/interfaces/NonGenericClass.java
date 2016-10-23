package javacourse.ocp.generics.interfaces;

public class NonGenericClass implements GenericInterface<Integer, Integer, Integer> {
	
	public Integer doSum(Integer operand1, Integer operand2){
		return operand1 + operand2;
	}
	
	public static void main(String[] args) {
		
		NonGenericClass mc = new NonGenericClass();
		
		//mc.doSum(10, "pepe");
		int num = mc.doSum(10, 20);
		
		System.out.println(num);
	}
}

//Create other class extending with different parameter types to see what appends...
