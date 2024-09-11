using System;
using System.Linq;
using System.Collections.Generic;
using System.Text;

public static class Program
{
    public static void Main()
    {
        var n = int.Parse(Console.ReadLine());

        for (var i = 0; i < n; i++)
        {
            var isZero = false;
            var isPair = false;
            var threeSum = 0;

            var numbers = Console.ReadLine();

            foreach (var numberChar in numbers)
            {
                var number = int.Parse(numberChar.ToString());

                if (!isZero && number == 0)
                {
                    isZero = true;
                }
                else if (number % 2 == 0)
                {
                    isPair = true;
                }

                threeSum+=number;
            }

            var result = isZero && isPair && threeSum % 3 == 0 ? "red" : "cyan";
            
            Console.WriteLine(result);
        }

    }
}