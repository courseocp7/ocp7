package javacourse.ocp.io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;

public class StreamChainingExample {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File file = new File("prueba.txt");
		
		InputStream input = new FileInputStream(file);  
		BufferedInputStream buffer = new BufferedInputStream(input);
		
		Reader reader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(reader);
		
	}
}