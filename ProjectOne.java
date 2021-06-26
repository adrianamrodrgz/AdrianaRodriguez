package ProjectOne;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ProjectOne {
		   
	public static void main(String args[]) throws IOException{
		   
		System.out.println("Project One");
		System.out.println("Code by Adriana Rodriguez, adriana.m.rodrgz@gmail.com");
		System.out.println("Application lists content of a Directory and Adds, Deletes, or Searches for a file");
		System.out.println();
		
		
		Scanner scan = new Scanner(System.in); 
		
		   String d = "Back";
		   String f = "Yes";
		   String addDeleteSearch,addFileName,searchFileName, deleteFileName;
		
		do{
	       System.out.println("Enter Directory to get File Names, Add a File, Delete File or Search File -- Ex: *C://Users//rodri//Desktop//WEBDEV//* ");
	       String DirectoryPath = scan.next();
	       File directoryPath = new File(DirectoryPath);
		    	if (directoryPath.isDirectory()==true){
		    		String contents[] = directoryPath.list();
		    		System.out.println("List of files and directories in the specified directory:");
		    		for(int i=0; i<contents.length; i++) {
		    			System.out.println(contents[i]);
		    		}
		    		do{
			    		System.out.println();
		    			System.out.println("Enter: Add (create new file), Delete (delete existing file), Search (look for a file), Back (look at new directory)");
				    	addDeleteSearch = scan.next();
		    			switch(addDeleteSearch){
			    		// Add File
		    			case "Add": 
			    	 		System.out.println("Name of File to Create and .(type of file)");
			    			addFileName = scan.next();
			    			File file = new File(directoryPath+"/"+addFileName);  // this is used to create the file
			  		    		 if (file.createNewFile()) {  
			  			                System.out.println("New File "+addFileName+" created!");  
			  			            } 
			  		    		 else {                   
			  			                if(file.exists()){
			  			                    System.out.println("File already exists.");	
			  			                    System.out.println("File path:" + file.getAbsolutePath());
			  			                    System.out.println("File name:  " + file.getName());
			  			                    }
			  			                 }
			  		    		 break;
			  		   // Delete File
			    		case "Delete": 
			    			 System.out.println("Name of File to Delete and .(type of file)");
			    			 deleteFileName = scan.next();
			    			 File deletefile = new File(directoryPath+"/"+deleteFileName);
			    			 if(deletefile.exists()){
			    				 deletefile.delete();
			    				 System.out.println("File deleted");}
			    			 else {
			    				 System.out.println("File not found");
			    			 }
			    			 break;
			    	//// SEARCH FILE		    	
			    	case "Search": 
			    			 System.out.println("Name of File and .(type of file)");
			    			 searchFileName = scan.next();
			    			 File searchfile = new File(directoryPath+"/"+searchFileName);
			    			 if(searchfile.exists()){
			    				 System.out.println("File name:  " + searchfile.getName());   
			    				 System.out.println("File path:" + searchfile.getAbsolutePath());
			    				 }
			 	                else
			 	                {
			 	                	System.out.println("File does not exists");
			 	                }
			    			break;
		    			}
		    			System.out.println();
		    			System.out.println("Continue on this Directory (Yes/Back)");
		    	}
			    	while(!scan.next().equals(d));
	   		 
}
		    	else{
		    		System.out.println("Directory not found");
		    }
		    	System.out.println();
		    	System.out.println("Yes to enter new directory No to Exit)");	
	   }
		while(scan.next().equals(f));
		
			}}
	
		    			 	 
