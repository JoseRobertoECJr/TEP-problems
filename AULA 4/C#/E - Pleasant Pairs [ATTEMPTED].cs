using System;
using System.Linq;
using System.Collections.Generic;
using System.Text;

public static class Program
{
    public static void Main()
    {
        var resultStr = new StringBuilder();

        var casesQnt = int.Parse(Console.ReadLine());

        for (var i = 0; i < casesQnt; i++)
        {
            var result = 0;

            var numQnt = int.Parse(Console.ReadLine());

            var index = 1;
            var listInts = Console.ReadLine().Split(' ')
                .ToDictionary(item => index++, item => int.Parse(item));

            for (int j = 1; j < numQnt; j++)
            {
                // num * listInts[k] = j + k
                // k(N) = (num * N) - j
                // Ou seja, k multiplo de num - j
                // Logo, k += listInts[j]

                // Temos que comecar em um multiplo depois de j, pois ja testamos os anteriores
                // Logo, j + (listInts[j] - j%listInts[j]) = prox multiplo
                // multiplo = j + k => k = (listInts[j] - j%listInts[j])

                for (int k = listInts[j] - j % listInts[j]; k <= numQnt; k += listInts[j])
                {
                    if(k <= j) continue;

                    var multp = listInts[j] * listInts[k];

                    if (multp == j + k) result++;
                }
            }

            resultStr.Append(result + "\n");
        }

        Console.WriteLine(resultStr.ToString());
    }
}