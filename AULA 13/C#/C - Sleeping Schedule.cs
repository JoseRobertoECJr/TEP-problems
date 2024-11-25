using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;

public static class Program
{
    public static void Main()
    {
        var intList = Console.ReadLine().Split(' ').Select(intEl => int.Parse(intEl))
                       .ToList();

        var n = intList[0];
        var h = intList[1];
        var l = intList[2];
        var r = intList[3];

        var sleepTimes = Console.ReadLine().Split(' ').Select(intEl => int.Parse(intEl))
                       .ToList();

        var index = 0;
        var visitedValues = sleepTimes.ToDictionary(el => index++, el => new Dictionary<int, int>());

        var maxGoodSleeps = DFS(visitedValues, sleepTimes, 0, 0, n, h, l, r);

        Console.WriteLine(maxGoodSleeps.ToString());
    }

    public static int DFS(Dictionary<int, Dictionary<int, int>> visitedValues, List<int> sleepTimes, int index, int lastHour, int n, int h, int l, int r)
    {
        if (index >= n)
        {
            return 0;
        }

        if (visitedValues[index].TryGetValue(lastHour, out var storedMaxGoodSleeps))
        {
            return storedMaxGoodSleeps;
        }

        var sleepChoice1 = (lastHour + sleepTimes[index]) % h;
        var sleepChoice2 = (lastHour + sleepTimes[index] - 1) % h;

        var maxGoodSleeps = Math.Max(
            DFS(visitedValues, sleepTimes, index+1, sleepChoice1, n, h, l, r) + (sleepChoice1 >= l && sleepChoice1 <= r ? 1 : 0),
            DFS(visitedValues, sleepTimes, index+1, sleepChoice2, n, h, l, r) + (sleepChoice2 >= l && sleepChoice2 <= r ? 1 : 0)
        );

        visitedValues[index].TryAdd(lastHour, maxGoodSleeps);

        return maxGoodSleeps;
    }
}
