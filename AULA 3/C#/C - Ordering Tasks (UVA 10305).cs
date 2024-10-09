using System;
using System.Text;
using System.Collections.Generic;

public static class Program
{
    public static void Main()
    {
        var result = new StringBuilder();
        var orderedTasks = new List<int>();

        var taskQnt = int.Parse(Console.ReadLine().Split(' ')[0]);

        var visited = new Dictionary<int, bool>();
        for (var i = 1; i <= taskQnt; i++)
        {
            visited.Add(i, false);
        }

        var inputTasksStr = "";
        var tasksDependencies = new Dictionary<int, HashSet<int>>();
        while ((inputTasksStr = Console.ReadLine()) != "0 0")
        {
            var inputTasks = inputTasksStr.Split(' ');

            var task0 = int.Parse(inputTasks[0]);
            var task1 = int.Parse(inputTasks[1]);

            if (!tasksDependencies.ContainsKey(task0))
            {
                tasksDependencies.Add(task0, new HashSet<int>());
            }
            tasksDependencies[task0].Add(task1);
        }


        for (var task = 1; task <= taskQnt; task++)
        {
            if (visited[task]) continue;
            DFS(orderedTasks, visited, tasksDependencies, task);
        }

        foreach (var task in orderedTasks)
        {
            result.Append(task + " ");
        }

        Console.WriteLine(result.ToString().Substring(0, result.Length));
    }

    public static void DFS(List<int> orderedTasks, Dictionary<int, bool> visited, Dictionary<int, HashSet<int>> tasksDependencies, int task)
    {
        visited[task] = true;

		if(!tasksDependencies.ContainsKey(task))
		{
			orderedTasks.Add(task);
			return;
		}
			
        foreach (var subTask in tasksDependencies[task])
        {
            if (visited[subTask]) continue;

            DFS(orderedTasks, visited, tasksDependencies, subTask);
        }
        
        orderedTasks.Add(task);
    }
}