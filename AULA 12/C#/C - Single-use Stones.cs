using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;

public static class Program
{
    public static void Main()
    {
        var line = Console.ReadLine().Split(' ');

        var w = int.Parse(line[0]);
        var l = int.Parse(line[1]);

        var stones = Console.ReadLine().Split(' ')
            .Select(stoneStr => int.Parse(stoneStr)).ToList();

        var maxFirstFrogs = 0;
        for (var i = 0; i < l; i++)
        {
            maxFirstFrogs += stones[i];
        }

        var maxFrogs = maxFirstFrogs;
        for (var i = l; i < w - 1; i++)
        {
            maxFirstFrogs +=  stones[i] - stones[i - l];
            maxFrogs = Math.Min(maxFirstFrogs, maxFrogs);
        }

        Console.WriteLine(maxFrogs);
    }
}
