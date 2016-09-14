package javacourse.ocp.stringprocessing.regex.grouping;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GroupingExample {
	
	public static void main(String[] args) {
		
		String regex = "(99)";
		String targetString = "99001a00";
		
		Pattern pattern = Pattern.compile(regex);//The regex expression...
		Matcher m = pattern.matcher(targetString);//The text where we are going to search...
		
		while(m.find()){
			
			//ATENTION!!! m.end() returns the next position to the actual last character of the group.
			System.out.println(m.group() + ": from " + m.start() + " to " + m.end());
		}
		
	}

}
