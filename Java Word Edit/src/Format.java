import java.util.*;

public class Format 
{
	private String output = "";
	private String temp = "";
	private ArrayList <String> arr = new ArrayList <String>();
	
	public Format()
	{
		// Constructor
	}
	
	public String leftJ(String input, int lineSpace, int columns)
	{
		// This method will make all text below marker left justified
		String s = input.replaceAll("\n", " ");
		String word[] = s.split(" ");
		String lSpace = LineSpace(lineSpace);
		String space = "          ";
		Boolean even;
		int cLength = Columns(columns);
		int lSize = 0;
		int nextwLength = 0;
		int Half = 0;
		int arrSize = 0;
		
		for(int i = 0; i < word.length; i++)
		{
			if(i != word.length - 1)
			{
				nextwLength = word[i+1].length();
			}
			
			lSize += word[i].length();
			
			if(lSize <= cLength && word[i].length() != 0)
			{
				if(lSize == cLength || i == word.length - 1 || ((lSize + nextwLength) > cLength))
				{
					temp += word[i];
				}
				else if((lSize + nextwLength) == cLength)
				{
					temp += word[i];
					lSize += 1;
				}
				else
				{
					temp += word[i] + " ";
					lSize += 1;
				}
				
				if(i + 1 == word.length)
				{
					arr.add(temp);
				}
			}
			else if ((lSize + nextwLength) > cLength)
			{
				if(lSize == cLength)
				{
					temp += word[i];
				}
				else
				{
					arr.add(temp);
					
					temp = "";
					lSize = 0;
					
					temp += lSpace + word[i] + " ";
					lSize = word[i].length() + 1;
				}
			}
		}
	
		if(columns == 1)
		{
			for(int i = 0; i < arr.size(); i++)
			{
				output += arr.get(i);
			}
		}
		else
		{
			if((arr.size() % 2) == 0)
			{
				Half = (arr.size() / 2);
				arrSize = (arr.size() / 2);
				even = true;
			}
			else
			{
				Half = ((arr.size() / 2) + 1);
				arrSize = (arr.size() / 2) + 1;
				even = false;
			}
			
			for(int i = 0; i < arrSize; i++)
			{
				if(even == true)
				{
					if(Half < arr.size() - 1)
					{
						output += arr.get(i).replaceAll("\n", "") + space + arr.get(Half).replaceAll("\n", "") + lSpace;
					}
					else
					{
						output += arr.get(i).replaceAll("\n", "") + space + arr.get(Half).replaceAll("\n", "");
					}
				}
				else if(even == false)
				{
					if(Half < arr.size())
					{
						output += arr.get(i).replaceAll("\n", "") + space + arr.get(Half).replaceAll("\n", "") + lSpace;
					}
					else
					{
						output += arr.get(i).replaceAll("\n", "");
					}
				}
				Half++;
			}
		}
		
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
	
	private String LineSpace(int lineSpace)
	{
		// This method will determine the number of new lines
		String s;
		
		if(lineSpace == 1)
		{
			s = "\n";
		}
		else
		{
			s = "\n\n";
		}
		
		return s;
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
