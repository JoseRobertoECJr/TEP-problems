using System;
using System.Text;
using System.Collections.Generic;
using System.Linq;

public static class Program
{
    public static void Main(string[] args)
    {
        int n, l, k;
        string[] input = Console.ReadLine().Split();
        n = int.Parse(input[0]);
        l = int.Parse(input[1]);
        k = int.Parse(input[2]);

        var signs = new long[n + 2];
        var signsInput = Console.ReadLine().Split().Select(el => long.Parse(el)).ToArray();
        Array.Copy(signsInput, 0, signs, 1, signsInput.Length);
        signs[n + 1] = l;

        var speeds = new long[n + 2];
        var speedsInput = Console.ReadLine().Split().Select(el => long.Parse(el)).ToArray();
        Array.Copy(speedsInput, 0, speeds, 1, speedsInput.Count());


        long[,] dp = new long[n + 3, k + 3];

        for (int i = 0; i <= n + 2; i++)
        {
            for (int j = 0; j <= k + 2; j++)
            {
                dp[i, j] = -1;
            }
        }

        dp[1, 0] = 0;

        for (int i = 2; i < n + 2; i++)
        {
            dp[i, 0] = dp[i - 1, 0] + (signs[i] - signs[i - 1]) * speeds[i - 1];

            for (int j = 1; j < k + 1; j++)
            {
                for (int p = i - 1; p > 0; p--)
                {
                    int removed = i - p - 1;

                    if (removed <= j)
                    {
                        long time = dp[p, j - removed] + (signs[i] - signs[p]) * speeds[p];

                        if (dp[i, j] == -1) dp[i, j] = time;
                        else dp[i, j] = Math.Min(dp[i, j], time);
                    }
                }
            }
        }

        long minimalTime = -1;

        for (int i = 0; i <= k; i++)
        {
            if (minimalTime == -1) minimalTime = dp[n + 1, i];
            else minimalTime = Math.Min(minimalTime, dp[n + 1, i]);
        }

        Console.WriteLine(minimalTime);
    }
}
