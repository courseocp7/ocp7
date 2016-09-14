package javacourse.ocp.dataformat.numbers;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Example using currencies with NumberFormat and Locale classes
 * 
 * 
 * @author Jose Blesa
 *
 */
public class NumberFormatExample2 {
	
	public static void main(String[] args) {
		
		NumberFormat nf = NumberFormat.getInstance();
		//NumberFormat nf = NumberFormat.getInstance(Locale.US);
		//NumberFormat nf = NumberFormat.getCurrencyInstance();
		//NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.US);
		//NumberFormat nf = NumberFormat.getIntegerInstance(Locale.US);
		//NumberFormat nf = NumberFormat.getPercentInstance(Locale.US);		
		
		//getNumberInstance() is the same than calling getInstance();
		//NumberFormat nf = NumberFormat.getNumberInstance(Locale.US);

		double number = 1025.36; 
		System.out.println(nf.format(number));
	}
}