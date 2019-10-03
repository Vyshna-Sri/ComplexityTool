package SrcCodes;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class MyException{
	static void accessFiles() throws FileNotFoundException{
		try {
			FileReader f = new FileReader("D:\\Exceptions.doc");
			System.out.println("File found");
		}
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			throw e;// Rethroxzws the exception
		}
	}
	
	public static void main(String[] args) {
		try {
			accessFiles();
		}
		catch (FileNotFoundException e) {
			System.out.println("File cannot be found!");
		}
	}

}
