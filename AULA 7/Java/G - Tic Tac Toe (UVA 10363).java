import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                String emptyLine = scanner.nextLine();
            }

            char[][] game = new char[3][];
            int X = 0, O = 0;

            for (int j = 0; j < 3; j++) {
                String lineStr = scanner.nextLine();
                char[] line = lineStr.toCharArray();

                game[j] = line;

                for (int k = 0; k < 3; k++) {
                    if (line[k] == 'X') X++;
                    if (line[k] == 'O') O++;
                }
            }

            boolean isValid = false;
            boolean isWinner = false;

            // Se X == O, X nao pode ter vencido
            if (X == O) {
                isValid = true;
                isWinner = checkWin(game, 'X');
            } else if (X == O + 1) { // Se X > O, O nao pode ter vencido na rodada anterior
                isValid = true;
                isWinner = checkWin(game, 'O');
            }

            System.out.println(isValid && !isWinner ? "yes" : "no");
        }

        scanner.close();
    }

    public static boolean checkWin(char[][] game, char player) {
        for (int i = 0; i < 3; i++) {
            if (game[i][0] == player && game[i][1] == player && game[i][2] == player) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (game[0][i] == player && game[1][i] == player && game[2][i] == player) {
                return true;
            }
        }

        if ((game[0][0] == player && game[1][1] == player && game[2][2] == player) ||
            (game[0][2] == player && game[1][1] == player && game[2][0] == player)) {
            return true;
        }

        return false;
    }
}
