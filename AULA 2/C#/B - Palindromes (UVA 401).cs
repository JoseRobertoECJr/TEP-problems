using System;
using System.Linq;
using System.Collections.Generic;

public static class Program
{
	public static void Main()
	{
		var reverseDict = new Dictionary<char, char>
		{
			{ 'A', 'A' },
			{ 'E', '3' }, { '3', 'E' },
			{ 'H', 'H' },
			{ 'I', 'I' },
			{ 'J', 'L' }, { 'L', 'J' },
			{ 'M', 'M' },
			{ 'O', 'O' },
			{ 'S', '2' }, { '2', 'S' },
			{ 'T', 'T' },
			{ 'U', 'U' },
			{ 'V', 'V' },
			{ 'W', 'W' },
			{ 'X', 'X' },
			{ 'Y', 'Y' },
			{ 'Z', '5' }, { '5', 'Z' },
			{ '1', '1' },
			{ '8', '8' }
		};

		var result = "";
		
		string word;
		while(!string.IsNullOrEmpty(word = Console.ReadLine()))
		{
			var isPalindrome = true;
			var isMirrored = true;
			var chars = word.ToCharArray().ToList();
			var wordLength = chars.Count();
			
			while(chars.Count > 0)
			{
				if(chars.Count >= 2)
				{
					var firstChar = chars.Shift();
					var lastChar = chars.Pop();

					isPalindrome = !isPalindrome ? false
						: firstChar == lastChar;
					isMirrored = !isMirrored ? false
						: reverseDict.TryGetValue(firstChar, out var mirroredChar) && mirroredChar == lastChar;
				}
				else if(chars.Count == 1)
				{
					var lastChar = chars.Pop();
					isMirrored = !isMirrored ? false
						: reverseDict.TryGetValue(lastChar, out var mirroredChar) && mirroredChar == lastChar;
				}
			}
			
			result += word
				+ (!isPalindrome && !isMirrored ? " -- is not a palindrome." : "")
				+ (isPalindrome && !isMirrored ? " -- is a regular palindrome." : "")
				+ (!isPalindrome && isMirrored ? " -- is a mirrored string." : "")
				+ (isPalindrome && isMirrored ? " -- is a mirrored palindrome." : "")
				+ "\n\n"
			;
		}
		
		Console.Write(result);
	}
	
	public static char Pop(this List<char> list) { var result = list.ElementAt(list.Count - 1); list.RemoveAt(list.Count - 1); return result; }
	public static char Shift(this List<char> list) { var result = list.ElementAt(0); list.RemoveAt(0); return result; }
}