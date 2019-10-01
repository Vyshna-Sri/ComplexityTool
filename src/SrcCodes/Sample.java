package SrcCodes;

public class Sample {
	private int complexityValue = 1;
	private int noOfDoublequats = 0;
	private int numberOfArithmeticOperators;
	
	public int complexity(String code) {
		int length = code.length();	
		for(int i = 1; i < length-2; i++) {
			char sir = '"';
			char character = code.charAt(i);
			char characterNext = code.charAt(i+1);
			char characterPrev = code.charAt(i-1);
			
			if(character == 'A' && character == 'B') {
				System.out.println("A + B = 3");
				noOfDoublequats++;
			}
			else if(noOfDoublequats%2 ==  1) {
			}
			else if((noOfDoublequats%2) == 0){			
			}
			else if((noOfDoublequats%2) >= 0){			
			}
						int a = 2,b=2;
			
			System.out.println(a | b); System.out.println(a >> b); System.out.println(a >>> b);
			char op = '+';
			switch(op){
		        case '+':
		            break;
		        case '-':
		        case '/':
		            break;
		        default:
		            // If the operator is other than +, -, * or /, error message is shown
		            break;
		    }
			
			System.out.println(a >>>= b);
		}		
		return numberOfArithmeticOperators * complexityValue;		
	}
}
