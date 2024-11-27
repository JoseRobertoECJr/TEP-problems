using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;

// So passa em python RIP
public static class Program
{
    public static void Main()
    {
        string s = Console.ReadLine();
        int n = s.Length;

        List<int> prefix = new int[n].ToList();
        List<int> suffix = new int[n].ToList();

        for (int i = 1; i < n; i++)
        {
            suffix[i] = suffix[i - 1] + (s[i] == 'v' && s[i - 1] == 'v' ? 1 : 0);
        }

        for (int i = n - 2; i >= 0; i--)
        {
            prefix[i] = prefix[i + 1] + (s[i] == 'v' && s[i + 1] == 'v' ? 1 : 0);
        }

        int wowFactor = 0;
        for (int i = 0; i < n; i++)
        {
            if (s[i] == 'o')
            {
                wowFactor += suffix[i] * prefix[i];
            }
        }

        Console.WriteLine(wowFactor);
    }
}
