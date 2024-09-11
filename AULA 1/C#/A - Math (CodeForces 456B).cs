using System;
using System.Collections.Generic;

public static class Program
{
	public static void Main()
	{
		double result = 4;
		string n = Console.ReadLine();
		
		int mod4 = int.Parse(GetLast(n,2)) % 4;
		int mod2 = int.Parse(GetLast(n,2)) % 2;
		
		var endNumbersOf2 = new Dictionary<int, int>(){{ 1, 2 },{ 2, 4 },{ 3, 8 },{ 0, 6 }};
		var endNumbersOf3 = new Dictionary<int, int>(){{ 1, 3 },{ 2, 9 },{ 3, 7 },{ 0, 1 }};
		var endNumbersOf4 = new Dictionary<int, int>(){{ 1, 4 },{ 0, 6 }};

		result = (1 + endNumbersOf2[mod4] + endNumbersOf3[mod4] + endNumbersOf4[mod2]) % 5;
		
		Console.WriteLine(result);
	}
	
	public static string GetLast(this string source, int tail_length)
    {
       if(tail_length >= source.Length)
          return source;
       return source.Substring(source.Length - tail_length);
    }
}