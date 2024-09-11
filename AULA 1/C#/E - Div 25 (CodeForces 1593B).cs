using System;
using System.Linq;

public static class Program
{
	public static void Main()
	{
		int casesNum = int.Parse(Console.ReadLine());

		var result = "";
		
		for(int i = 0; i < casesNum; i++)
		{
			var number = Console.ReadLine();
			char[] digits = number.ToCharArray();
			var numberLength = digits.Count();			

			var frstDgtIdx = 0;
			var minRemovedDgts = numberLength;
			foreach(var digit in digits)
			{
				for(var scndDgtIdx = frstDgtIdx+1; scndDgtIdx < numberLength; scndDgtIdx++)
				{
					int divNumber = int.Parse(new string(new []{ digit, digits[scndDgtIdx] }));
					
					if(divNumber%25 == 0)
					{
						minRemovedDgts = Math.Min(minRemovedDgts, (scndDgtIdx - frstDgtIdx - 1) + (numberLength - 1 - scndDgtIdx));
					}
				}
				frstDgtIdx++;
			}
			
			result += minRemovedDgts + "\n";
		}
		
		Console.Write(result);
	}
}