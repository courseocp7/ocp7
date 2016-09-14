package javacourse.ocp.dataformat.resourcebundles;

import java.util.ResourceBundle;

/**
 * Example using PropertyResourceBundle 
 *  
 * @author Jose Blesa
 *
 */
public class PropertyResourceBundleExample {
	
	
	public static void main(String[] args) {
		
		ResourceBundle resource = ResourceBundle.getBundle("javacourse.ocp.dataformat.resourcebundles.ExampleBundle"); //Using the current Locale (JVM)
		System.out.println(resource);
		System.out.println(resource.getString("foot"));
		System.out.println(resource.getString("title"));
		
		/*
		resource = ResourceBundle.getBundle("ExampleBundle", new Locale("en", "UK")); //Using a specific Locale
		System.out.println(resource.getString("title"));		
		
		resource = ResourceBundle.getBundle("ExampleBundle", new Locale("en")); //Using a specific but more generic Locale
		System.out.println(resource.getString("title"));
		
		resource = ResourceBundle.getBundle("ExampleBundle", new Locale("en", "UK")); //Using a specific Locale but with a key not in that bundle...
		System.out.println(resource.getString("foot"));		
				
		resource = ResourceBundle.getBundle("ExampleBundle", new Locale("fr", "CA")); //Using a specific Locale but with a key not in that bundle...
		System.out.println(resource.getString("foot"));
		*/		

		
	}

}
