package javacourse.ocp.stringprocessing.regex.characterclasses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Example of Matcher's replaceAll(String) method
 *  
 * @author Jose Blesa
 *
 */
public class MatcherReplaceAllExample2 {
	
	public static void main(String[] args) {
		
		String regex = "[a-c]123";
		String targetString = "0a12310ab123sw";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(targetString);
		
		System.out.println(m.pattern());
		System.out.println(targetString);
		
		System.out.println(m.replaceAll("*"));
		
	}

}
