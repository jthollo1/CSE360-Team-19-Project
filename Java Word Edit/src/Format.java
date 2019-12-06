import java.util.*;

public class Format 
{
	private String output = "";
	private String temp = "";
	private ArrayList <String> arr;
	
	public Format()
	{
		// Constructor
	}
	
	public String leftJ(String input, int lineSpace, int columns, boolean indent, boolean block)
	{
		// This method will make all text below marker left justified
		arr = new ArrayList <String>();
		output = "";
		temp = "";
		String s = input.replaceAll("\n", " ");
		String word[] = s.split(" ");
		String lSpace = LineSpace(lineSpace);
		String space = "          ";
		Boolean even;
		int cLength = Columns(columns);
		int lSize;
		boolean needspace = false;
		if(indent == true)
		{
			lSize = 5;
			temp += "     ";
		}
		else if(block == true)
		{
			lSize = 10;
			temp += "          ";
		}
		else
		{
			lSize = 0;
		}
		
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
					if(lSize == cLength)
					{
						needspace = true;
					}
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
					String ltemp = "";
					
					int sSize = cLength - (lSize -= word[i].length());
					
					for(int j = 0; j < sSize; j++)
					{
						ltemp += " ";
					}
					
					temp += ltemp;
					arr.add(temp);
					
					
					temp = "";
					/*if(needspace == true)
					{
						temp += " ";
						needspace = false;
					}*/
					
					lSize = 0;
					if(block == true)
					{
						temp += lSpace + "          " + word[i] + " ";
						lSize = 10;
						lSize += word[i].length() + 1;
					}
					else
					{
						
						temp += lSpace + word[i] + " ";
						lSize = word[i].length() + 1;
						
						if(i == word.length - 1)
						{
							arr.add(temp);
						}
						
					}
					
					
					
				}
			}
		}
		output = cformat(arr,lineSpace,columns);
		
		return output;
	}
	
	public String rightJ(String input, int lineSpace, int columns)
	{
		// This method will make all text below marker right justified
		arr = new ArrayList <String>();
		output = "";
		temp = "";
		boolean end = false;
		String rtemp = "";
		String s = input.replaceAll("\n", " ");
		String word[] = s.split(" ");
		String lSpace = LineSpace(lineSpace);
		int cLength = Columns(columns);
		int lSize = 0;
		int sSize = 0;
		int nextwLength = 0;
		
		for(int i = 0; i < word.length; i++)
		{
			if(i != word.length - 1)
			{
				nextwLength = word[i+1].length();
			}
			
			lSize += word[i].length();
			
			if(lSize < cLength && word[i].length() != 0 && end == false)
			{
				if(i == word.length - 1 || ((lSize + nextwLength + 1) >= cLength))
				{
					temp += word[i];
					end = true;
				}
				else				
				{
					temp += word[i] + " ";
					lSize += 1;
				}
				
				if(i + 1 == word.length)
				{
					sSize = cLength - lSize;
					
					for(int j = 0; j < sSize; j++)
					{
						rtemp += " ";
					}
					
					rtemp += temp;
					arr.add(rtemp);
				}
			}
			else if (lSize >= cLength || end == true)
			{
				sSize = cLength - (lSize -= word[i].length());
				
				for(int j = 0; j < sSize; j++)
				{
					rtemp += " ";
				}
				
				rtemp += temp;
				arr.add(rtemp);
				
				rtemp = "";
				temp = "";
				lSize = 0;
				end = false;
				
				rtemp += lSpace;
				temp += word[i] + " ";
				lSize = word[i].length() + 1;
			}
		}
	
		output = cformat(arr,lineSpace,columns);

		return output;
	}
	
	public String centerJ(String input, int lineSpace, int columns)
	{
		// This method will make all text below marker right justified
		arr = new ArrayList <String>();
		output = "";
		temp = "";
		boolean end = false;
		String rtemp1 = "";
		String rtemp2 = "";
		String s = input.replaceAll("\n", " ");
		String word[] = s.split(" ");
		String lSpace = LineSpace(lineSpace);
		int cLength = Columns(columns);
		int lSize = 0;
		int sSize = 0;
		int nextwLength = 0;
		
		for(int i = 0; i < word.length; i++)
		{
			if(i != word.length - 1)
			{
				nextwLength = word[i+1].length();
			}
			
			lSize += word[i].length();
			
			if(lSize < cLength && word[i].length() != 0 && end == false)
			{
				if(i == word.length - 1 || ((lSize + nextwLength + 1) >= cLength))
				{
					temp += word[i];
					end = true;
				}
				else				
				{
					temp += word[i] + " ";
					lSize += 1;
				}
				
				if(i + 1 == word.length)
				{
					sSize = cLength - lSize;
					
					for(int j = 0; j < sSize/2; j++)
					{
						rtemp1 += " ";
					}
					
					rtemp1 += temp;
					
					for(int j = sSize/2; j < sSize; j++)
					{
						rtemp2 += " ";
					}
					
					rtemp1 += rtemp2;
					arr.add(rtemp1);
				}
			}
			else if (lSize >= cLength || end == true)
			{
				sSize = cLength - (lSize -= word[i].length());
				
				for(int j = 0; j < sSize/2; j++)
				{
					rtemp1 += " ";
				}
				
				rtemp1 += temp;
				
				for(int j = sSize/2; j < sSize; j++)
				{
					rtemp2 += " ";
				}
				
				rtemp1 += rtemp2;
				arr.add(rtemp1);
				
				rtemp1 = "";
				rtemp2 = "";
				temp = "";
				lSize = 0;
				end = false;
				
				rtemp1 += lSpace;
				temp += word[i] + " ";
				lSize = word[i].length() + 1;
			}
		}
	
		output = cformat(arr,lineSpace,columns);

		return output;
	}
	
	public String title(String input, int lineSpace, int columns)
	{
		// This method will make line below marker title centered
		
				arr = new ArrayList <String>();
				output = "";
				temp = "";
				boolean end = false;
				boolean firstline = false;
				String rtemp1 = "";
				String rtemp2 = "";
				String s = input.replaceAll("\n", " ");
				String word[] = s.split(" ");
				String lSpace = LineSpace(lineSpace);
				int cLength = Columns(columns);
				int lSize = 0;
				int sSize = 0;
				int nextwLength = 0;
				int i;
				
				for(i = 0; i < word.length && firstline==false; i++)
				{
					
					
					if(i != word.length - 1)
					{
						nextwLength = word[i+1].length();
					}
					
					lSize += word[i].length();
					
					if(lSize < cLength && word[i].length() != 0 && end == false)
					{
						if(i == word.length - 1 || ((lSize + nextwLength + 1) >= cLength))
						{
							temp += word[i];
							end = true;
							
						}
						else				
						{
							temp += word[i] + " ";
							lSize += 1;
						}
						
						if(end == true)
						{
							firstline = true;
							sSize = cLength - lSize;
							
							for(int j = 0; j < sSize/2; j++)
							{
								rtemp1 += " ";
							}
							
							rtemp1 += temp;
							
							for(int j = sSize/2; j < sSize; j++)
							{
								rtemp2 += " ";
							}
							
							rtemp1 += rtemp2;
							arr.add(rtemp1);
						}
					}
					else if (lSize >= cLength || end == true)
					{
						
						sSize = cLength - (lSize -= word[i].length());
						
						for(int j = 0; j < sSize/2; j++)
						{
							rtemp1 += " ";
						}
						
						rtemp1 += temp;
						
						for(int j = sSize/2; j < sSize; j++)
						{
							rtemp2 += " ";
						}
						
						rtemp1 += rtemp2;
						arr.add(rtemp1);
						
						
						rtemp1 = "";
						rtemp2 = "";
						temp = "";
						lSize = 0;
						end = false;
						
						rtemp1 += lSpace;
						temp += word[i] + " ";
						lSize = word[i].length() + 1;
						
					}
				}
				
				//gives the centered top line
				
				//cLength = 0;
				//ArrayList<String> arr1 = new ArrayList<String>();
				lSize = 0;
				
				temp = "";
				temp += lSpace;

				for(int j = i; j < word.length; j++)
				{
					if(j != word.length - 1)
					{
						nextwLength = word[j+1].length();
					}
					
					lSize += word[j].length();
					
					if(lSize <= cLength && word[j].length() != 0)
					{
						if(lSize == cLength || j == word.length - 1 || ((lSize + nextwLength) > cLength))
						{
							temp += word[j];
						}
						else if((lSize + nextwLength) == cLength)
						{
							temp += word[j];
							lSize += 1;
						}
						else
						{
							temp += word[j] + " ";
							lSize += 1;
						}
						
						if(j + 1 == word.length)
						{
							arr.add(temp);
						}
					}
					else if ((lSize + nextwLength) > cLength)
					{
						if(lSize == cLength)
						{
							temp += word[j];
						}
						else
						{
							arr.add(temp);
							
							temp = "";
							lSize = 0;
							
							temp += lSpace + word[j] + " ";
							lSize = word[j].length() + 1;
						}
					}
						
					
				}
					
				output = cformat(arr,lineSpace, columns);
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
	
	public String oneColumn(String input)
	{
		return leftJ(input, 1, 1, false, false);
	}
	
	public String twoColumn(String input)
	{
		return leftJ(input, 1, 2, false, false);
	}
	
	private String cformat(ArrayList <String> a, int lineSpace, int columns)
	{
		// This method will format the columns
		arr = new ArrayList <String>();
		arr = a;
		String lSpace = LineSpace(lineSpace);
		String s = "";
		String space = "          ";
		int Half = 0;
		int arrSize = 0;
		boolean even;
		
		if(columns == 1)
		{
			for(int i = 0; i < arr.size(); i++)
			{
				s += arr.get(i);
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
						s += arr.get(i).replaceAll("\n", "") + space + arr.get(Half).replaceAll("\n", "") + lSpace;
					}
					else
					{
						s += arr.get(i).replaceAll("\n", "") + space + arr.get(Half).replaceAll("\n", "");
					}
				}
				else if(even == false)
				{
					if(Half < arr.size())
					{
						s += arr.get(i).replaceAll("\n", "") + space + arr.get(Half).replaceAll("\n", "") + lSpace;
					}
					else
					{
						s += arr.get(i).replaceAll("\n", "");
					}
				}
				Half++;
			}
		}
		
		return s;
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
	
	public String indent(String input)
	{
		/*This method will add an indent to line below marker
		//5 spaces at the beginning of the first line*/
		output = "";
		
		String indented = "     " + input;
		output = leftJ(indented, 1, 1, true, false);
		return output;
	}
	
	public String removeIndent(String input)
	{
		// This method will remove an indent to line below marker
		output = "";
		
		output = leftJ(input, 1, 1, false, false);
		return output;
	}
	
	public String block(String input)
	{
		// This method will indent multiple lines (10 space indent)
		output = "";
		
		output = leftJ(input, 1, 1, false, true);
		return output;
	}
	
	public String blank(String input)
	{
		// This method will add a blank line below the marker
		output = "";
		
		output = "\n" + leftJ(input, 1, 1, false, false);
		return output;
	}
}