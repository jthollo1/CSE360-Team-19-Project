import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Loadfile 
{
	String output = "";
			
	public Loadfile()
	{
		// Constructor
	}
	
	public String load()
	{
		// setup file chooser
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
		
		// setup Scanner input
		Scanner in = null;
		
		// Declare variables
		String line = "";
		
		if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			// setup File
			File selectedFile = chooser.getSelectedFile();
			String extension = getFileExtension(selectedFile);
			
			// System.out.println(extension); // Used to check detected file extension
			
			if(extension.equals("txt") == false)
			{
				// Wrong file type error
			}
			else
			{
				try 
				{
					in = new Scanner(selectedFile);
				} 
				catch (FileNotFoundException e) 
				{
					// File not found error
					e.printStackTrace();
				}
				
				while(in.hasNextLine())
				{
					line = in.nextLine();
					output += line;
				}
			}
		}
		
		return output; // returning string that contains entire file
	}
	
	
	// This method lets us filter file extension
    private static String getFileExtension(File file) 
    {
        String fileName = file.getName();
        
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        	return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
