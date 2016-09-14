package javacourse.ocp.dataformat.dates.calendar;

import java.util.Calendar;

/**
 * Example of using Calendar abstract class.
 *  
 * @author Jose Blesa
 *
 */
public class CalendarExample2 {
	
	public static void main(String[] args) {
		
		Calendar cal = Calendar.getInstance(); //comment this line and uncomment bellow
		
		System.out.println("current date..........." + cal.getTime());
		System.out.println("----------------------------------------------------");
		System.out.println("");
		
		cal.add(Calendar.HOUR_OF_DAY, 3);
		System.out.println("adding 3 hours........." + cal.getTime());
		
		cal.add(Calendar.HOUR_OF_DAY, -3);
		System.out.println("substracting 3 hours..." + cal.getTime());		
		
		cal.add(Calendar.MINUTE, 59);
		System.out.println("adding 59 minutes......" + cal.getTime());
		
		cal.roll(Calendar.MINUTE, 59);
		System.out.println("Rolling 59 minutes....." + cal.getTime());
		
	}
}