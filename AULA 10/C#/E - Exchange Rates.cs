using System;
using System.Text;
using System.Collections.Generic;

public static class Program
{
    public static void Main()
    {
        var relations = new Dictionary<string, Dictionary<string, Tuple<int, int>>>();

        while (true)
        {
            var input = Console.ReadLine()!.Split(' ');

            if (input[0] == "!")
            {
                var m = int.Parse(input[1]);
                var n = int.Parse(input[4]);

                var itema = input[2].Trim();
                var itemb = input[5].Trim();

                var factor = GCD(m, n);

                m /= factor;
                n /= factor;

                var relationA = new Dictionary<string, Tuple<int, int>>
                {
                    { itemb, new Tuple<int, int>(m, n) }
                };

                var relationB = new Dictionary<string, Tuple<int, int>>
                {
                    { itema, new Tuple<int, int>(n, m) }
                };

                if(!relations.ContainsKey(itema))
                {
                    relations.TryAdd(itema, relationA);
                }
                else if(!relations[itema].ContainsKey(itemb))
                {
                    relations[itema].TryAdd(itemb, new Tuple<int, int>(m, n));
                }

                if (!relations.ContainsKey(itemb))
                {
                    relations.TryAdd(itemb, relationB);
                }
                else if (!relations[itemb].ContainsKey(itema))
                {
                    relations[itemb].TryAdd(itema, new Tuple<int, int>(n, m));
                }
            }
            else if (input[0] == "?")
            {
                var itema = input[1].Trim();
                var itemb = input[3].Trim();

                var result = DFS(relations, itema, itemb);

                var strResult = $"{(result.Item1 ? $"{result.Item2.Item1}" : "?")} {itema} = {(result.Item1 ? $"{result.Item2.Item2}" : "?")} {itemb}";

                Console.WriteLine(strResult);
            }
            else
            {
                break;
            }
        }
    }

    public static int GCD(int a, int b)
    {
        while (b != 0)
        {
            int r = a % b;
            a = b;
            b = r;
        }

        return a;
    }

    public static Tuple<bool, Tuple<int, int>> DFS(Dictionary<string, Dictionary<string, Tuple<int, int>>> relations, string itema, string itemb)
    {
        var visited = new Dictionary<string, bool>();

        foreach (var rel in relations)
        {
            visited.TryAdd(rel.Key, false);
        }

        return DFS(relations, visited, itema, itemb);
    }

    public static Tuple<bool, Tuple<int, int>> DFS(Dictionary<string, Dictionary<string, Tuple<int, int>>> relations, Dictionary<string, bool> visited, string itema, string itemb)
    {
        visited[itema] = true;

        foreach (var rel in relations[itema])
        {
            if(rel.Key == itemb)
            {
                return Tuple.Create(true, rel.Value);
            }
            else if (!visited[rel.Key])
            {
                var next = rel.Key;

                var result = DFS(relations, visited, next, itemb);

                if(result.Item1)
                {
                    var x = result.Item2.Item1 * rel.Value.Item1;
                    var y = result.Item2.Item2 * rel.Value.Item2;

                    var factor = GCD(x, y);

                    x /= factor;
                    y /= factor;

                    return Tuple.Create(true, Tuple.Create(x, y));
                }
            }
        }

        return Tuple.Create(false, Tuple.Create(0, 0));
    }
}