import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Loadfile 
{
	public Loadfile()
	{
		//constructor
	}
	
	public void load()
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("*.txt", "txt"));
		Scanner in = null; 
		
		if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
		{
			File selectedFile = chooser.getSelectedFile();
			String extension = getFileExtension(selectedFile);
			System.out.println(extension);
			
			if(extension.equals("txt") == false)
			{
				// error for wrong file type
			}
			else
			{
				try 
				{
					in = new Scanner(selectedFile);
				} 
				catch (FileNotFoundException e) 
				{
					e.printStackTrace();
				}
				
				while(in.hasNextLine())
				{
					String line = in.nextLine();
					System.out.println(line);
				}
			}
		}
	}
	
    private static String getFileExtension(File file) 
    {
        String fileName = file.getName();
        
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        	return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}
