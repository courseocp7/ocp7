package javacourse.ocp.io.characters;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;

/**
 * 
 * @author Jose Blesa
 *
 */
public class PrintWriterExample {
	
	
	public static void main(String[] args) throws FileNotFoundException {
		
		//PrintWriter print = new PrintWriter(System.out, true);
		PrintWriter print = new PrintWriter(System.out);
		
		print.format("[%b]\n", true);
		print.format("[%10b]\n", true);
		print.format("[%-10b]\n", false);
		print.format("[%.2b]\n", new Boolean(false));
		
		print.format("[%20s]\n", "ejemplo");
		
		print.format("[%f]\n", 12310.309);
		//print.format("[%f]\n", 12310); //uncomment and try again...		
		print.format("[%10f]\n", 12310.309);
		print.format("[%10.2f]\n", 12310.309);		
		print.format("[%,f]\n", 12310.309);
		print.format(Locale.US,"[%10f]\n", 10.309);
		print.format(Locale.US,"[%-10f]\n", 10.309);
		
		print.format("[%d]\n", 12310);
		print.format("[%10d]\n", 12310);
		print.format("[%-10d]\n", 12310);		
		print.format("[%10d]\n", -12310);		
		print.format("[%(+10d]\n", -12310);
		print.format("[%010d]\n", 12310);		
		print.printf("[%,d]\n", 12310);
		
		//print.format("[%10.2d]\n", 12310); //uncomment and try again...		
		
		//print.flush(); //Watch out! not flushing...
		//print.close();

	}

}
