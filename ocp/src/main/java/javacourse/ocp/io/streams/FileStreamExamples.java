package javacourse.ocp.io.streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 
 * @author Jose Blesa
 *
 */
public class FileStreamExamples {

	public static void copyByteByByteFile(String source, String target)
			throws FileNotFoundException, IOException, InterruptedException {

		int byteRead = 0;
		long start = 0L;

		InputStream input = new FileInputStream(source);
		OutputStream output = new FileOutputStream(target);

		try {
			start = System.currentTimeMillis();
			while ((byteRead = input.read()) != -1) { // returns a byte or -1
														// (EOF)
				output.write(byteRead);
			}
		} finally {
			System.out.println(System.currentTimeMillis() - start);
			input.close();
			System.out.println("done!");
			// Thread.sleep(10000);
			output.close();
		}
	}

	
	public static void copyWithByteArrayFile(String source, String target, int bufferSize)
			throws FileNotFoundException, IOException {

		byte[] buffer = new byte[bufferSize];

		try (FileInputStream input = new FileInputStream(source);
			 FileOutputStream output = new FileOutputStream(target);) { // try-with-resources
			long start = System.currentTimeMillis();
			while ((input.read(buffer)) != -1) { // returns the number of bytes
													// read.
				output.write(buffer); //Watch out... All the buffer contents will be written to output stream!!!!
			}
			System.out.println(System.currentTimeMillis() - start);
		}
	}
	

	public static void copyWithByteArrayFile2(String source, String target, int bufferSize)
			throws FileNotFoundException, IOException {

		byte[] buffer = new byte[bufferSize];
		int numBytesRead = 0;

		try (FileInputStream input = new FileInputStream(source);
				FileOutputStream output = new FileOutputStream(target);) {
			long start = System.currentTimeMillis();
			while ((numBytesRead = input.read(buffer)) != -1) { // returns the
																// number of
																// bytes read.
				output.write(buffer, 0, numBytesRead);
			}

			output.write(1059); //Watch out with this!!!
			System.out.println(System.currentTimeMillis() - start);
		}
	}

	public static void main(String[] args) throws IOException, InterruptedException {

		// copyByteByByteFile("jls7.pdf", "jls7-copiedByteByByte.pdf");
		// copyWithByteArrayFile("jls7.pdf", "jls7-copied2.pdf", 1024);

		copyWithByteArrayFile("test.txt", "test-copied.txt", 10);
		copyWithByteArrayFile2("test.txt", "test-copied2.txt", 10);

	}
}