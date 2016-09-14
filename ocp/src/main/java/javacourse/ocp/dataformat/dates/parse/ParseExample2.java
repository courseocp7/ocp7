package javacourse.ocp.dataformat.dates.parse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * Example using parse method.
 * 
 * @author Jose Blesa
 *
 */
public class ParseExample2 {

	public static void main(String[] args) {
		
		String str = "11/septiembre/2016 18:01:31:585 +0200";
		
		SimpleDateFormat df = 
				new SimpleDateFormat("dd/MMMM/yyyy HH:mm:ss:SS Z"); 

		try {
			Date dt = df.parse(str);
			System.out.println(dt);
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
	}
}