package Cs;

import java.io.IOException;

import Type.ArithmeticOperators;
import Type.AssignmentOperators;
import Type.BitwiseOperators;
import Type.KeyWords;
import Type.KeyWordsType2;
import Type.LogicalOperators;
import Type.Manipulators;
import Type.Methods;
import Type.MiscellaneousOperators;
import Type.NumericValues;
import Type.RelationsOperators;
import Type.Texts;
import Type.Variables;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArithmeticOperators arithmeticOperators = new ArithmeticOperators();
		LogicalOperators logicalOperators = new LogicalOperators();
		RelationsOperators relationsOperators = new RelationsOperators();
		BitwiseOperators bitwiseOperators = new BitwiseOperators();
		MiscellaneousOperators miscellaneousOperators = new MiscellaneousOperators();
		AssignmentOperators assignmentOperators = new AssignmentOperators();
		KeyWords keyWordsComplexity1 = new KeyWords();
		KeyWordsType2 keyWordsComplexity2 = new KeyWordsType2();
		Texts textsComplexity = new Texts();
		Manipulators manipulatorsComplexity = new Manipulators();
		Methods methodComplexity = new Methods();
		NumericValues numericValuesComplexity = new NumericValues();
		Variables variablesComplexity = new Variables();

		String filePath = "/home/jaliya/Desktop/Projects/CodeComplexity/Complexity_of_a_program/src/SrcCodes/FibonacciMain.java";
		ReadFileLineByLine readFileLineByLine = new ReadFileLineByLine();
		String[] code;
		code = readFileLineByLine.file(filePath);

		int arithmetic[] = arithmeticOperators.complexity(code);
		int assignment[] = assignmentOperators.complexity(code);
		int bitwise[] =bitwiseOperators.complexity(code);
		int keyWords1[] = keyWordsComplexity1.complexity(code);
		int keyWords2[] = keyWordsComplexity2.complexity(code);
		int logical[] = logicalOperators.complexity(code);
		int manipulators[] = manipulatorsComplexity.complexity(code);
		int method[] = methodComplexity.complexity(code);
		int miscellaneous[] = miscellaneousOperators.complexity(code);
		int numericValues[] = numericValuesComplexity.complexity(code);
		int relations[] = relationsOperators.complexity(code);
		int tests[] = textsComplexity.complexity(code);
		//int variables[] = variablesComplexity.complexity(code);
		int i = 0;
		for (String s : code) {
			System.out.println(s);
			System.out.println("\tCs :" + (
					arithmetic[i]+
					assignment[i]+
					bitwise[i]+
					keyWords1[i]+
					keyWords2[i]+
					logical[i]+
					manipulators[i]+
					method[i]+
					miscellaneous[i]+
					numericValues[i]+
					relations[i]+
					tests[i]));
			System.out.println("");
			i++;
		}
	}

}
