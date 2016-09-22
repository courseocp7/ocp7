package javacourse.ocp.stringprocessing.regex.quantifiers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * basic examples of quantifers symbols * ? +
 * 
 * @author Jose Blesa
 *
 */

public class BasicQuantifier {
	
	
	public static void main(String[] args) {
		
		//Left just one line uncommented to try the result..
		
		//String regex = "[A-Za-z]*"; 
		//String regex = "[A-Za-z]{0,}"; // It's the same than above
		
		//String regex = "[A-Za-z]+"; 
		//String regex = "[A-Za-z]{1,}"; // It's the same than above
		
		String regex = "[A-Za-z]?"; 
		//String regex = "[A-Za-z]{0,1}"; // It's the same than above
		
		
		String targetString = "aa6abcd456s7ss";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(targetString);
		
		System.out.println(String.format("pattern : %s", m.pattern()));
		System.out.println(String.format("target string : %s" , targetString));
		
		while(m.find()){
			//ATENTION!!! m.end() returns the next position to the actual last character of the group.
			System.out.println(m.group() + ": from " + m.start() + " to " + m.end());
		}
		
		
		
	}
	
	
	

}
