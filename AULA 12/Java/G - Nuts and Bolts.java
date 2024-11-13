import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static boolean dfs(int bolt, List<List<Integer>> graph, int[] matchedBolt, int[] matchedNut, boolean[] visited) {
        for (int nut : graph.get(bolt)) {
            if (!visited[nut]) {
                visited[nut] = true;
                if (matchedNut[nut] == 0 || dfs(matchedNut[nut], graph, matchedBolt, matchedNut, visited)) {
                    matchedBolt[bolt] = nut;
                    matchedNut[nut] = bolt;
                    return true;
                }
            }
        }
        return false;
    }

    public static int solve(int numBolts, int numNuts, Scanner scanner) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= numBolts; i++) {
            graph.add(new ArrayList<>());
        }

        int[] matchedBolt = new int[numBolts + 1];
        int[] matchedNut = new int[numNuts + numBolts + 1];

        for (int bolt = 1; bolt <= numBolts; bolt++) {
            for (int nut = 1; nut <= numNuts; nut++) {
                int canFit = scanner.nextInt();
                if (canFit == 1) {
                    graph.get(bolt).add(nut + numBolts);
                }
            }
        }

        int maxMatches = 0;

        for (int bolt = 1; bolt <= numBolts; bolt++) {
            if (matchedBolt[bolt] == 0) {
                boolean[] visited = new boolean[numNuts + numBolts + 1];
                if (dfs(bolt, graph, matchedBolt, matchedNut, visited)) {
                    maxMatches++;
                }
            }
        }

        return maxMatches;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        int caseNumber = 0;

        while (testCases > 0) {
            caseNumber++;
            int numBolts = scanner.nextInt();
            int numNuts = scanner.nextInt();

            int maxMatches = solve(numBolts, numNuts, scanner);
            System.out.printf("Case %d: a maximum of %d nuts and bolts can be fitted together%n", caseNumber, maxMatches);

            testCases--;
        }

        scanner.close();
    }
}
