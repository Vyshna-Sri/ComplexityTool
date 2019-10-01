package Type;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Methods {
	private int complexityValue = 1;
	private int noOfDoublequotes = 0;
	private int noOfSinglequote = 0;
	private int numberOfMethods = 0;
	//private int totalNumberOfMethods = 0;
	private int i = 0;
	
	public int[] complexity(String[] code) {	
		int complexity[] = new int[code.length];	

	    for (String s : code) {
	    	String line = s;
	    	int length = s.length();    	 	
	    	/*
	    	for(int i = 0; i < length-1; i++) {
				char character = line.charAt(i);
				char characterNext = 0;
				char characterPrev = 0;
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
					if( i == 0) {
						if(characterPrev == 'i' && character == 'n' && characterNext == 't' && line.charAt(i+2) == ' ') {
							numberOfMethods++;
						}
						else if(characterPrev == 'v' && character == 'o' && characterNext == 'i' && line.charAt(i+2) == 'd' && line.charAt(i+2) == ' ') {
							numberOfMethods++;
						}
						else if((characterPrev == 'S' || characterPrev == 's') && character == 't' && characterNext == 'r' && line.charAt(i+2) == 'i' && line.charAt(i+2) == 'n' && line.charAt(i+2) == 'g' && line.charAt(i+2) == ' ') {
							numberOfMethods++;
						}
						else if(characterPrev == 'd' && character == 'o' && characterNext == 'u' && line.charAt(i+2) == 'b' && line.charAt(i+2) == 'l' && line.charAt(i+2) == 'e' && line.charAt(i+2) == ' ') {
							numberOfMethods++;
						}
						else if(characterPrev == 'f' && character == 'l' && characterNext == 'o' && line.charAt(i+2) == 'a' && line.charAt(i+2) == 't' && line.charAt(i+2) == ' ') {
							numberOfMethods++;
						}						
					}
					else {
						if(characterPrevPrev == 'i' && characterPrev == 'i' && character == 'n' && characterNext == 't' && line.charAt(i+2) == ' ') {
							numberOfMethods++;
						}
						else if(characterPrevPrev == 'i' && characterPrev == 'v' && character == 'o' && characterNext == 'i' && line.charAt(i+2) == 'd' && line.charAt(i+2) == ' ') {
							numberOfMethods++;
						}
						else if(characterPrevPrev == 'i' && (characterPrev == 'S' || characterPrev == 's') && character == 't' && characterNext == 'r' && line.charAt(i+2) == 'i' && line.charAt(i+2) == 'n' && line.charAt(i+2) == 'g' && line.charAt(i+2) == ' ') {
							numberOfMethods++;
						}
						else if(characterPrevPrev == 'i' && characterPrev == 'd' && character == 'o' && characterNext == 'u' && line.charAt(i+2) == 'b' && line.charAt(i+2) == 'l' && line.charAt(i+2) == 'e' && line.charAt(i+2) == ' ') {
							numberOfMethods++;
						}
						else if(characterPrevPrev == 'i' && characterPrev == 'f' && character == 'l' && characterNext == 'o' && line.charAt(i+2) == 'a' && line.charAt(i+2) == 't' && line.charAt(i+2) == ' ') {
							numberOfMethods++;
						}
					}
				}
			}
	    	String methods[] = null;
	    	int noMethods = 0;
	    	String[] words = null;
	    	Pattern p = Pattern.compile("long* *[A-Za-z]+[\\(]");
	        Matcher m = p.matcher(line);
	        while(m.find()) {
	            if(m.group() != null ) {
	    	        System.out.println("ffff"+m.group());
	    	        words = s.split(" "); 
	            	numberOfMethods++;
	            }
	        }
	        for(int i = 0; i < words.length;i++) {
	        	if(!words[i].equals("long")) {
	        		String word=words[i];  
	        		methods[noMethods] = word;
	        		noMethods++;
	        	}
	        }
	        Pattern p2 = Pattern.compile("void* *[A-Za-z]+[\\(]");
	        Matcher m2 = p2.matcher(line);
	        while(m2.find()) {
	            if(m2.group() != null ) {
	            	numberOfMethods++;
	            }
	        }
	        
	        
	    	*/
	        Pattern p = Pattern.compile("[A-Za-z]+[\\(]");
	        Matcher m = p.matcher(line);
	        while(m.find()) {
	            if(m.group() != null ) {
	            	numberOfMethods++;
	            }
	        }
	        
	        Pattern p2 = Pattern.compile("if+[\\(]");
	        Matcher m2 = p2.matcher(line);
	        while(m2.find()) {
	            if(m2.group() != null ) {
	            	numberOfMethods--;
	            }
	        }
	        Pattern p3 = Pattern.compile("for+[\\(]");
	        Matcher m3 = p3.matcher(line);
	        while(m3.find()) {
	            if(m3.group() != null ) {
	            	numberOfMethods--;
	            }
	        }
	        Pattern p4 = Pattern.compile("println+[\\(]");
	        Matcher m4 = p4.matcher(line);
	        while(m4.find()) {
	            if(m4.group() != null ) {
	            	numberOfMethods--;
	            }
	        }
	        Pattern p5 = Pattern.compile("catch[A-Za-z]+[\\(]");
	        Matcher m5 = p5.matcher(line);
	        while(m5.find()) {
	            if(m5.group() != null ) {
	            	numberOfMethods--;
	            }
	        }
	        Pattern p6 = Pattern.compile("print+[\\(]");
	        Matcher m6 = p6.matcher(line);
	        while(m6.find()) {
	            if(m6.group() != null ) {
	            	numberOfMethods--;
	            }
	        }
	        //System.out.println(s);
	        //System.out.println("\tNumber Of Manipulators :"+ numberOfMethods);
	        //System.out.println("");
	        complexity[i] = numberOfMethods* complexityValue;

	    	
	        //totalNumberOfMethods = totalNumberOfMethods + numberOfMethods;
	        numberOfMethods = 0;
	        i++;
	    }
        //System.out.println("Total Number Of Manipulators :" +totalNumberOfMethods);

		return complexity;		
	}

}
