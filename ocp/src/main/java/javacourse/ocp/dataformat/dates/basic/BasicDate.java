package javacourse.ocp.dataformat.dates.basic;

import java.util.Date;

/**
 * Example of use {@link java.util.Date}
 *   
 * @author Jose Blesa
 *
 */
public class BasicDate {
	
	public static void main(String[] args){
		
		Date date = new Date(); //By default; the current date and time.
		
		System.out.println(date.toString()); //formated date and time
		System.out.println(date.getTime()); //number of msecs from Jan 1 1970
		
		Date date2 = new Date(0);
		System.out.println(date2.toString()); //formated date and time
	}
}