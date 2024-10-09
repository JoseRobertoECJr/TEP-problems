using System;
using System.Linq;
using System.Collections.Generic;
using System.Text;
using System.Numerics;

public class Program
{
    public static void Main(string[] args)
    {

        while (true)
        {
            string input = Console.ReadLine();
            if (!int.TryParse(input, out var n) || n == 0)
                break;

            var m = int.Parse(Console.ReadLine());

            var pieces = new List<Piece>();

            for (int i = 0; i < m + 2; i++)
            {
                string[] values = Console.ReadLine().Split(' ');
                pieces.Add(new Piece (int.Parse(values[0]), int.Parse(values[1]), false));
            }

            var flag = new Flag(false);
            Dfs(pieces, n, m, 0, pieces[0].q, flag);

            Console.WriteLine(flag.value ? "YES" : "NO");
        }
    }

    public static void Dfs(List<Piece> pieces, int n, int m, int idx, int pieceNum, Flag flag)
    {
        if (idx == n)
        {
            if (pieceNum == pieces[1].p)
                flag.value = true;

            return;
        }

        for (int i = 2; i < m + 2; i++)
        {
            if (!pieces[i].isUsed)
            {
                if (pieceNum == pieces[i].p)
                {
                    pieces[i].isUsed = true;
                    Dfs(pieces, n, m, idx + 1, pieces[i].q, flag);
                    pieces[i].isUsed = false;
                }

                if (pieceNum == pieces[i].q)
                {
                    pieces[i].isUsed = true;
                    Dfs(pieces, n, m, idx + 1, pieces[i].p, flag);
                    pieces[i].isUsed = false;
                }
            }
        }
    }

    public class Piece(int p, int q, bool isUsed)
    {
        public int p { get; set; } = p;
        public int q { get; set; } = q;
        public bool isUsed { get; set; } = isUsed;
    }

    public class Flag(bool value)
    {
        public bool value { get; set; } = value;
    }
}
