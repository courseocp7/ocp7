package javacourse.ocp.io.file;

import java.io.File;
import java.io.IOException;

/**
 * 
 * Example of using {@link java.io.File}
 * 
 * @author Jose Blesa
 *
 */
public class FileExample {
	
	public static void basic() {
		
		File file = new File("Prueba.txt");
		
		System.out.println(file.getAbsolutePath()); //The file doesn't exist
		System.out.println(file.exists());
		System.out.println(file.isFile()); 
		System.out.println(file.isDirectory());
	}
	
	
	public static void createFile() throws IOException {
		
		File file = new File("Prueba.txt");
		boolean isNewFile = false;
		
		isNewFile = file.createNewFile();
		
		System.out.printf("path? %s \n", file.getAbsolutePath());
		System.out.printf("new? %b \n", isNewFile);
		System.out.printf("file? %b \n", file.isFile()); 
		System.out.printf("directory? %b \n", file.isDirectory());
	}
	
	/**
	 * Creating directories with mkdir and mkdirs methods.
	 * 
	 * @throws IOException
	 */
	public static void createDirectories() throws IOException {
		
		File file = new File("prueba\\prueba.txt"); //Watch out!!!
		
		//file.mkdir();
		file.mkdirs();
		
		System.out.println(file.getAbsolutePath());
		System.out.println(file.isFile()); 
		System.out.println(file.isDirectory());
	}	
	
	
	
	public static void main(String[] args) throws IOException {
		
		//basic();
		createFile();
		//createDirectories();

	}

}
