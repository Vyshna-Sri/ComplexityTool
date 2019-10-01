package Type;

public class KeyWords {
	private int complexityValue = 2;
	private int noOfDoublequotes = 0;
	private int noOfSinglequote = 0;
	private int numberOfKeyWords = 0;
	//private int totalNumberOfKeyWords = 0;
	private int i = 0;
	
	public int[] complexity(String[] code) {
		int complexity[] = new int[code.length];

	    for (String s : code) {
	    	String line = s;
	    	int length = s.length();    
			for(int i = 0; i < length-1; i++) {
				char character = line.charAt(i);
				char characterNext = 0;
				char characterPrev =0;
				char characterPrevPrev =0;

				if(character == '/' && characterNext =='/') {
					break;
				}
				if(i != line.length()) {
					characterNext = line.charAt(i+1);
		        }
		        if(i != 0) {
					characterPrev = line.charAt(i-1);
		        }
		        if(i != 1 && i != 0) {
		        	characterPrevPrev = line.charAt(i-2);
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
			    	  
					if(characterPrev == 'n' && character == 'e' && characterNext == 'w' && line.charAt(i+2) == ' ') {
						numberOfKeyWords++;
					}
					else if(characterPrev == 'd' && character == 'e' && characterNext == 'l' && line.charAt(i+2) == 'e' && line.charAt(i+3) == 't' && line.charAt(i+4) == 'e' && line.charAt(i+5) == ' ') {
						numberOfKeyWords++;
					}
					else if(characterPrev == 't' && character == 'h' && characterNext == 'r' && line.charAt(i+2) == 'o' && line.charAt(i+3) == 'w' && line.charAt(i+4) == ' '){
						numberOfKeyWords++;
					}				
					else if(characterPrev == 't' && character == 'h' && characterNext == 'r' && line.charAt(i+2) == 'o' && line.charAt(i+3) == 'w' && line.charAt(i+4) == 's' && line.charAt(i+5) == ' ') {
						numberOfKeyWords++;
					}
					
				}
			}
			//System.out.println(s);
	        //System.out.println("\tNumber Of Key Words :"+ numberOfKeyWords);
	        //System.out.println("");
	        complexity[i] = numberOfKeyWords* complexityValue;

	    	
	        //totalNumberOfKeyWords = totalNumberOfKeyWords + numberOfKeyWords;
	        numberOfKeyWords = 0;
	        i++;
		}		
        //System.out.println("Total Number Of Key Words :" +totalNumberOfKeyWords);

		return complexity;		
	}
}
