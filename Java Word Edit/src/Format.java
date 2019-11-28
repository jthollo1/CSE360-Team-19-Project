
public class Format 
{
	int MaxLength = 80;
	String output = "";
	
	public Format()
	{
		// Constructor
	}
	
	public String limit(String input)
	{
		// This method will limit the lines to 80 chars
		int j = 0;
		
		for(int i = 0; i < input.length(); i++)
		{
			output += input.charAt(i);
			j++;
			
			if(j == MaxLength && input.charAt(i) != '\n')
			{
				output += "\n";
				j = 0;
			}
		}
		
		return output;
	}
	
	public String rightJ(String input)
	{
		// This method will make all text below marker right justified
		
		return output;
	}
	
	public String leftJ(String input)
	{
		// This method will make all text below marker left justified
		
		return output;
	}
	
	public String centerJ(String input)
	{
		// This method will make all text below marker center justified
		
		return output;
	}
	
	public String title(String input)
	{
		// This method will make line below marker center justified
		
		return output;
	}
	
	public String indent(String input)
	{
		// This method will add an indent to line below marker
		
		return output;
	}
	
	public String removeIndent(String input)
	{
		// This method will remove an indent to line below marker
		
		return output;
	}
	
	public String singleSpace(String input)
	{
		// This method will remove spaces between lines
		
		return output;
	}
	
	public String doubleSpace(String input)
	{
		// This method will add a space between lines
		
		return output;
	}
	
	public String block(String input)
	{
		// This method will indent multiple lines (10 space indent)
		
		return output;
	}
	
	public String divide(String input)
	{
		// This method will split the string into 2 columns, 35 - 10 - 35
		
		return output;
	}
	
	public String conjoin(String input)
	{
		// This method will combine the string into a single 80 character column
		
		return output;
	}
	
	public String blank(String input)
	{
		// This method will add a blank line below the marker
		
		return output;
	}
}
