package exceptions.trywithresources.supressed;

import java.io.IOException;

public class TryWithResources {

	/**
	 * This sample demonstrate how an exception thrown from Try-with-resources
	 * is suppressed when other exception arises from inside the try code block.
	 * 
	 * @throws IOException
	 */
	public static void sample01() throws IOException {

		try (MyClosable mc = new MyClosable()) { // we are throwing an exception
													// from here...

			throw new IOException(); // we are throwing an exception from
										// here...comment this line to compare
										// the results...

		} catch (MyException me) {
			me.printStackTrace();
		}
	}

	public static void main(String[] args) throws Throwable {
		sample01();
	}
}

class MyException extends Exception {
}

class MyClosable implements AutoCloseable {

	@Override
	public void close() throws MyException {
		throw new MyException();
	}
}
