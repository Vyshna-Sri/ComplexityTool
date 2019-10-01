package SrcCodes;

import java.io.IOException;
import Type.ArithmeticOperators;
import Type.AssignmentOperators;
import Type.BitwiseOperators;
import Type.KeyWords;
import Type.LogicalOperators;
import Type.MiscellaneousOperators;
import Type.RelationsOperators;
public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArithmeticOperators arithmeticOperators = new ArithmeticOperators();		
		LogicalOperators logicalOperators = new LogicalOperators();
		RelationsOperators relationsOperators = new RelationsOperators();
		BitwiseOperators bitwiseOperators = new BitwiseOperators();
		MiscellaneousOperators miscellaneousOperators = new MiscellaneousOperators();
		AssignmentOperators assignmentOperators = new AssignmentOperators();
		char s = '"';
		String filePath = "/home/jaliya/Desktop/Projects/CodeComplexity/Complexity_of_a_program/src/SrcCodes/factorial.java";
		ReadFileLineByLine readFileLineByLine = new ReadFileLineByLine();
		String[] code;
		code = readFileLineByLine.file(filePath);
		
		//arithmeticOperators.complexity(code);
		
		//logicalOperators.complexity(code);

		//assignmentOperators.complexity(code);
		
		//relationsOperators.complexity(code);
		
		//bitwiseOperators.complexity(code);
		
		//miscellaneousOperators.complexity(code);
		System.out.println("new throws");
		KeyWords keyWords = new KeyWords();
		keyWords.complexity(code);
	}

}
