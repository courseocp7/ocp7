package javacourse.ocp.io.randomaccess;

import java.io.File;
import java.io.RandomAccessFile;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.*;

public class FileManipulator {

	public static void main(String[] args) {
		String strRead = null;
		try (RandomAccessFile file = new RandomAccessFile("email.txt", "rws")) {
			file.seek(21);
			file.writeUTF("PRIORITY: HIGH");
			strRead = file.readLine();
		} catch (Exception ex) {
			System.err.println(ex);
		}
		System.out.println(strRead);
	}
}
