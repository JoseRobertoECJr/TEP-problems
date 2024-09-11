using System;
using System.Linq;
using System.Collections.Generic;

public static class Program
{
    public static void Main()
    {
        var numCases = int.Parse(Console.ReadLine());

        for (var i = 0; i < numCases; i++)
        {
            var numInts = int.Parse(Console.ReadLine());
            var isOne = false;

            var listInts = Console.ReadLine().Split(' ')
                .Select(num =>
                {
                    var intNum = int.Parse(num);
                    if (intNum == 1) isOne = true;

                    return intNum;
                })
                .OrderBy(n => n).ToList();

            var index = 0;
            foreach (var num in listInts)
            {
                if(index != 0 && num - 1 == listInts[index - 1] && isOne)
                {
                    Console.WriteLine("NO");
                    break;
                }

                index++;
            }

            if (index == listInts.Count) Console.WriteLine("YES");
        }
    }
}