import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

public class SaveAs
{
	String output = "";
			
	private JFrame frmCseTextEditor;
	
	public SaveAs()
	{
		// Constructor
	}
	
	public String save(String input)
	{
		// This method let's us select a file to load and turns it into a string
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("*.txt", "txt"));

		chooser.setDialogTitle("Save As...");   
		 
		int userSelection = chooser.showSaveDialog(frmCseTextEditor);

		if (userSelection == JFileChooser.APPROVE_OPTION)
		{
			try (FileWriter fw = new FileWriter(chooser.getSelectedFile()+".txt")) 
			{
			    fw.write(input);
			}
			catch (Exception ex) 
			{
	            ex.printStackTrace();
	        }
		}
		
		return "";
	}
}