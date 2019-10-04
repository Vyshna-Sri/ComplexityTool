package CsType;

public class AssignmentOperators {
	private int complexityValue = 1;
	private int numberOfAssignmentOperators;
	private int noOfDoublequotes = 0;
	private int noOfSinglequote = 0;
	//private int totalNumberOfAssignmentOperators = 0;
	private int i = 0;
	
	public int[] complexity(String[] code) {
		int complexity[] = new int[code.length];
		
		 for (String s : code) {
		    	String line = s;
		    	int length = s.length();    
		    	
				for(int i = 0; i < length-1; i++) {
					char character = line.charAt(i);
					char characterNext = 0;
					char characterPrev = 0;
					if(i != line.length()) {
						characterNext = line.charAt(i+1);
			        }

					if(character == '/' && characterNext =='/') {
						break;
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
						if(character == '+' && characterNext == '=') {
							numberOfAssignmentOperators++;
							//System.out.print("+= ,");
						}
						else if(character == '-' && characterNext == '=') {
							numberOfAssignmentOperators++;
							//System.out.print("-= ,");
						}
						else if(character == '*' && characterNext == '=') {
							numberOfAssignmentOperators++;
							//System.out.print("*= ,");
						}				
						else if(character == '/' && characterNext == '=') {
							numberOfAssignmentOperators++;
							//System.out.print("/= ,");
						}
						else if(character == '-' && characterNext == '-') {
							numberOfAssignmentOperators++;
							//System.out.print("-- ,");
						}
						else if(character == '=' && characterNext != '=' && characterPrev != '=' && characterPrev != '!' && characterPrev != '>' && characterPrev != '<' && characterPrev != '+' && characterPrev != '-' && characterPrev != '*' && characterPrev != '/' && characterPrev != '|' && characterPrev != '&' && characterPrev != '%' && characterPrev != '^') {
							numberOfAssignmentOperators++;
							//System.out.print("= ,");
						}
						else if(character == '|' && characterNext == '=') {
							numberOfAssignmentOperators++;
							//System.out.print("|= ,");
						}
						else if(character == '&' && characterNext == '=') {
							numberOfAssignmentOperators++;
							//System.out.print("&= ,");
						}
						else if(character == '%' && characterNext == '=') {
							numberOfAssignmentOperators++;
							//System.out.print("%= ,");
						}
						else if(character == '^' && characterNext == '=') {
							numberOfAssignmentOperators++;
							//System.out.print("^= ,");
						}
						else if(character == '>' && characterNext == '>' && line.charAt(i+2) == '=' && characterPrev == '>') {
							numberOfAssignmentOperators++;
							//System.out.print(">>>= ,");
						}
						else if(character == '<' && characterNext == '=' && characterPrev == '<') {
							numberOfAssignmentOperators++;
							//System.out.print("<<= ,");
						}
						else if(character == '>' && characterNext == '=' && characterPrev == '>' && line.charAt(i-2) != '>') {
							numberOfAssignmentOperators++;
							//System.out.print(">>= ,");
						}
					}
				}	
				//System.out.println(s);
		        //System.out.println("\tNumber Of Assignment Operators :"+ numberOfAssignmentOperators);
		        //System.out.println("");
		        complexity[i] = numberOfAssignmentOperators* complexityValue;

		    	
		        //totalNumberOfAssignmentOperators = totalNumberOfAssignmentOperators + numberOfAssignmentOperators;
		    	numberOfAssignmentOperators = 0;
		    	i++;
		    }
	        //System.out.println("Total Number Of Assignment Operators :" +totalNumberOfAssignmentOperators);

	        return complexity;		
	}

}
