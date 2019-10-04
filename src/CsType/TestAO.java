
package CsType;

public class TestAO {
	private int complexityValue = 1;
	private int noOfDoublequotes = 0;
	private int noOfSinglequote = 0;
	private int numberOfArithmeticOperators = 0;
	private int i = 0;
	
	public int complexity(String code) {
		int length = code.length();	
		for(int i = 0; i < length-1; i++) {
			char character = code.charAt(i);
			char characterNext = 0;
			char characterPrev = 0;
			if(character == '/' && characterNext =='/') {
				break;
			}
			if(i != code.length()) {
				characterNext = code.charAt(i+1);
	        }
	        if(i != 0) {
				characterPrev = code.charAt(i-1);
	        }
			if( character == '\'') {
				noOfSinglequote++;
			}
			if(character == '"' && noOfSinglequote%2 == 0) {
					noOfDoublequotes++;
			}
			else if(noOfDoublequotes%2 ==  1 || noOfSinglequote%2 ==  1) {
				
			}
			else if((noOfDoublequotes%2) == 0 && noOfSinglequote%2 ==  0){			
				if(character == '*' && characterNext != '=') {
					numberOfArithmeticOperators++;
					System.out.println("*");
				}
				else if(character == '/' && (characterNext != '=')) {
					numberOfArithmeticOperators++;
					System.out.print("/ ,");
				}
				else if(character == '%' && (characterNext != '=')) {
					numberOfArithmeticOperators++;
					System.out.print("% ,");
				}				
				else if(character == '+' && characterNext == '+') {
					numberOfArithmeticOperators++;
					System.out.print("++ ,");
				}
				else if(character == '-' && characterNext == '-') {
					numberOfArithmeticOperators++;
					System.out.print("-- ,");
				}
				else if(character == '+' && (characterNext != '+'|| characterNext != '=') && characterPrev != '+') {
					numberOfArithmeticOperators++;
					System.out.print("+ ,");
				}
				else if(character == '-' && (characterNext != '-'|| characterNext != '=') && characterPrev != '-') {
					numberOfArithmeticOperators++;
					System.out.print("- ,");
				}
			}
		}		
		return numberOfArithmeticOperators * complexityValue;		
	}
}

