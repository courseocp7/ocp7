package javacourse.ocp.dataformat.numbers;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Example using NumberFormat class and Locale
 * 
 * 
 * @author Jose Blesa
 *
 */
public class NumberFormatExample {
	
	public static void main(String[] args) {
		
		//Locale.setDefault(Locale.US);
		
		NumberFormat nf = NumberFormat.getInstance();
		//NumberFormat nf = NumberFormat.getInstance(Locale.US);
		
		Locale.setDefault(Locale.US);

		double number = 1025.36; 
		System.out.println(nf.format(number)); //What will be the output?
	}
}