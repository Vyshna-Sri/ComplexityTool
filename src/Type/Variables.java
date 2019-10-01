package Type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Variables {
	private int complexityValue = 1;
	private int numberOfVariables = 0;
	private int numberOfNumbersInsideText = 0;
	//private int totalNumberOfTexts = 0;
	private int i = 0;
	
	public int[] complexity(String[] code) {	
		int complexity[] = new int[code.length];	
	    for (String s : code) {
	    	String line = s;
	    	int length = s.length();   
			for(int i = 0; i < length-1; i++) {
				char character = line.charAt(i);
				char characterNext = 0;
				if(character == '/' && characterNext =='/') {
					break;
				}
			}
			
			Pattern p = Pattern.compile("long* *[A-Za-z]+[\\(]");
	        Matcher m = p.matcher(line);
	        System.out.println("ffff"+m);
	        while(m.find()) {
	            if(m.group() != null ) {
	            	numberOfVariables++;
	            }
	        }
	        Pattern p2 = Pattern.compile("void* *[A-Za-z]+[\\(]");
	        Matcher m2 = p2.matcher(line);
	        while(m2.find()) {
	            if(m2.group() != null ) {
	            	numberOfVariables++;
	            }
	        }
			
	        //System.out.println(s);
	        //System.out.println("\tNumber Of Texts :"+ numberOfVariables);
	        //System.out.println("");	  
		    complexity[i] = (numberOfVariables -numberOfNumbersInsideText) * complexityValue;
    
	        //totalNumberOfTexts = totalNumberOfTexts + numberOfVariables;
		    numberOfVariables = 0;
		    numberOfNumbersInsideText = 0;
	        i++;
	    }
        //System.out.println("Total Number Of Texts :" + totalNumberOfTexts);

		return complexity;		
	}
}

