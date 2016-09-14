package javacourse.ocp.dataformat.numbers.parse;

import java.text.NumberFormat;
import java.text.ParseException;

public class NumberParseExample2 {

	public static void main(String[] args) {

		NumberFormat nf = NumberFormat.getInstance();
		Number number = 1000.235;

		try {
			Number num = nf.parse(number.toString());
			System.out.println(num); // What will be the output?

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
}