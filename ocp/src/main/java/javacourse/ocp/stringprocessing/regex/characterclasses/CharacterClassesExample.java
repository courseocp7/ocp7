package javacourse.ocp.stringprocessing.regex.characterclasses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Example of using a bad order in a range and how works the caret symbol.
 * 
 * @author Jose Blesa
 *
 */
public class CharacterClassesExample {
	
	public static void main(String[] args) {
		
		//String regex = "[c-a]123"; // The range's order has to be ascending!!!
		//String regex = "[^a-c]123"; // the caret symbol means: 'I don't want the pattern inside the brackets'.
		String regex = "ab[a-z]*?[a-c]"; // the caret symbol means: 'I don't want the pattern inside the brackets'.
		String targetString = "abcdef";
		
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
