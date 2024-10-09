using System;
using System.Linq;
using System.Collections.Generic;
using System.Text;
using System.Numerics;

public class Program
{
    public static void Main()
    {
        int n = int.Parse(Console.ReadLine());

        for (var i = 0; i < n; i++)
        {
            if (i > 0)
            {
                var emptyLine = Console.ReadLine();
            }

            char[][] game = new char[3][];
            int X = 0; int O = 0;

            for (var j = 0; j < 3; j++)
            {
                String lineStr = Console.ReadLine();
                char[] line = lineStr.ToCharArray();

                game[j] = line;

                for (var k = 0; k < 3; k++)
                {
                    if (line[k] == 'X') X++;
                    if (line[k] == 'O') O++;
                }
            }

            var isValid = false;
            var isWinner = false;

            // se X == O, X nao pode ter vencido
            if (X == O)
            {
                isValid = true;
                isWinner = CheckWin(game, 'X');
            }
            else if (X == O + 1) // se X > O, O nao pode ter vencido na rodada anterior
            {
                isValid = true;
                isWinner = CheckWin(game, 'O');
            }

            Console.WriteLine(isValid && !isWinner ? "yes" : "no");
        }
    }

    public static bool CheckWin(char[][] game, char player)
    {
        for (var i = 0; i < 3; i++)
        {
            if (game[i][0] + game[i][1] + game[i][2] == player + player + player)
            {
                return true;
            }
        }

        for (var i = 0; i < 3; i++)
        {
            if (game[0][i] + game[1][i] + game[2][i] == player + player + player)
            {
                return true;
            }
        }

        if (game[0][0] + game[1][1] + game[2][2] == player + player + player
            || game[0][2] + game[1][1] + game[2][0] == player + player + player)
        {
            return true;
        }

        return false;
    }
}
