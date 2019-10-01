package Cs;

import java.io.FileNotFoundException;

import Type.TestAO;

public class TestMain {

	public static void main(String[] args) throws FileNotFoundException {
		String filePath = "/home/jaliya/Desktop/Projects/CodeComplexity/Complexity_of_a_program/src/SrcCodes/Sample.cpp";
		ReadFileLineByLine readFileLineByLine = new ReadFileLineByLine();
		String[] code;
		code = readFileLineByLine.file(filePath);

	}

}
