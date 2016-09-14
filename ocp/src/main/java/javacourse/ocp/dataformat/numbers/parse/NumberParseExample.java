package javacourse.ocp.dataformat.numbers.parse;

import java.text.NumberFormat;
import java.text.ParseException;

/**
 * Example of use NumberFormat's parse method. 
 * 
 * @author Jose Blesa
 *
 */
public class NumberParseExample {
	
	
	public static void main(String[] args) {
		
		NumberFormat nf = NumberFormat.getInstance();
		
		String number = nf.format(1000.235);
		System.out.println("The number formatted: " + number);
		
		try {
			Number num = nf.parse(number);
			System.out.println("The same number after parsing: " + num);
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
