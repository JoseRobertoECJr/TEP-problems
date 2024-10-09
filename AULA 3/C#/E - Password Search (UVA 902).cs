using System;
using System.Linq;
using System.Collections.Generic;

public static class Program
{
    public static void Main()
    {
        var inputStr = "";
        while (!string.IsNullOrEmpty((inputStr = Console.ReadLine())))
        {
			var passwordLength = int.Parse(inputStr.Split(' ')[0]);
			var message = inputStr.Split(' ')[1];
			
	        var substringsCount = new Dictionary<string, int>();
			
			var maxOcc = 0;
			var strMaxOcc = "";
			for(var i = 0; i < message.Length - passwordLength + 1; i++)
			{
				var substring = message.Substring(i, passwordLength);

				var isAdd = substringsCount.TryAdd(substring, 1);
				
				substringsCount[substring] = isAdd ? 1 : substringsCount[substring] + 1;
				
				if(maxOcc < substringsCount[substring])
				{
					strMaxOcc = substring;
					maxOcc = substringsCount[substring];
				}
			}
			
			Console.WriteLine(strMaxOcc);
        }

    }
}
