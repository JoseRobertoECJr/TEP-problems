using System;
using System.Collections.Generic;

public static class Program
{
    public static void Main()
    {
        var numCases = int.Parse(Console.ReadLine());

        for (var i = 0; i < numCases; i++)
        {
            var number = int.Parse(Console.ReadLine());

            Console.WriteLine(number/10 + (number%10 == 9 ? 1 : 0));
        }
    }
}