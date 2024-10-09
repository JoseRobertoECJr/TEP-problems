using System;
using System.Linq;
using System.Text;
using System.Collections.Generic;

public static class Program
{
    public static void Main()
    {
        var result = new StringBuilder();

        var orderedChars = new List<char>();
        var words = new List<char[]>();
        var charsDependencies = new Dictionary<char, HashSet<char>>();
        var visited = new Dictionary<char, bool>();

        var inputWord = "";
        while ((inputWord = Console.ReadLine()) != "#")
        {
            words.Add(inputWord.AsSpan().ToArray());

            foreach (var word in inputWord.AsSpan())
            {
                visited.TryAdd(word, false);
            }
        }

        for (int i = 0; i < words.Count - 1; i++)
        {
            for (int j = 0; j < words[i].Length && j < words[i+1].Length; j++)
            {
                if(words[i][j] == words[i+1][j]) continue;

                charsDependencies.TryAdd(words[i][j], new HashSet<char>());

                charsDependencies[words[i][j]].Add(words[i + 1][j]);
            }
        }

        foreach (var chr in visited)
        {
            if (chr.Value) continue;
            DFS(orderedChars, visited, charsDependencies, chr.Key);
        }

        orderedChars.Reverse();
        
        foreach (var chars in orderedChars)
        {
            result.Append(chars + "");
        }

        Console.WriteLine(result.ToString().Trim());
    }

    public static void DFS(List<char> orderedTasks, Dictionary<char, bool> visited, Dictionary<char, HashSet<char>> tasksDependencies, char chrKey)
    {
        visited[chrKey] = true;

        if (!tasksDependencies.ContainsKey(chrKey))
        {
            orderedTasks.Add(chrKey);
            return;
        }

        foreach (var subTask in tasksDependencies[chrKey])
        {
            if (visited[subTask]) continue;

            DFS(orderedTasks, visited, tasksDependencies, subTask);
        }

        orderedTasks.Add(chrKey);
    }
}