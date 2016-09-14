package javacourse.ocp.dataformat.locale;

import java.util.Locale;

public class LocaleBuilderExample {
	
	public static void main(String[] args) {
		
		Locale loc = new Locale("es", "ES");
		Locale loc2 = Locale.CHINA;
		
		
		
		System.out.println("locale2 coountry : " + loc2.getCountry());
		
		Locale.Builder builder = new Locale.Builder();
		
		builder.setRegion(Locale.CANADA.getCountry());
		builder.setLanguage(Locale.CANADA.getLanguage());
		
		Locale locale = builder.build();
		
		System.out.println(locale.getCountry());
		System.out.println(locale.getDisplayCountry());
		System.out.println(locale.getLanguage());
		System.out.println(locale.getDisplayLanguage(Locale.UK));
		
		System.out.println("------------------------------");
		
		for(Locale loc3 : Locale.getAvailableLocales()){
			System.out.println(loc3);
			
		}
		
	}

}
