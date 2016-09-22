package javacourse.ocp.io.datastreams;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class DataStreamExample {
	
	public static void saveToFile(String path) throws FileNotFoundException, IOException {
		
		try(FileOutputStream input = new FileOutputStream(path);
			DataOutputStream dataOutput = new DataOutputStream(input);) {
		dataOutput.writeUTF("JAVA");
		dataOutput.writeInt(7);
		dataOutput.writeDouble(30.352);
		dataOutput.writeBoolean(false);
		}
	}
	
	/**
	 * You has to read in the same order that you wrote the data.
	 * Any mismatch with the primitive type read can throws a EOFException or unexpected behavior
	 * 
	 * @param path
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void readFromFile(String path) throws FileNotFoundException, IOException {
		
		FileInputStream input = new FileInputStream(path); //It's not necessary... 
		
		try(DataInputStream dataInput = new DataInputStream(input);) {
		//System.out.println(dataInput.readUTF());
		System.out.println(dataInput.readInt());
		System.out.println(dataInput.readDouble());
		System.out.println(dataInput.readBoolean());
		//System.out.println(dataInput.readBoolean()); //EOFException
		
		}
	}	
	
	
	
	
	public static void main(String[] args) throws IOException{
		DataStreamExample.saveToFile("pruebaDataOutput.bin");
		DataStreamExample.readFromFile("pruebaDataOutput.bin");
	}

}
