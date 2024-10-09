using System;
using System.Linq;
using System.Collections.Generic;

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
				
				var isEqual = true;
				for(var j = i; j < inputStr.Length; j+=i)
				{
					var substringTest = inputStr.Substring(j, i);
					
					if(!substring.Equals(substringTest))
					{
						isEqual = false;
						i = j;
						break;
					}
				}
				
				if(isEqual)
				{
					exp = inputStr.Length/i;
					break;
				}
			}
			Console.WriteLine(exp);
        }

    }
}