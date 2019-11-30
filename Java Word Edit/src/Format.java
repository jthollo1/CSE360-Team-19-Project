import java.util.*;

public class Format 
{
	String output = "";
	String temp = "";
	
	public Format()
	{
		// Constructor
	}
	
	public String leftJ(String input, int lineSpace, int columns)
	{
		// This method will make all text below marker left justified
		
		return output;
	}
	
	public String rightJ(String input, int lineSpace, int columns)
	{
		// This method will make all text below marker right justified
		
		
		return output;
	}
	
	public String centerJ(String input, int lineSpace, int columns)
	{
		// This method will make all text below marker center justified
		
		return output;
	}
	
	public String title(String input, int lineSpace)
	{
		// This method will make line below marker center justified
		
		return output;
	}
	
	private int Columns(int columns)
	{
		// This method will determine the number of columns
		int n;
		
		if(columns == 1)
		{
			n = 80;
		}
		else
		{
			n = 35;
		}
		
		return n;
	}
	
	/*public String indent(String input)
	{
		// This method will add an indent to line below marker
		
		return output;
	}
	
	public String removeIndent(String input)
	{
		// This method will remove an indent to line below marker
		
		return output;
	}
	
	public String block(String input)
	{
		// This method will indent multiple lines (10 space indent)
		
		return output;
	}
	
	public String blank(String input)
	{
		// This method will add a blank line below the marker
		
		return output;
	}*/
}
