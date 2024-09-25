using System;

public class Program
{
    public static void Main()
    {
        string input;
        while (!string.IsNullOrEmpty(input = Console.ReadLine()))
        {
            var inputs = input.Split();
            var n = int.Parse(inputs[0]);
            var m = int.Parse(inputs[1]);

            var mAux = m;
            var isDivisible = true;

            for (int i = 2; i * i <= mAux && isDivisible; i++)
            {
                var count = 0;
                while (mAux % i == 0)
                {
                    mAux /= i;
                    count++;
                }

                if (count > 0) isDivisible = IsDivisible(n, i, count);
            }

            if (mAux > 1 && isDivisible) isDivisible = IsDivisible(n, mAux, 1);

            Console.WriteLine($"{m} {(isDivisible ? "divides" : "does not divide")} {n}!");
        }
    }

    public static bool IsDivisible(int n, int num, int count)
    {
        for (long numFac = num;  n / numFac > 0 && count > 0; numFac *= num)
        {
            count -= (int) (n / numFac);
        }

        return count <= 0;
    }
}
