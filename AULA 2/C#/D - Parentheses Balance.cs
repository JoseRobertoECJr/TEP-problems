using System;
using System.Linq;
using System.Collections.Generic;

public static class Program
{
	public static void Main()
	{
		var result = "";
		
		var simbolDict = new Dictionary<char, char>
		{
			{ '[', ']' },
			{ '(', ')' }
		};
		
		var numCases = int.Parse(Console.ReadLine());
		
		for(var i = 0; i < numCases; i++)
		{
			var seqQueue = new List<char>();
			var sequenceStr = Console.ReadLine();
			var sequence = Console.ReadLine().ToCharArray();
			
			if(string.IsNullOrEmpty(sequenceStr))
			{
				result += "Yes\n";
				continue;
			}
			
			var isRight = true;
			foreach(var simbol in sequence)
			{
				if(simbol == '(' || simbol == '[')
				{
					seqQueue.push(simbol);
				}
				else if ((simbol == ')' || simbol == ']') && (seqQueue.Count == 0 || simbolDict[seqQueue.pop()] != simbol))
				{
					isRight = false;
					break;
				}
			}
			
			result += isRight ? "Yes\n" : "No\n"; 
		}
		
		Console.Write(result);
	}
	
	public static char pop(this List<char> list) { var item = list.ElementAt(list.Count - 1); list.RemoveAt(list.Count - 1); return item; }
	public static void push(this List<char> list, char item) { list.Add(item); }
}