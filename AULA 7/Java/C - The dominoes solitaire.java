import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int n = scanner.nextInt();

            if (n == 0) {
                break;
            }

            int m = scanner.nextInt();

            List<Piece> pieces = new ArrayList<>();

            for (int i = 0; i < m + 2; i++) {
                int p = scanner.nextInt();
                int q = scanner.nextInt();
                pieces.add(new Piece(p, q, false));
            }

            Flag flag = new Flag(false);
            dfs(pieces, n, m, 0, pieces.get(0).q, flag);

            System.out.println(flag.value ? "YES" : "NO");
        }

        scanner.close();
    }

    public static void dfs(List<Piece> pieces, int n, int m, int idx, int pieceNum, Flag flag) {
        if (idx == n) {
            if (pieceNum == pieces.get(1).p) {
                flag.value = true;
            }
            return;
        }

        for (int i = 2; i < m + 2; i++) {
            if (!pieces.get(i).isUsed) {
                if (pieceNum == pieces.get(i).p) {
                    pieces.get(i).isUsed = true;
                    dfs(pieces, n, m, idx + 1, pieces.get(i).q, flag);
                    pieces.get(i).isUsed = false;
                }

                if (pieceNum == pieces.get(i).q) {
                    pieces.get(i).isUsed = true;
                    dfs(pieces, n, m, idx + 1, pieces.get(i).p, flag);
                    pieces.get(i).isUsed = false;
                }
            }
        }
    }

    static class Piece {
        int p, q;
        boolean isUsed;

        public Piece(int p, int q, boolean isUsed) {
            this.p = p;
            this.q = q;
            this.isUsed = isUsed;
        }
    }

    static class Flag {
        boolean value;

        public Flag(boolean value) {
            this.value = value;
        }
    }
}
