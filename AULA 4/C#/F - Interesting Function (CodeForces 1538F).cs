using System;
using System.Linq;
using System.Collections.Generic;

public static class Program
{
    public static void Main()
    {
        var t = int.Parse(Console.ReadLine());

        for (var i = 0; i < t; i++)
        {
            var listInts = Console.ReadLine().Split(' ');

            var l = int.Parse(listInts[0]);
            var r = int.Parse(listInts[1]);

            int result = 0;
            int exp = 10;

            while (r - l != 0)
            {
                result += r - l;

                r /= exp;
                l /= exp;

                exp = 10;
            }

            Console.WriteLine(result);
        }
    }
}