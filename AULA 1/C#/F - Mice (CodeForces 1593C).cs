using System;
using System.Linq;

public static class Program
{
	public static void Main()
	{
		int casesNum = int.Parse(Console.ReadLine());

		var result = "";
		
		for(int i = 0; i < casesNum; i++)
		{
			var mcase = Console.ReadLine();
			var holeLoc = int.Parse(mcase.Split(' ')[0]);
			
			var miceLocsStr = Console.ReadLine();
			string[] miceLocs = miceLocsStr.Split(' ');
			
			var miceLocsOrdered = miceLocs.Select(loc => int.Parse(loc)).OrderByDescending(loc => loc);
			
			var maxMice = 0;
			var currMaxSteps = holeLoc;
			var catLoc = 0;
			foreach(var mouseLoc in miceLocsOrdered)
			{
				currMaxSteps -= holeLoc - mouseLoc;
				
				if(currMaxSteps < 0 || mouseLoc <= catLoc)
				{
					break;
				}
				maxMice++;
				catLoc = holeLoc - currMaxSteps;
			}
			
			result += maxMice.ToString() + '\n';
		}
		
		Console.Write(result);
	}
}