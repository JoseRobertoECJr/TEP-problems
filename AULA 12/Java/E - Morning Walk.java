import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String lineStr = scanner.nextLine();
            boolean isPossible = true;

            String[] line = lineStr.split(" ");
            int N = Integer.parseInt(line[0]); // number of road intersections
            int R = Integer.parseInt(line[1]); // number of roads

            List<Integer> intersections = new ArrayList<>(Collections.nCopies(N, 0));
            Map<Integer, Map<Integer, Boolean>> roadGraph = new HashMap<>();
            Map<Integer, Boolean> visitedRoads = new HashMap<>();

            for (int i = 0; i < R; i++) {
                try {
                    String[] intersec = scanner.nextLine().split(" ");
                    int c1 = Integer.parseInt(intersec[0]);
                    int c2 = Integer.parseInt(intersec[1]);

                    intersections.set(c1, intersections.get(c1) + 1);
                    intersections.set(c2, intersections.get(c2) + 1);

                    roadGraph.putIfAbsent(c1, new HashMap<>());
                    roadGraph.putIfAbsent(c2, new HashMap<>());

                    roadGraph.get(c1).put(c2, true);
                    roadGraph.get(c2).put(c1, true);

                    visitedRoads.putIfAbsent(c1, false);
                    visitedRoads.putIfAbsent(c2, false);
                } catch (Exception e) {
                    // Handle any parsing error
                }
            }

            for (int i = 0; i < N; i++) {
                if (intersections.get(i) % 2 == 1) {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("Not Possible");
            } else {
                int counter = 0;
                for (int i = 0; i < N && counter <= 1; i++) {
                    try {
                        if (!visitedRoads.getOrDefault(i, false)) {
                            DFS(roadGraph, visitedRoads, N, i);
                            counter++;
                        }
                    } catch (Exception e) {
                        // Ignore any exception
                    }
                }

                System.out.println(counter == 1 ? "Possible" : "Not Possible");
            }
        }
    }

    static void DFS(Map<Integer, Map<Integer, Boolean>> roadGraph, Map<Integer, Boolean> visitedRoads, int N, int index) {
        visitedRoads.put(index, true);

        for (int i = 0; i < N; i++) {
            try {
                if (roadGraph.getOrDefault(index, Collections.emptyMap()).getOrDefault(i, false) && !visitedRoads.getOrDefault(i, false)) {
                    DFS(roadGraph, visitedRoads, N, i);
                }
            } catch (Exception e) {
                // Ignore exceptions
            }
        }
    }
}
