package javacourse.ocp.dataformat.dates.calendar;

import java.util.Calendar;

/**
 * Example of using Calendar to create a Date class.
 *  
 * @author Jose Blesa
 *
 */
public class CalendarExample3 {
	
	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(2016, Calendar.SEPTEMBER, 14);
		System.out.println(cal.getTime());
		
	}
}