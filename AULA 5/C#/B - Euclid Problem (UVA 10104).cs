using System;
using System.Linq;
using System.Collections.Generic;
using System.Text;
using System.Numerics;

public static class Program
{
    public static void Main()
    {
        string input;
        while ((input = Console.ReadLine()) != null)
        {
            var A = int.Parse(input.Split(' ')[0]);
            var B = int.Parse(input.Split(' ')[1]);

            var (X, Y, D) = ExtendedEuclides(A, B);

            Console.WriteLine($"{X} {Y} {D}");
        }
    }

    public static (int, int, int) ExtendedEuclides(int A, int B)
    {
        var rm1 = A;
        var r = B;

        var u = 1;
        var uM1 = 0;

        var v = 0;
        var vM1 = 1;

        int q, rm1Aux, um1Aux, vm1Aux;

        while (r != 0)
        {
            // Guarda o valor da iteracao anterior: R(k-1), U(k-1) e V(K-1)
            rm1Aux = rm1;
            um1Aux = u;
            vm1Aux = v;

            // Qk = R(k-1) / R(k)
            q = rm1 / r;


            // Atualiza e guarda o valor do R(k-1), U(k-1) e V(K-1)
            rm1 = r;
            u = uM1;
            v = vM1;

            // Proxima iteracao

            // R(K+1) = R(K-1) - R(K) * Q(K)
            r = rm1Aux - r * q;

            // U(K+1) = U(K-1) - U(K) * Q(K)
            uM1 = um1Aux - u * q;

            // V(K+1) = V(K-1) - V(K) * Q(K)
            vM1 = vm1Aux - q * v;
        }

        return (u, v, rm1);
    }
}
