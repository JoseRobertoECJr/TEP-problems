using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;

public static class Program
{
    public static void Main()
    {
        string s = Console.ReadLine();
        int n = s.Length;

        List<int> prefix = new int[n+1].ToList();
        List<int> sufix = new int[n+1].ToList();
        char[] charArray = new char[n+1];

        Array.Copy(s.ToCharArray(), 0, charArray, 1, n);

        for (int i = 2; i <= n; i++)
        {
            int sufixIndex = n - i + 1;

            var oneMorePrefixW = charArray[i] == 'v' && charArray[i - 1] == 'v' ? 1 : 0;
            var oneMoreSufixW = charArray[sufixIndex] == 'v' && charArray[sufixIndex + 1] == 'v' ? 1 : 0;

            prefix[i] = prefix[i - 1] + oneMorePrefixW;
            sufix[sufixIndex] = sufix[sufixIndex + 1] + oneMoreSufixW;
        }

        int wowFactor = 0;
        for (int i = 3; i <= n - 2; i++)
        {
            if (charArray[i] == 'o')
            {
                wowFactor += (int)prefix[i - 1] * sufix[i + 1];
            }
        }

        Console.WriteLine(wowFactor);
    }
}
