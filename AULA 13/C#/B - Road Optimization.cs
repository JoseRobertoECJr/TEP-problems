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

        var signs = new long[n + 1];
        var signsInput = Console.ReadLine().Split().Select(el => long.Parse(el)).ToArray();
        Array.Copy(signsInput, 0, signs, 1, signsInput.Length);

        var speeds = new long[n + 1];
        var speedsInput = Console.ReadLine().Split().Select(el => long.Parse(el)).ToArray();
        Array.Copy(speedsInput, 0, speeds, 1, speedsInput.Count());

        long inf = (long)1e18;
        long[,] dp = new long[n + 1, k + 1];

        for (int i = 1; i <= n; i++)
        {
            for (int j = 0; j <= k; j++)
            {
                dp[i, j] = inf;
            }
        }

        dp[1, 0] = 0;

        for (int i = 2; i <= n; i++)
        {
            dp[i, 0] = dp[i - 1, 0] + speeds[i - 1] * (signs[i] - signs[i - 1]);

            for (int j = 1; j <= k; j++)
            {
                long time = inf;
                for (int pre = i - 1; pre >= 1; pre--)
                {
                    int rem = j - (i - pre - 1);
                    if (rem >= 0 && rem <= k)
                    {
                        time = Math.Min(time, dp[pre, rem] + speeds[pre] * (signs[i] - signs[pre]));
                    }
                }
                dp[i, j] = time;
            }
        }

        long minimalTime = inf;
        for (int i = 0; i <= k; i++)
        {
            for (int p = n; p >= 1; p--)
            {
                int rem = i - (n - p);
                if (rem >= 0 && rem <= k)
                {
                    minimalTime = Math.Min(minimalTime, dp[p, rem] + speeds[p] * (l - signs[p]));
                }
            }
        }

        Console.WriteLine(minimalTime);
    }
}
