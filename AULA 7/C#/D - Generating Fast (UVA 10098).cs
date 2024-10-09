using System;
using System.Linq;
using System.Collections.Generic;
using System.Text;
using System.Numerics;

public class Program
{
    public static void Main()
    {
        int n = int.Parse(Console.ReadLine());

        for (var i = 0; i < n; i++)
        {
            String word = Console.ReadLine();

            char[] wordChrs = word.ToCharArray();
            Array.Sort(wordChrs);

            do
            {
                Console.WriteLine(string.Join("", wordChrs));
            } while (Next(wordChrs));

            Console.WriteLine("");
        }
    }

    public static bool Next(char[] array)
    {
        int i = array.Length - 2;
        while (i >= 0 && array[i].CompareTo(array[i + 1]) >= 0)
        {
            i--;
        }

        if (i < 0)
        {
            return false;
        }

        int j = array.Length - 1;
        while (array[i].CompareTo(array[j]) >= 0)
        {
            j--;
        }

        (array[i], array[j]) = (array[j], array[i]);

        var start = i + 1;
        var end = array.Length - 1;
        
        while (start < end)
        {
            (array[start], array[end]) = (array[end], array[start]);

            start++;
            end--;
        }

        return true;
    }
}
