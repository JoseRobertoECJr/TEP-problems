using System;
using System.Linq;

public class Program
{
	public static void Main()
	{
		var input = "";
		var result = "";
		while((input = Console.ReadLine()) != "0 0")
		{
			var table = input.Split(' ').Select(s => int.Parse(s)).ToList();
			
			var m = Math.Min(table[0], table[1]);
			var n = Math.Max(table[0], table[1]);
			
			if(m == 1)
			{
				result += n + " knights may be placed on a " + table[0] + " row " + table[1] + " column board.\n";
				continue;
			}
			
			if(m == 2)
			{
				var maxKnightsM2 = n + (n%4 == 3 ? 1 : n%4);
				result += maxKnightsM2 + " knights may be placed on a " + table[0] + " row " + table[1] + " column board.\n";
				continue;
			}
			
			var maxKnights = (m * n + 1) / 2;
			
			result += maxKnights + " knights may be placed on a " + table[0] + " row " + table[1] + " column board.\n";
		}
		Console.WriteLine(result.Trim());
	}
}