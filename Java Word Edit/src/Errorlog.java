import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import javax.swing.JOptionPane;

public class Errorlog 
{	
	private static String errorLogTxt = "";
	
	// Takes ErrorLog format for each button to display it working or not or some form of error and adds each string to errorLogTxt
	public static void Txt(String addErrorlogTxt)
	{
			errorLogTxt += addErrorlogTxt;
			System.out.print(errorLogTxt);
	}
	public static void outputTxt() {
		
		PrintStream out;
		try {
			out = new PrintStream( new File( "ErrorLog.txt" ));
			out.println(errorLogTxt);
		} catch (FileNotFoundException e) {
		}
		
	}
	
	public static void openErrorLogMessage(String randomString)
	{
		
		String bypassForMessageDialog = randomString; // STRING IS NEVER CALLED/USED
		JOptionPane.showMessageDialog(null, errorLogTxt, "!!!   ERROR LOG   !!!", JOptionPane.INFORMATION_MESSAGE);
	}
}