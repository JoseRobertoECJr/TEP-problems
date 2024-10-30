import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Pair<Integer, Integer>>> relations = new HashMap<>();

        while (true) {
            String[] input = scanner.nextLine().split(" ");

            if (input[0].equals("!")) {
                int m = Integer.parseInt(input[1]);
                int n = Integer.parseInt(input[4]);

                String itema = input[2].trim();
                String itemb = input[5].trim();

                int factor = GCD(m, n);

                m /= factor;
                n /= factor;

                relations.computeIfAbsent(itema, k -> new HashMap<>()).put(itemb, new Pair<>(m, n));
                relations.computeIfAbsent(itemb, k -> new HashMap<>()).put(itema, new Pair<>(n, m));
                
            } else if (input[0].equals("?")) {
                String itema = input[1].trim();
                String itemb = input[3].trim();

                Pair<Boolean, Pair<Integer, Integer>> result = DFS(relations, itema, itemb);

                String strResult = (result.getKey() ? result.getValue().getKey() : "?") + " " + itema + " = " + (result.getKey() ? result.getValue().getValue() : "?") + " " + itemb;
                System.out.println(strResult);
                
            } else {
                break;
            }
        }
        scanner.close();
    }

    public static int GCD(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static Pair<Boolean, Pair<Integer, Integer>> DFS(Map<String, Map<String, Pair<Integer, Integer>>> relations, String itema, String itemb) {
        Map<String, Boolean> visited = new HashMap<>();
        for (String key : relations.keySet()) {
            visited.put(key, false);
        }
        return DFS(relations, visited, itema, itemb);
    }

    public static Pair<Boolean, Pair<Integer, Integer>> DFS(Map<String, Map<String, Pair<Integer, Integer>>> relations, Map<String, Boolean> visited, String itema, String itemb) {
        visited.put(itema, true);

        for (Map.Entry<String, Pair<Integer, Integer>> rel : relations.getOrDefault(itema, Collections.emptyMap()).entrySet()) {
            if (rel.getKey().equals(itemb)) {
                return new Pair<>(true, rel.getValue());
            } else if (!visited.get(rel.getKey())) {
                Pair<Boolean, Pair<Integer, Integer>> result = DFS(relations, visited, rel.getKey(), itemb);
                if (result.getKey()) {
                    int x = result.getValue().getKey() * rel.getValue().getKey();
                    int y = result.getValue().getValue() * rel.getValue().getValue();

                    int factor = GCD(x, y);

                    x /= factor;
                    y /= factor;

                    return new Pair<>(true, new Pair<>(x, y));
                }
            }
        }

        return new Pair<>(false, new Pair<>(0, 0));
    }

    static class Pair<K, V> {
        private final K key;
        private final V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
