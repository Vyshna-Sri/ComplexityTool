package spm;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class InherentComplexity {

	public double complex() {
		BufferedReader reader;
		ArrayList<String> data = new ArrayList<String>(100);
		HashMap<String, List<String>> wordFreqMap  = new HashMap<>(); 
	    String str;
	    int total = 2;
		try {
			
				reader = new BufferedReader(new FileReader("C:/Users/Sanjula/Desktop/Inheritance/vhh.txt"));
				String line = reader.readLine();
				String code = "empty";
			
			
			while (line != null) {
				
				//System.out.println(line);
				String input = line; 
			    
				  //Check comments lines
		    	  boolean isPresentSingleComment = line.indexOf("//") != -1 ? true : false;
		    	  boolean isPresentMultipleCommentStart = line.indexOf("/*") != -1 ? true : false;
		    	  boolean isPresentMultipleCommentMidle = line.indexOf("*") != -1 ? true : false;
		    	  boolean isPresentMultipleCommentEnd = line.indexOf("*/") != -1 ? true : false;

		    	  //Ignore the comments
		    	  if(isPresentSingleComment || isPresentMultipleCommentStart || isPresentMultipleCommentEnd || isPresentMultipleCommentMidle) {
		    		  
		    	  }
		    	  else {
		    		  boolean isPresent = input.indexOf("extends") != -1 ? true : false; 
						

						System.out.println("isPresent: " + isPresent);
						
						if (isPresent) {
							
					        String[] sp = input.split(" ");
					        /*
					        System.out.println("second word is " + sp[1]);
					        System.out.println("third word is " + sp[2]);
					        System.out.println("Fourth words is " +sp[3]);
					        System.out.println("Fifth words is " +sp[4]);
					         */
							/*
							if (isPresent) {

						      
						        String[] sp = input.split(" ");
						        System.out.println("second word is " + sp[1]);
						        System.out.println("third word is " + sp[2]);
						        System.out.println("Fourth words is " +sp[3]);
						        
						        
						        if(sp[1] == "class") {
						        	System.out.println("second word is " + sp[1]);
						        }
						        else {
									System.out.println("third word is " + sp[2]);
						        }
						        
								data.add(input);
								for(int i = 0; i < data.size(); i++) {   
								    System.out.println(data.get(i));
								} 
								} 
							
							
							System.out.println("Doing search with different case"); 
							isPresent = input.indexOf("extends") != -1 ? true : false;
							System.out.println("isPresent: " + isPresent);
							*/
					        
					        	if(sp[1].equals("class")) {
					        	
					        		// Add List as value in the map
					        		wordFreqMap.put(sp[4], Arrays.asList(sp[2]));
		
					        	}
					        	else{
					        	
					        		wordFreqMap.put(sp[3], Arrays.asList(sp[1]));
					
					        	}
					       
					        	str = wordFreqMap.toString();
					        
					        	data.add(str);

		    		  
						}
		    	  
					
						
					}
					
					// read next line
					line = reader.readLine();
					

	
				
			}
			
		for(int i = 0; i < data.size(); i++) {   
		
			int Ci = total;
			total = total + 1;
			
			System.out.println(data.get(i));
		
		} 
		
		System.out.println("Complexity due to its inheritance (CCi) ="+" "+total);
		reader.close();

	} catch (IOException e) {
	e.printStackTrace();
	}
		return total;
	}
}
