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
public class BasicRegexExample3 {
	
	
	public static void main(String[] args) {
		
		Pattern p = Pattern.compile("\\S");//The regex expression...
		Matcher m = p.matcher("01f sd\t-    0");//The text where we are going to search...
		
		System.out.println(m.pattern());
		
		while(m.find()){
			System.out.print(m.start() + " ");
		}
	}
}