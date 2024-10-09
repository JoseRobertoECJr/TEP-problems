import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        int scenario = 1;

        while (true) {
            int teamQnt = Integer.parseInt(scanner.nextLine());
            if (teamQnt == 0) break;

            result.append("Scenario #").append(scenario).append("\n");

            Map<String, Integer> teammatesDict = new HashMap<>();
            for (int i = 0; i < teamQnt; i++) {
                String[] team = scanner.nextLine().split(" ");
                for (int j = 1; j < team.length; j++) {
                    teammatesDict.put(team[j], i);
                }
            }

            Map<Integer, Queue<String>> teamsQueueDict = new LinkedHashMap<>();

            while (true) {
                String command = scanner.nextLine();
                if (command.equals("STOP")) break;

                if (command.equals("DEQUEUE")) {
                    Map.Entry<Integer, Queue<String>> team = teamsQueueDict.entrySet().iterator().next();

                    String teammate = team.getValue().poll();

                    if (team.getValue().isEmpty()) {
                        teamsQueueDict.remove(team.getKey());
                    }

                    result.append(teammate).append("\n");
                } else {
                    String teammate = command.split(" ")[1];
                    int team = teammatesDict.get(teammate);

                    teamsQueueDict.putIfAbsent(team, new LinkedList<>());
                    teamsQueueDict.get(team).add(teammate);
                }
            }
            
            result.append("\n");

            scenario++;
        }

        System.out.print(result.toString());
    }
}