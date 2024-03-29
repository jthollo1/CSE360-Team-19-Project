import java.util.*;

public class Process 
{
	private String output = "";
	private String temp = "";
	private ArrayList <String> arr;
	
	public Process()
	{
		// constructor
	}
	
	public String p(String input)
	{
		// This method will process the input string and format it according to the flags
		Format F = new Format();
		String s = input.replaceAll("\n", " ");
		String word[] = s.split(" ");
		String Flag[] = {"-r","-c","-L","-t","-s","-d","-i","-b","-2","-1","-e","-n"};
		int lineSpace = 1;
		int columns = 1;
		boolean indent = false;
		boolean block = false;
		boolean noFlags = true;
		String output = "";
		String temp = "";
		String other = "";
		String Justify = "left";
		
		
		for(int i = 0; i < word.length; i++)
		{
			for(int j = 0; j < Flag.length; j++)
			{
				if(word[i].equals(Flag[j]))
				{
					noFlags = false;
					
					word[i] = "";
					temp = "";
					
					for(int h = i; h < word.length; h++)
					{
						if(h != word.length - 1 && word[h+1].length() != 0)
						{
							temp += word[h+1] + " ";
						}
						else if(h != word.length - 1)
						{
							temp += word[h+1];
						}
					}
					
					if(Flag[j].equals("-r"))
					{
						Justify = "right";
					}
					else if(Flag[j].equals("-c"))
					{
						Justify = "center";
					}
					else if(Flag[j].equals("-L"))
					{
						Justify = "left";
					}
					else if(Flag[j].equals("-t"))
					{
						Justify = "title";
					}
					else if(Flag[j].equals("-s"))
					{
						lineSpace = 1;
					}
					else if(Flag[j].equals("-d"))
					{
						lineSpace = 2;
					}
					else if(Flag[j].equals("-i"))
					{
						indent = true;
					}
					else if(Flag[j].equals("-b"))
					{
						block = true;
					}
					else if(Flag[j].equals("-2"))
					{
						columns = 2;
					}
					else if(Flag[j].equals("-1"))
					{
						columns = 1;
					}
					else if(Flag[j].equals("-e"))
					{
						other = "blank";
					}
					else if(Flag[j].equals("-n"))
					{
						other = "removeIndent";
					}
					
					if(Justify == "left" && other == "")
					{
					}
					else if(Justify == "right" && other == "")
					{
						output = F.rightJ(temp, lineSpace, columns);
					}
					else if(Justify == "center" && other == "")
					{
						output = F.centerJ(temp, lineSpace, columns);
					}
					else if(Justify == "title" && other == "")
					{
						output = F.title(temp, lineSpace, columns);
					}
					else if(other == "blank")
					{
						output = F.blank(temp);
					}
					else if(other == "removeIndent")
					{
						output = F.removeIndent(temp);
					}
				}
			}
		}
		if(noFlags == true)
		{
			output = F.leftJ(s, 1, 1, false, false);
		}
		
		return output;
	}
}
