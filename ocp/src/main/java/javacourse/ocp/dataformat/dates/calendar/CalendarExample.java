package javacourse.ocp.dataformat.dates.calendar;

import java.util.*; //Just to avoid errors when change commented code

/**
 * Example of instantiating Calendar object.
 *  
 * @author Jose Blesa
 *
 */
public class CalendarExample {
	
	public static void main(String[] args) {
		
		Calendar cal2 = Calendar.getInstance(); //comment this line and uncomment the next line 
		//GregorianCalendar cal2 = new GregorianCalendar(); 
		Date date = cal2.getTime();
		
		System.out.println(date.toString());
		System.out.println(cal2);		
		
	}
}