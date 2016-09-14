package javacourse.ocp.dataformat.dates.locale;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

public class LocaleExample {
	
	public static void main(String[] args) {
		
		Locale loc = new Locale("ca", "es");
		
		Calendar cal = Calendar.getInstance();
		
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, loc);
		
		System.out.println("default locale: " + Locale.getDefault().getCountry());
		System.out.println("default locale: " + Locale.getDefault().getLanguage());
		
		Locale.setDefault(new Locale ("ca", "es"));
		
		System.out.println(df.format(cal.getTime())); // formatted...
		System.out.println(cal.getTime()); // Not formatted...
		
		System.out.println(loc.getDisplayCountry());
		System.out.println(loc.getDisplayLanguage());

		System.out.println(loc.getDisplayCountry(loc));
		System.out.println(loc.getDisplayLanguage(loc));
		
		Locale enLoc = new Locale("it", "it");
		
		System.out.println(loc.getDisplayCountry(enLoc));
		System.out.println(loc.getDisplayLanguage(enLoc));		
		
	}

	
	
	
}
