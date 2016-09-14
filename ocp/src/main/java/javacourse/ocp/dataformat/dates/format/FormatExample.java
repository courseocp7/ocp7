package javacourse.ocp.dataformat.dates.format;

import java.text.DateFormat;
import java.util.Calendar;

public class FormatExample {
	
	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		
		DateFormat formatDefault = DateFormat.getInstance();
		DateFormat format2 = DateFormat.getDateInstance();
		DateFormat format3 = DateFormat.getDateInstance(DateFormat.SHORT);
		DateFormat format4 = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.SHORT);
				
		System.out.println(formatDefault);
		System.out.println(formatDefault.format(cal.getTime()));
		System.out.println(format2.format(cal.getTime()));
		System.out.println(format3.format(cal.getTime()));
		System.out.println(format4.format(cal.getTime()));
		
	}
}