using System;
using System.Text.RegularExpressions;

public static class Program
{
    public static void Main()
    {
        var inputStr = "";
        while ((inputStr = Console.ReadLine()) != ".")
        {
			var exp = 1;
			for(var i = 1; i <= inputStr.Length / 2; i++)
			{
				var substring = inputStr.Substring(0, i);
				
				var numOcc = Regex.Matches(inputStr, substring).Count;
				
				if(numOcc*substring.Length == inputStr.Length)
				{
					exp = inputStr.Length/i;
					break;
				}
			}
			Console.WriteLine(exp);
        }

    }
}