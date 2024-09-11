using System;
using System.Linq;
using System.Collections.Generic;

public static class Program
{
	public static void Main()
	{
		var result = "";
		
		var numCases = int.Parse(Console.ReadLine());
		
		SortedDictionary<int, int> list = new SortedDictionary<int, int>();
		
		for(var i = 0; i < numCases; i++)
		{
			var commandStr = Console.ReadLine().Split(' ');
			var number = 0;
			
			var command = commandStr[0];
			
			if(commandStr.Count() > 1)
			{
				number = int.Parse(commandStr[1]);
			}
			
			if(command == "insert")
			{
				result = list.Insert(number, result);
			} else if(command == "removeMin")
			{
				if(list.Count == 0)
				{
					result = list.Insert(0, result);
				}
				
				result = list.RemoveMin(result);
			} else if(command == "getMin")
			{
				result = list.GetMin(number, result);
			}
		}
		
		result = result.Length > 0 ? result.Substring(0, result.Length - 1) : result;
		
		Console.Write((result.Length > 0 ? result.Split('\n').Length : 0) + "\n" + result);
	}
	
	public static string Insert(this SortedDictionary<int, int> list, int item, string result)
	{
		result += "insert " + item + "\n";

		if(list.TryGetValue(item, out var itemQnt))
		{
			list[item]++;
		} else {
			list.Add(item, 1);
		}
		
		return result;
	}
	
	public static string RemoveMin(this SortedDictionary<int, int> list, string result)
	{
		result += "removeMin\n";
		
		var min = list.Min();
		
		if(min.Value == 1)
		{
			list.Remove(min.Key);
		} else {
			list[min.Key]--;
		}
		
		return result;
	}
	
	public static string GetMin(this SortedDictionary<int, int> list, int item, string result)
	{
		while(list.Count > 0 && list.Min().Key < item)
		{
			result = list.RemoveMin(result);
		}
		
		if(list.Count == 0 || list.Min().Key != item)
		{
			result += "insert " + item + "\n";
			list.Add(item, 1);
		}
		
		result += "getMin " + item + "\n";
		
		return result;
	}
}