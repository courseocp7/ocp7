package javacourse.ocp.dataformat.dates.parse;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

/**
 * 
 * Example using parse method.
 * 
 * @author Jose Blesa
 *
 */
public class ParseExample {

	public static void main(String[] args) {

		Calendar cal = Calendar.getInstance();
		DateFormat df = DateFormat.getInstance();

		String date = df.format(cal.getTime());
		
		System.out.println(date);		

		try {
			Date dt = df.parse(date);
			System.out.println(dt);
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
	}
}