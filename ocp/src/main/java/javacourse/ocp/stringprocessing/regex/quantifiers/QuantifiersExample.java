package javacourse.ocp.stringprocessing.regex.quantifiers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Example of using quantifiers
 * 
 * @author Jose Blesa
 *
 */
public class QuantifiersExample {
	
	public static void main(String[] args) {
		
		//String regex = "ja?va"; // ? 0 o 1 ocurrencia
		//String regex = "ja*va";   // * 0 o + ocurrencias
		//String regex = "ja+va";   // + 1 ó + ocurrencias
		
		//String regex = "[A-Za-z]\\d*[A-Za-z]";
		String regex = "[A-Za-z][3-7]*[A-Za-z]";
		
		//String targetString = "java jva jaava jav 7";
		String targetString = "aa6abcd456s7ss";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(targetString);
		
		System.out.println(m.pattern());
		System.out.println(targetString);
		
		while(m.find()){
			//ATENTION!!! m.end() returns the next position to the actual last character of the group.
			System.out.println(m.group() + ": from " + m.start() + " to " + m.end());
		}
	}
}