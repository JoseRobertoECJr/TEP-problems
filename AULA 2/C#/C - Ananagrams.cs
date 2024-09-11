using System;
using System.Linq;
using System.Collections.Generic;

public static class Program
{
	public static void Main()
	{
		var result = "";
		
		string wordsStr;
		var words = new List<string>();
		
		while((wordsStr = Console.ReadLine()) != "#")
		{
			words.AddRange(wordsStr.Split(' '));
		}
		
		var relativeAnagrams = new List<string>();
		
		for(var i = 0; i < words.Count; i++)
		{
			if(words[i].Length == 1)
			{
				relativeAnagrams.Add(words[i]);
				continue;
			}

			var word1 = new string(words[i].ToUpper().ToCharArray().OrderBy(c => c).ToArray());
			var isAnagram = false;
			for(var j = 0; j < words.Count; j++)
			{

				if(i != j && words[i].Length == words[j].Length)
				{
					var word2 = new string(words[j].ToUpper().ToCharArray().OrderBy(c => c).ToArray());
					
					if(word1 == word2)
					{
						isAnagram = true;
						break;
					}
				}
			}
			
			if(!isAnagram)
			{
				relativeAnagrams.Add(words[i]);
			}
		}
		
		Console.Write(String.Join("\n", relativeAnagrams.OrderBy(rA => rA, StringComparer.Ordinal).ToList()));
	}
}