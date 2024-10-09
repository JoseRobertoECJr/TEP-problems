using System;
using System.Linq;
using System.Collections.Generic;
using System.Text;
using System.Numerics;

public static class Program
{
    public static void Main()
    {
        int number;

        var s = int.Parse(Console.ReadLine());

        for (var i = 0; i < s; i++)
        {
            var n = BigInteger.Parse(Console.ReadLine());
            var maxPieces = n * (n - 1) * (n - 2) * (n - 3) / 24 + n * (n - 3) / 2 + n + 1;
            Console.WriteLine(maxPieces);
        }
    }
}
