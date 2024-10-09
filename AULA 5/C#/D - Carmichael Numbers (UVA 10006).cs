using System;
using System.Linq;
using System.Collections.Generic;
using System.Text;
using System.Numerics;

public static class Program
{
    public static void Main()
    {
        var max = 65000;
        var primeList = CalcPrimes(max);

        string input;
        while ((input = Console.ReadLine()) != "0")
        {
            var n = int.Parse(input);

            var isPossiblePrime = true;

            for (int i = 2; i < n && !primeList[n]; i++)
            {
                if(FermatTest(i, n, n) != i)
                {
                    isPossiblePrime = false;
                    break;
                }
            }

            if (isPossiblePrime && !primeList[n])
            {
                Console.WriteLine($"The number {n} is a Carmichael number.");
            }
            else
            {
                Console.WriteLine($"{n} is normal.");
            }
        }
    }

    public static List<bool> CalcPrimes(int max)
    {
        var primeList = new List<bool>();
        for (int i = 0; i < max; i++)
        {
            primeList.Add(i != 0 && i != 1);
        }

        for (int i = 2; i < max/2; i++)
        {

            if (primeList[i] == true)
            {

                for (int j = 2 * i; j < max; j += i) { primeList[j] = false; }
            }
        }

        return primeList;
    }

    public static long FermatTest(int a, int n, int m)
    {
        if (n == 0) { return 1; }
        else
        {

            if (n % 2 == 0)
            {

                long temp = FermatTest(a, n / 2, m);

                return temp * temp % m;
            }
            else
            {
                return FermatTest(a, n - 1, m) * (a % m) % m;
            }
        }
    }
}
