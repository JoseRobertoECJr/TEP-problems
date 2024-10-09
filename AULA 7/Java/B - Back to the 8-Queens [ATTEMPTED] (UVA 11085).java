import java.util.Scanner;
import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int caseNum = 0;

        while (scanner.hasNextLine()) {
            ArrayList<Integer> board = new ArrayList<>();

            for(Integer i = 0; i < 8; i++)
            {
                Integer pos = scanner.nextInt() - 1;
                board.add(pos);
            }

            ArrayList<Integer> rows = new ArrayList<>();
            for (Integer i = 0; i < 8; i++) {
                rows.add(-1);
            }

            int movesNum = (int) backtrack(board, rows, 0, 64, 0);

            System.out.println("Case " + (caseNum++) + ": " + movesNum);
        }

        scanner.close();
    }

    public static Integer backtrack(ArrayList<Integer> board, ArrayList<Integer> rows, Integer column, Integer min, Integer currMovies)
    {
        if (column == 8)
        {
            return Math.min(min, currMovies);
        }

        for (Integer row = 0; row < 8; row++)
        {
            if (isQueensOutOfRange(rows, row, column))
            {
                rows.set(column, row);
                if (row == board.get(column))
                {
                    min = backtrack(board, rows, column + 1, min, currMovies);
                } else {
                    min = backtrack(board, rows, column + 1, min, currMovies + 1);
                }
            }
        }

        return min;
    }

    public static boolean isQueensOutOfRange(ArrayList<Integer> rows, Integer row, Integer column)
    {
        for (Integer lastCol = 0; lastCol < column; lastCol++)
        {
            Integer lastRow = rows.get(lastCol);

            if (lastRow == row || Math.abs(lastRow - row) == Math.abs(lastCol - column))
            {
                return false;
            }
        }

        return true;
    }
}