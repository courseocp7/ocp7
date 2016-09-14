package javacourse.ocp.stringprocessing.regex.boundaries;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Example of using quantifiers (? * +) 
 * 
 * @author Jose Blesa
 *
 */
public class BoundariesExample {
	
	public static void main(String[] args) {
		
		//String regex = "\\bca|ca\\b"; // que empieze por ca o que acabe por ca
		String regex = "\\bla\\b"; // que no empieza por ca pero que acabe por ca
		String targetString = "la casa blanca de mi abuela está en la ladera junto a la llanura";
		
		Pattern pattern = Pattern.compile(regex);//The regex expression...
		Matcher m = pattern.matcher(targetString);//The text where we are going to search...
		
		System.out.println(m.pattern());
		System.out.println(targetString);
		
		while(m.find()){
			
			//ATENTION!!! m.end() returns the next position to the actual last character of the group.
			System.out.println(m.group() + ": from " + m.start() + " to " + m.end());
		}
	}
}