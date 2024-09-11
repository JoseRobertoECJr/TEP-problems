using System;
using System.Linq;
using System.Collections.Generic;

public static class Program
{
	public static void Main()
	{
		var result = "";
		
		var numCases = int.Parse(Console.ReadLine());
		
		for(var j = 0; j < numCases; j++)
		{
			Console.ReadLine(); // blank line
			Console.ReadLine(); // number of inputs line
			
			LinkedList<int> blackBox = new LinkedList<int>();
			var i = 0;
			
			var dataSet = Console.ReadLine().Split(' ');
			var gets = Console.ReadLine().Split(' ').ToList();
			
			var numberOfADD = 0;
			foreach(var data in dataSet)
			{
				var numberToADD = int.Parse(data);

				blackBox.AddBefore(numberToADD);
				
				numberOfADD++;
				
				while(gets.Count > 0 && int.Parse(gets[0]) == numberOfADD)
				{
					gets.RemoveAt(0);
					
					result += blackBox.ElementAt(i) + "\n";
					
					i++;
				}
			}
		}
		
		Console.Write(result.Substring(0, result.Length - 1));
	}
	
	public static void AddBefore(this LinkedList<int> list, int item)
	{
		for (var node = list.First; node != null; node = node.Next)
		{
			if(node.Value > item)
			{
				list.AddBefore(node, item);
				return;
			}
		}
		
		list.AddLast(item);
	}
}