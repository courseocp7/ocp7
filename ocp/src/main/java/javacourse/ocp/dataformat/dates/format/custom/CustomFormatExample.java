package javacourse.ocp.dataformat.dates.format.custom;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


/**
 * Example of using SimpleDateFormat to customize the output format 
 * of dates and / or  times.
 *  
 * @author Jose Blesa
 *
 */
public class CustomFormatExample {
	
	public static void main(String[] args) {
		
		SimpleDateFormat sdf = 
				new SimpleDateFormat("dd/MMMM/yyyy HH:mm:ss:SS Z"); 
												//,new Locale("en"));
		Calendar cal = Calendar.getInstance(new Locale("de"));
		System.out.println(sdf.format(cal.getTime()));
	}
}
