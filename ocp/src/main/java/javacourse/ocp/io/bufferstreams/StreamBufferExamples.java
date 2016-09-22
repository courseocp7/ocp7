package javacourse.ocp.io.bufferstreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javacourse.ocp.io.streams.FileStreamExamples;

/**
 * The performance of the buffered streams vs regular streams plus byte array is minimal.
 * 
 * A buffered stream has 8192 ( 8 * 1024) bytes of internal memory (buffer) by default.
 * 
 * @author Jose Blesa
 *
 */
public class StreamBufferExamples {

	public static void bufferStreamExample(String source, String target, int bufferSize)
			throws FileNotFoundException, IOException {

		FileInputStream input = new FileInputStream(source);
		FileOutputStream output = new FileOutputStream(target);
		
		try (BufferedInputStream bin = new BufferedInputStream(input, 1024);
			 BufferedOutputStream bout = new BufferedOutputStream(output, 1024);) {
			long start = System.currentTimeMillis();
			int data;
			while ((data = bin.read()) != -1) { // reading byte after byte.... 
				bout.write(data);
			}
			System.out.println(System.currentTimeMillis() - start);
			bin.close();
		}
	}
	

	/**
	 * 
	 * @param source
	 * @param target
	 * @param bufferSize
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void bufferStreamExample2(String source, String target, int bufferSize)
			throws FileNotFoundException, IOException {
		
		byte[] buffer = new byte[8192];
		
		FileInputStream input = new FileInputStream(source);
		FileOutputStream output = new FileOutputStream(target);

		try (BufferedInputStream bin = new BufferedInputStream(input);
			 BufferedOutputStream bout = new BufferedOutputStream(output);) {
			long start = System.currentTimeMillis();
			int data;
			while ((data = bin.read(buffer)) != -1) { // reading byte after byte.... 
				bout.write(buffer, 0 , data);
			}
			System.out.println(System.currentTimeMillis() - start);
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		//FileStreamExamples.copyByteByByteFile("jls7.pdf", "jls7-copiedByteByByte.pdf");
		FileStreamExamples.copyWithByteArrayFile("jls7.pdf", "jls7-copied2.pdf", 1024);
		//bufferStreamExample("jls7.pdf", "jls7-copiedBuffered.pdf", 1024);
		bufferStreamExample2("jls7.pdf", "jls7-copiedBufferedWithBuffer.pdf", 1024);

	}

}
