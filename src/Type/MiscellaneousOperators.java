package Type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MiscellaneousOperators {
	private int complexityValue = 1;
	private int noOfDoublequotes = 0;
	private int noOfSinglequote = 0;
	private int numberOfMiscellaneousOperators = 0;
	private boolean ignore = true;
	//private int totalNumberOfMiscellaneousOperators = 0;
	private int i = 0;	
	
	public int[] complexity(String[] code) {
		int complexity[] = new int[code.length];

	    for (String s : code) {
	    	String line = s;
	    	int length = s.length();    
	    	
	    	Pattern p = Pattern.compile("import+[* *]+[A-Za-z]+");
	        Matcher m = p.matcher(line);
	        while(m.find()) {
	            if(m.group() != null ) {
	            	//System.out.println("Ignore the import lines"+m.group());
	            	length = -1;
	            }
	        }
			for(int i = 1; i < length-2; i++) {
				char character = line.charAt(i);
				char characterNext = 0;
				if(i != line.length()) {
					characterNext = line.charAt(i+1);
		        }				
				if(character == '/' && characterNext =='/') {
					if (i == 0) {
						ignore = false;
					}
					break;
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
						//System.out.print(", ,");
					}
					else if(character == '-' && (characterNext == '>')) {
						numberOfMiscellaneousOperators++;
						//System.out.print("-> ,");
					}
					else if(character == '.') {
						numberOfMiscellaneousOperators++;
						//System.out.print(". ,");
					}				
					else if(character == ':' && characterNext == ':') {
						numberOfMiscellaneousOperators++;
						//System.out.print(":: ,");
					}
				}
			}
			if (ignore == true) {
	        Pattern pa = Pattern.compile("(\\d+(?:\\.\\d+)?)");
	        Matcher ma = pa.matcher(line);
	        while(ma.find()) {
	            if(ma.group() != null) {
	            	boolean isFound = ma.group().indexOf(".") != -1 ? true : false;
				if (isFound == true) {
	            	numberOfMiscellaneousOperators--;
				}
	            }
	        }
			}
			//System.out.println(s);
	        //System.out.println("\tNumber Of Miscellaneous Operators :"+ numberOfMiscellaneousOperators);
	        //System.out.println("");
	        complexity[i] = numberOfMiscellaneousOperators* complexityValue;

	    	
	        //totalNumberOfMiscellaneousOperators = totalNumberOfMiscellaneousOperators + numberOfMiscellaneousOperators;
	        numberOfMiscellaneousOperators = 0;
	        ignore =true;
	        i++;
		}		
        //System.out.println("Total Number Of Miscellaneous Operators :" +totalNumberOfMiscellaneousOperators);

		return complexity;		
	}

}
