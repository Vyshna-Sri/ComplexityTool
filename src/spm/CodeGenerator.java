package spm;
import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CodeGenerator {
	public String convert_file_to_string(String file_location) throws IOException {
		//Creation of File Descriptor for input file  
		File f=new File(file_location);    
		//Creation of File Reader object
		FileReader fr=new FileReader(f);   
		
		//Create BufferedReader to store the file
	      BufferedReader br = new BufferedReader(fr); 
	      String line;
	      String code = "empty";
	      while ((line = br.readLine()) != null) {
	    	  //Check comments lines
	    	  boolean isPresentSingleComment = line.indexOf("//") != -1 ? true : false;
	    	  boolean isPresentMultipleCommentStart = line.indexOf("/*") != -1 ? true : false;
	    	  boolean isPresentMultipleCommentMidle = line.indexOf("*") != -1 ? true : false;
	    	  boolean isPresentMultipleCommentEnd = line.indexOf("*/") != -1 ? true : false;
	    	  
	    	  //Ignore the comments
	    	  if(isPresentSingleComment || isPresentMultipleCommentStart || isPresentMultipleCommentEnd || isPresentMultipleCommentMidle) {
	    		  
	    	  }
	    	  else {
		    	  if(code.equals("empty")) {
		    		  code = line;
		    	  }
		    	  else{
			    	  code = code +"\n"+ line;
		    	  }
	    		  
	    	  }
	      }
	      br.close();
	      System.out.println(code);
	      return code;
	   }
}
