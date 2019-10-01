package Type;

public class KeyWordsType2 {
	private int complexityValue = 1;
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
			    	  
					if(characterPrev == 'v' && character == 'o' && characterNext == 'i' && line.charAt(i+2) == 'd' && line.charAt(i+3) == ' ') {
						numberOfKeyWords++;
					}
					else if(characterPrev == 'd' && character == 'o' && characterNext == 'u' && line.charAt(i+2) == 'b' && line.charAt(i+3) == 'l' && line.charAt(i+4) == 'e' && line.charAt(i+5) == ' ') {
						numberOfKeyWords++;
					}
					else if(characterPrev == 'i' && character == 'n' && characterNext == 't' && line.charAt(i+2) == ' '){
						numberOfKeyWords++;
					}				
					else if(characterPrev == 'f' && character == 'l' && characterNext == 'a' && line.charAt(i+2) == 't' && line.charAt(i+3) == ' ' ) {
						numberOfKeyWords++;
					}				
					else if(characterPrev == 'S' && character == 't' && characterNext == 'r' && line.charAt(i+2) == 'i' && line.charAt(i+3) == 'n' && line.charAt(i+4) == 'g') {
						numberOfKeyWords++;
					}				
					else if(characterPrev == 'p' && character == 'r' && characterNext == 'i' && line.charAt(i+2) == 'n' && line.charAt(i+3) == 't' && line.charAt(i+4) == 'f') {
						numberOfKeyWords++;
					}				
					else if(characterPrev == 'p' && character == 'r' && characterNext == 'i' && line.charAt(i+2) == 'n' && line.charAt(i+3) == 't' && line.charAt(i+4) == 'l' && line.charAt(i+5) == 'n') {
						numberOfKeyWords++;
					}				
					else if(characterPrev == 'c' && character == 'o' && characterNext == 'u' && line.charAt(i+2) == 't') {
						numberOfKeyWords++;
					}				
					else if(characterPrev == 'c' && character == 'i' && characterNext == 'n') {
						numberOfKeyWords++;
					}				
					else if(characterPrev == 'i' && character == 'f') {
						numberOfKeyWords++;
					}				
					else if(characterPrev == 'f' && character == 'o' && characterNext == 'r') {
						numberOfKeyWords++;
					}				
					else if(characterPrev == 'w' && character == 'h' && characterNext == 'i' && line.charAt(i+2) == 'l' && line.charAt(i+3) == 'e') {
						numberOfKeyWords++;
					}				
					else if(characterPrev == 's' && character == 'w' && characterNext == 'i' && line.charAt(i+2) == 't' && line.charAt(i+3) == 'c' && line.charAt(i+4) == 'h') {
						numberOfKeyWords++;
					}				
					else if(characterPrev == 'c' && character == 'a' && characterNext == 's' && line.charAt(i+2) == 'e') {
						numberOfKeyWords++;
					}					
					else if(characterPrev == 'o' && character == 'u' && characterNext == 't') {
						numberOfKeyWords++;
					}				
					else if(characterPrev == 'S' && character == 'y' && characterNext == 's' && line.charAt(i+2) == 't' && line.charAt(i+3) == 'e'&& line.charAt(i+4) == 'm') {
						numberOfKeyWords++;
					}					
					else if(characterPrev == 'l' && character == 'o' && characterNext == 'n' && line.charAt(i+2) == 'g'&& line.charAt(i+3) == ' ') {
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
