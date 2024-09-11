using System;
using System.Linq;
using System.Collections.Generic;

public static class Program
{
	public static void Main()
	{
		var result = "";
		
		var numCases = int.Parse(Console.ReadLine());
		
		var dollarDict = new Dictionary<char, int>();
		for(var i = 0; i < numCases; i++)
		{
			var dollars = new Dictionary<char, bool>
			{
				{ 'A', false }, { 'B', false }, { 'C', false }, { 'D', false },
				{ 'E', false }, { 'F', false }, { 'G', false }, { 'H', false },
				{ 'I', false }, { 'J', false }, { 'K', false }, { 'L', false }
			};
			var weighings = new List<Weighing>();
			
			for(var j = 0; j < 3; j++)
			{
				var weighingInput = Console.ReadLine().Split(' ');
				
				var leftSide = weighingInput[2] == "down" ? 1 : 0;
				var rightSide = weighingInput[2] == "down" ? 0 : 1;
				var balance = weighingInput[2] == "down" ? "up" : weighingInput[2];
				
				var weighing = new Weighing
				{
					LeftSide = new HashSet<char>(weighingInput[leftSide].ToCharArray()),
					RightSide = new HashSet<char>(weighingInput[rightSide].ToCharArray()),
					Balance = balance
				};
				
				weighings.Add(weighing);
			}
			
			var index = 0;
			foreach(var weighing in weighings)
			{
				if(weighing.Balance == "even")
				{
					foreach(var dollar in weighing.LeftSide) { dollars[dollar] = true; }
					foreach(var dollar in weighing.RightSide) { dollars[dollar] = true; }
				} else {
				    
				    var doubt = Union(weighing.LeftSide, weighing.RightSide);

					foreach(var dollar in dollars) { dollars[dollar.Key] = !doubt.TryGetValue(dollar.Key, out var _) ? true : dollar.Value; }
				    
					var index2 = 0;
					foreach(var weighing2 in weighings)
					{
						if(index == index2 || weighing2.Balance == "even") { index2++; continue; }
						
						foreach(var item in UnionMinusIntersection(weighing.LeftSide, weighing2.LeftSide))
						{
							dollars[item] = true;
						}
						
						foreach(var item in UnionMinusIntersection(weighing.RightSide, weighing2.RightSide))
						{
							dollars[item] = true;
						}
						
						index2++;
					}
				}
				index++;
			}
			
			var falseDollar = dollars.First(d => d.Value == false).Key;
			
			var falseDollarWeigh = "";
			foreach(var weighing in weighings)
			{
				if(weighing.Balance != "up") continue;
				
				falseDollarWeigh = weighing.LeftSide.TryGetValue(falseDollar, out var _) ? "heavy" : "light" ;
			}
			
			result += falseDollar + " is the counterfeit coin and it is " + falseDollarWeigh + ".\n";
		}
		
		Console.Write(result);
	}
	
	public static HashSet<char> UnionMinusIntersection(HashSet<char> set1, HashSet<char> set2)
	{
		var unionMinusIntersection = new HashSet<char>(set1);
        unionMinusIntersection.UnionWith(set2);
        
		var intersection = new HashSet<char>(set1);
        intersection.IntersectWith(set2);

        unionMinusIntersection.ExceptWith(intersection);
		
		return unionMinusIntersection;
	}
	
	public static HashSet<char> Union(HashSet<char> set1, HashSet<char> set2)
	{
		var union = new HashSet<char>(set1);
        union.UnionWith(set2);
		
		return union;
	}
	
	public class Weighing
	{
		public HashSet<char> LeftSide { get; set; }
		public HashSet<char> RightSide { get; set; }
		public string Balance { get; set; }
	}
}