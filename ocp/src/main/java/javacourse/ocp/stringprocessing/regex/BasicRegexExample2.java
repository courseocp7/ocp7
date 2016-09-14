package javacourse.ocp.stringprocessing.regex;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * 
 * Basic example of use RegEx expressions 
 * 
 * @author Jose Blesa
 *
 */
public class BasicRegexExample2 {
	
	
	public static void main(String[] args) {
		
		Pattern p = Pattern.compile("010");//The regex expression...
		Matcher m = p.matcher("010214010");//The text where we are going to search...
		
		System.out.println(m.pattern());
		
		while(m.find()){
			System.out.print(m.start() + " ");
		}
	}
}