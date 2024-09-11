import java.util.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        List<Character> orderedChars = new ArrayList<>();
        List<char[]> words = new ArrayList<>();
        Map<Character, Set<Character>> charsDependencies = new HashMap<>();
        Map<Character, Boolean> visited = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        String inputWord = "";
        while (!(inputWord = scanner.nextLine()).equals("#")) {
            words.add(inputWord.toCharArray());

            for (char ch : inputWord.toCharArray()) {
                visited.putIfAbsent(ch, false);
            }
        }

        for (int i = 0; i < words.size() - 1; i++) {
            for (int j = 0; j < words.get(i).length && j < words.get(i + 1).length; j++) {
                if (words.get(i)[j] == words.get(i + 1)[j]) continue;

                charsDependencies.putIfAbsent(words.get(i)[j], new HashSet<>());
                charsDependencies.get(words.get(i)[j]).add(words.get(i + 1)[j]);
                break;
            }
        }

        for (Map.Entry<Character, Boolean> entry : visited.entrySet()) {
            if (entry.getValue()) continue;
            DFS(orderedChars, visited, charsDependencies, entry.getKey());
        }

        Collections.reverse(orderedChars);

        for (char ch : orderedChars) {
            result.append(ch).append("");
        }

        System.out.println(result.toString().trim());
    }

    public static void DFS(List<Character> orderedTasks, Map<Character, Boolean> visited, Map<Character, Set<Character>> tasksDependencies, char chrKey) {
        visited.put(chrKey, true);

        if (!tasksDependencies.containsKey(chrKey)) {
            orderedTasks.add(chrKey);
            return;
        }

        for (char subTask : tasksDependencies.get(chrKey)) {
            if (visited.get(subTask)) continue;

            DFS(orderedTasks, visited, tasksDependencies, subTask);
        }

        orderedTasks.add(chrKey);
    }
}