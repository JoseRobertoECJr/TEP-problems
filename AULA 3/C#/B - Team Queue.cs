using System;
using System.Linq;
using System.Collections.Generic;

public static class Program
{
    public static void Main()
    {
        var result = "";

        var scenario = 1;
        for (var teamQnt = 1; (teamQnt = int.Parse(Console.ReadLine())) != 0;)
        {
            result += "Scenario #" + scenario + "\n";

            var teammatesDict = new Dictionary<string, int>();
            for (var i = 0; i < teamQnt; i++)
            {
                var j = 0;
                var team = Console.ReadLine().Split(' ');
                
                foreach (var teammate in team)
                {
                    if (j != 0) teammatesDict.Add(teammate, i);
                    j++;
                }
            }

            var teamsQueueDict = new Dictionary<int, Queue<string>>();

            for (var command = ""; (command = Console.ReadLine()) != "STOP";)
            {
                if(command == "DEQUEUE")
                {
                    var team = teamsQueueDict.First();

                    var teammate = teamsQueueDict[team.Key].Dequeue();

                    if(teamsQueueDict[team.Key].Count == 0)
                    {
                        teamsQueueDict.Remove(team.Key);
                    }

                    result += teammate + "\n";
                }
                else
                {
                    var teammate = command.Split(' ')[1];

                    var team = teammatesDict[teammate];
                    if (!teamsQueueDict.ContainsKey(team))
                    {
                        teamsQueueDict.Add(team, new Queue<string>());

                    }

                    teamsQueueDict[team].Enqueue(teammate);
                }
            }

            result += "\n";

            scenario++;
        }

        Console.Write(result.Substring(0, result.Length - 1));
    }
}