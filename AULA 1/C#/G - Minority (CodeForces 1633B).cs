using System;

public static class Program
{
	public static void Main()
	{
		int casesNum = int.Parse(Console.ReadLine());

		var result = "";
		
		for(int i = 0; i < casesNum; i++)
		{
			var mcase = Console.ReadLine();
			
			var count0 = CountCharOccurrence(mcase, '0');
			var count1 = mcase.Length - count0;
			
			result += (
					count0 == count1 ?
						(count0 - 1).ToString()
						: (count0 < count1 ? count0.ToString() : count1.ToString())
				)
				+ '\n';
		}
		
		Console.Write(result);
	}
	
	public static int CountCharOccurrence(string source, char toFind)
	{
		int count = 0;
		foreach (var c in source.AsSpan())
		{
			if (c == toFind)
				count++;
		}
		return count;
	}
}