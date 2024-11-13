using System;
using System.Linq;

public static class Program
{
    public static void Main()
    {
        var t = int.Parse(Console.ReadLine());

        for (var i = 0; i < t; i++)
        {
            var n = int.Parse(Console.ReadLine());

            var intList = Console.ReadLine().Split(' ').Select(intEl => int.Parse(intEl))
                                   .ToList();

            var isPossible = Enumerable.Repeat(false, n).ToList();
            foreach (int intEl in intList)
            {
                int nextInt = intEl;
                while (nextInt >= 1)
                {
                    if (nextInt <= n && !isPossible[nextInt - 1])
                    {
                        isPossible[nextInt - 1] = true;
                        break;
                    }

                    nextInt = nextInt / 2;
                }
            }

            if (isPossible.All(x => x))
            {
                Console.WriteLine("Yes");
            }
            else
            {
                Console.WriteLine("No");
            }
        }
    }
}
