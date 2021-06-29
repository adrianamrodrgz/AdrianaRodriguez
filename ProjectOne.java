package ProjectOne;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class ProjectOne {
	public static void displayWelcome(){
		System.out.println("Project One");
		System.out.println("by Adriana Rodriguez, adriana.m.rodrgz@gmail.com");
	}
	public static void displayMainMenu(){
		System.out.println("Main Menu ");
		System.out.println("1 : Enter Directory to list files in Directory");
		System.out.println("    Add a File");
		System.out.println("    Delete a File");
		System.out.println("    Search a File");
		System.out.println();
		System.out.println("2 : Exit Program");
	}
	public static void displaySubMenu(){
		System.out.println("Select from Menu");
		System.out.println("3 : Add a File");
		System.out.println("4 : Delete a File");
		System.out.println("5 : Search a File");
		System.out.println("6 : Back to Main Menu");
	}
	public void addFile (String addFileName, String dirInput) throws FileAlreadyExistsException, IOException  {
		File file = new File(dirInput+"/"+addFileName);
		try{ 
			if(file.exists()){
				throw new FileAlreadyExistsException("File already exists");
			}
			else{
				file.createNewFile();
				System.out.println("file was created");
			}
		}
		catch (Exception ex){
			ex.printStackTrace();
		}
	}
	public class FileAlreadyExistsException extends Exception {
		FileAlreadyExistsException (String s){
			super(s);
		}
	}
	public void deleteFile (String deleteFileName, String dirInput) throws Exception{
		File deletefile = new File(dirInput+"/"+deleteFileName);
		if(deletefile.exists()){
			deletefile.delete();
			System.out.println("File deleted");}
		else {
			System.out.println("File not found");
		}
	}
	public void searchFile (String searchFileName, String dirInput) throws Exception{
		File searchfile = new File(dirInput+"/"+searchFileName);
		if(searchfile.exists()){
			System.out.println("File name Found");   
			System.out.println("File path:" + searchfile.getAbsolutePath());
		}
		else{
			System.out.println("File does not exists");
		}
	}
	public static void main(String args[]) throws Exception {
		displayWelcome();
		System.out.println();
		String mainMenu, dirInput, subMenu, addFileName, searchFileName, deleteFileName;
		String f = "Yes";
		ProjectOne obj = new ProjectOne();
		Scanner scan = new Scanner(System.in);
		do{
			System.out.println("Select from Main Menu");
			displayMainMenu();
			mainMenu = scan.next();
			System.out.println();
			switch(mainMenu){
			case "1":
				try{
					System.out.println("Enter Directory Path");
					dirInput = scan.next();
					System.out.println();
					File directoryPath = new File(dirInput);
					if(directoryPath.isDirectory()){
						String[] directoryList;
						directoryList = directoryPath.list();
						System.out.println("List of files in directory:");
						for (String list:directoryList){
							Arrays.sort(directoryList,String.CASE_INSENSITIVE_ORDER);
							System.out.println(list);
						}
						do{
							System.out.println();
							displaySubMenu();
							subMenu = scan.next();
							switch(subMenu){
							case "3":
								System.out.println();
								System.out.println("Name of File to Create");
								addFileName = scan.next();
								obj.addFile(addFileName, dirInput);
								break;	
							case "4":
								System.out.println();
								System.out.println("Name of File to Delete");
								deleteFileName = scan.next();
								obj.deleteFile(deleteFileName, dirInput);
								break;	
							case "5":
								System.out.println();
								System.out.println("Name of File to Search");
								searchFileName = scan.next();
								obj.searchFile(searchFileName, dirInput);
								break;
							}
							System.out.println();
							System.out.println("1 : Continue in current directory");
							System.out.println("2 : Exit directory");
						}
						while (scan.next().equals("1"));
					}
					else { 
						throw new Exception ();
					}
				}
				catch (Exception ex){
					System.out.println("Directory not Found: No Files to display");
				}			
				System.out.println();
				break;
			case "2":
				System.exit(0);
			}
			System.out.println("Yes: to Main Menu");
			System.out.println("No to Exit Program");
		}
		while (scan.next().equals(f));
	}
}




