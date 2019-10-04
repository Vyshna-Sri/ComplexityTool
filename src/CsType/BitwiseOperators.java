package CsType;

public class BitwiseOperators {
	private int complexityValue = 1;
	private int noOfDoublequotes = 0;
	private int noOfSinglequote = 0;
	private int numberOfBitwiseOperators;
	//private int totalNumberOfBitwiseOperators = 0;
	private int i = 0;
	
	public int[] complexity(String[] code) {
		int complexity[] = new int[code.length];

	    for (String s : code) {
	    	String line = s;
	    	int length = s.length();    
			for(int i = 0; i < length-1; i++) {
				char character = line.charAt(i);
				char characterNext = 0;
				char characterNextNext =0;
				char characterPrev =0;
				
				if(i != line.length()) {
					characterNext = line.charAt(i+1);
		        }
				if(character == '/' && characterNext =='/') {
					break;
				}
		        if(i != line.length()-2) {
		        	characterNextNext = line.charAt(i+2);
		        }
		        if(i != 0) {
					characterPrev = line.charAt(i-1);
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
					if(character != '|' && characterNext == '|' && (characterNextNext != '|')) {
						numberOfBitwiseOperators++;
						//System.out.print("| ,");
					}
					else if(character == '^') {
						numberOfBitwiseOperators++;
						//System.out.print("^ ,");
					}
					else if(character == '~') {
						numberOfBitwiseOperators++;
						//System.out.print("~ ,");
					}				
					else if(character == '<' && characterNext == '<' && characterNextNext != '<' && characterPrev != '<') {
						numberOfBitwiseOperators++;
						//System.out.print("<< ,");
					}
					else if(character == '>' && characterNext == '>' && characterNextNext != '>' && characterPrev != '>') {
						numberOfBitwiseOperators++;
						//System.out.print(">> ,");
					}
					else if(character == '<' && characterNext == '<' && characterNextNext == '<') {
						numberOfBitwiseOperators++;
						//System.out.print("<<< ,");
					}
					else if(character == '>' && characterNext == '>' && characterNextNext == '>') {
						numberOfBitwiseOperators++;
						//System.out.print(">>> ,");
					}
				}
			}
			//System.out.println(s);
	        //System.out.println("\tNumber Of Bitwise Operators :"+ numberOfBitwiseOperators);
	        //System.out.println("");
	        complexity[i] = numberOfBitwiseOperators* complexityValue;

	    	
	    	//totalNumberOfBitwiseOperators = totalNumberOfBitwiseOperators + numberOfBitwiseOperators;
	    	numberOfBitwiseOperators = 0;
	    	i++;
		}		
        //System.out.println("Total Number Of Bitwise Operators :" +totalNumberOfBitwiseOperators);

		return complexity;		
	}

}
