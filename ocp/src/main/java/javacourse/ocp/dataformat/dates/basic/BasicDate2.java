package javacourse.ocp.dataformat.dates.basic;

import java.util.Date;

/**
 * Use of getTime and setTime methods.
 * 
 * @author Jose Blesa
 *
 */
public class BasicDate2 {
	
	public static void main(String[] args){
		
		Date date = new Date(); //By default; the current date and time.
		
		System.out.println(date.toString());
		
		date.setTime(date.getTime() + 3_600_000L); //adding 1 hour to current date...
		System.out.println(date.toString());
	}
}