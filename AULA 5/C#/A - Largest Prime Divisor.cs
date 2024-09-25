using System;

public class Program
{
    public static void Main()
    {
        string input;
        while ((input = Console.ReadLine()) != "0")
        {
            var N = long.Parse(input);

            // Tratando numeros negativos
            if (N < 0) N *= -1;

            long largestPrimeDiv = -1;

            var count = 0;
            for (long i = 2; i * i <= N && N != 1; i++)
            {
                while (N % i == 0)
                {
                    N /= i;
                    largestPrimeDiv = i;
                }

                if (largestPrimeDiv == i) count++;
            }

            if (N != 1 && largestPrimeDiv != -1)
            {
                largestPrimeDiv = N;
            }
            else if (count == 1)
            {
                largestPrimeDiv = -1;
            }

            Console.WriteLine(largestPrimeDiv);
        }
    }
}
