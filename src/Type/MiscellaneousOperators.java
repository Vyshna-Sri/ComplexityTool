package Type;

public class MiscellaneousOperators {
	private int complexityValue = 1;
	private int noOfDoublequotes = 0;
	private int noOfSinglequote = 0;
	private int numberOfMiscellaneousOperators = 0;
	//private int totalNumberOfMiscellaneousOperators = 0;
	private int i = 0;	
	
	public int[] complexity(String[] code) {
		int complexity[] = new int[code.length];

	    for (String s : code) {
	    	String line = s;
	    	int length = s.length();    	 	
	    	
			for(int i = 1; i < length-2; i++) {
				char character = line.charAt(i);
				char characterNext = 0;

				if(character == '/' && characterNext =='/') {
					break;
				}
				if(i != line.length()) {
					characterNext = line.charAt(i+1);
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
					if(character == ',') {
						numberOfMiscellaneousOperators++;
						System.out.print(", ,");
					}
					else if(character == '-' && (characterNext == '>')) {
						numberOfMiscellaneousOperators++;
						System.out.print("-> ,");
					}
					else if(character == '.') {
						numberOfMiscellaneousOperators++;
						System.out.print(". ,");
					}				
					else if(character == ':' && characterNext == ':') {
						numberOfMiscellaneousOperators++;
						System.out.print(":: ,");
					}
				}
			}
			//System.out.println(s);
	        //System.out.println("\tNumber Of Miscellaneous Operators :"+ numberOfMiscellaneousOperators);
	        //System.out.println("");
	        complexity[i] = numberOfMiscellaneousOperators* complexityValue;

	    	
	        //totalNumberOfMiscellaneousOperators = totalNumberOfMiscellaneousOperators + numberOfMiscellaneousOperators;
	        numberOfMiscellaneousOperators = 0;
	        i++;
		}		
        //System.out.println("Total Number Of Miscellaneous Operators :" +totalNumberOfMiscellaneousOperators);

		return complexity;		
	}

}
