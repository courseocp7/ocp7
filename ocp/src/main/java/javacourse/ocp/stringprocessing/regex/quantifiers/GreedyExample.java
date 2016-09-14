package javacourse.ocp.stringprocessing.regex.quantifiers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GreedyExample {

	public static void main(String[] args) {

		String regex = ".*xx";
		//String regex = ".*?xx";
		
		String targetString = "yyxxxyxx";

		Pattern pattern = Pattern.compile(regex);
		Matcher m = pattern.matcher(targetString);

		while (m.find()) {
			System.out.println(m.group() + ": from " + m.start() + " to " + m.end());
		}
	}

}