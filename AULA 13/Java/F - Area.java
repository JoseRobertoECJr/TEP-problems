import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int test = 1; test <= T; test++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int K = scanner.nextInt();

            int[][] Pij = new int[101][101];
            int[][] DP = new int[101][101];

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    Pij[i][j] = scanner.nextInt();
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    DP[i][j] = DP[i][j - 1] + Pij[i][j];
                }
            }

            int P = 0, S = 0;
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    for (int k = 1; k <= j; k++) {
                        int cost = 0, area = 0;
                        for (int l = 0; i + l <= N; l++) {
                            cost += DP[i + l][j] - DP[i + l][k - 1];
                            area += (j - k + 1);

                            if(cost > K) break;

                            if (area > S) {
                                S = area;
                                P = cost;
                            } else if (area == S && P > cost) {
                                P = cost;
                            }
                        }
                    }
                }
            }

            System.out.printf("Case #%d: %d %d\n", test, S, P);
        }

        scanner.close();
    }
}
