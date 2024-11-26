#include <iostream>
#include <vector>
#include <climits>

using namespace std;

int main() {
    int T;
    cin >> T;

    for (int test = 1; test <= T; test++) {
        int N, M, K;
        cin >> N >> M >> K;

        vector<vector<int>> Pij(101, vector<int>(101, 0));
        vector<vector<int>> DP(101, vector<int>(101, 0));

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                cin >> Pij[i][j];
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

                        if (cost > K) break;

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

        cout << "Case #" << test << ": " << S << " " << P << endl;
    }

    return 0;
}
