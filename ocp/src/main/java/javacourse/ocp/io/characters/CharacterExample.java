package javacourse.ocp.io.characters;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * 
 * @author Jose Blesa
 *
 */
public class CharacterExample {

	public static void saveToFile(String source, String target) throws FileNotFoundException, IOException {

		try (Reader reader = new FileReader(source); Writer writer = new FileWriter(target)) {
			int c;
			long start = System.currentTimeMillis();
			while ((c = reader.read()) != -1) {
				writer.write(c);
			}
			System.out.println(System.currentTimeMillis() - start);
			System.out.println("done!!");
		}
	}

	public static void saveToFileWithBuffer(String source, String target)
			throws FileNotFoundException, IOException, InterruptedException {

		/*
		 * try to do the same with buffering a read(char[]) / write(char[]) and
		 * let's practice about flushing...
		 */
	}

	public static void saveToFileWithBufferedStreams(String source, String target)
			throws IOException, FileNotFoundException, InterruptedException {

		Reader reader = new FileReader(source);
		Writer writer = new FileWriter(target);

		try (BufferedReader bufReader = new BufferedReader(reader);
				BufferedWriter bufWriter = new BufferedWriter(writer)) {
			int c;
			long start = System.currentTimeMillis();
			while ((c = bufReader.read()) != -1) {
				bufWriter.write(c);
				//bufWriter.flush(); //What happens when uncomment this line?
			}

			System.out.println(System.currentTimeMillis() - start);
			System.out.println("done!!");
		}

	}

	public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {

		//CharacterExample.saveToFile("big.txt", "big-copy.txt");
		//CharacterExample.saveToFileWithBuffer("big.txt", "big-copy.txt");
		CharacterExample.saveToFileWithBufferedStreams("big.txt", "big-copy.txt");

	}

}
