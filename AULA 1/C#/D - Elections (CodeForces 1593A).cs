using System;
using System.Linq;
using System.Collections.Generic;

public static class Program
{
	public static void Main()
	{
		int casesNum = int.Parse(Console.ReadLine());

		var result = "";
		
		for(int i = 0; i < casesNum; i++)
		{
			var votesStr = Console.ReadLine();
			var votes = votesStr.Split(' ').Select(vote => int.Parse(vote));
			
			(var repeated, var maxVotes) = GetMaxPositiveValue(votes);
			
			var plusVotes = new List<string>();
			foreach(var vote in votes)
			{
				if(vote == maxVotes && !repeated)
				{
					plusVotes.Add("0");
					continue;
				}
				
				plusVotes.Add((maxVotes - vote + 1).ToString());
			}
			
			result += String.Join(' ', plusVotes) + "\n";
		}
		
		Console.Write(result);
	}
	
	public static (bool, int) GetMaxPositiveValue(IEnumerable<int> numbers)
	{
		var repeated = false;
		var maxValue = -1;
		foreach(var number in numbers)
		{
			if(number == maxValue)
			{
				repeated = true;
			}
			else if(number > maxValue)
			{
				maxValue = number;
				repeated = false;
			}
		}
		
		return (repeated, maxValue);
	}
}