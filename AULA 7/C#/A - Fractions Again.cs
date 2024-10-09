using System;
using System.Linq;
using System.Collections.Generic;
using System.Text;
using System.Numerics;

public class Program
{
    public static void Main()
    {
        string input;
        while ((input = Console.ReadLine()) != null)
        {
            var k = int.Parse(input);

            var pairs = new List<Pair>();

            for (int i = k + 1; i <= k * 2; i++)
            {
                if((k * i) % (i - k) == 0)
                {
                    pairs.Add(new Pair((k * i) / (i - k), i));
                }
            }

            Console.WriteLine(pairs.Count);

            foreach (var pair in pairs)
            {
                Console.WriteLine($"1/{k} = 1/{pair.x} + 1/{pair.y}");
            }
        }
    }

    public class Pair(int x, int y)
    {
        public int x { get; set; } = x;
        public int y { get; set; } = y;
    }
}
