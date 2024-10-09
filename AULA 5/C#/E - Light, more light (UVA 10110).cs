using System;
using System.Linq;
using System.Collections.Generic;
using System.Text;
using System.Numerics;

public static class Program
{
    public static void Main()
    {
        long nBulbs;
        while ((nBulbs = long.Parse(Console.ReadLine())) != 0)
        {
            Console.WriteLine(Math.Sqrt(nBulbs) % 1 == 0 ? "yes" : "no");
        }
    }
}
