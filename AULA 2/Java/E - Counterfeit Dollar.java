import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        
        int numCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < numCases; i++) {
            Map<Character, Boolean> dollars = new HashMap<>();
            for (char c = 'A'; c <= 'L'; c++) {
                dollars.put(c, false);
            }

            List<Weighing> weighings = new ArrayList<>();

            for (int j = 0; j < 3; j++) {
                String[] weighingInput = scanner.nextLine().split(" ");
                
                int leftSide = "down".equals(weighingInput[2]) ? 1 : 0;
                int rightSide = "down".equals(weighingInput[2]) ? 0 : 1;
                String balance = "down".equals(weighingInput[2]) ? "up" : weighingInput[2];

                Weighing weighing = new Weighing(
                    new HashSet<>(toCharacterSet(weighingInput[leftSide])),
                    new HashSet<>(toCharacterSet(weighingInput[rightSide])),
                    balance
                );
                
                weighings.add(weighing);
            }

            int index = 0;
            for (Weighing weighing : weighings) {
                if ("even".equals(weighing.balance)) {
                    for (char dollar : weighing.leftSide) {
                        dollars.put(dollar, true);
                    }
                    for (char dollar : weighing.rightSide) {
                        dollars.put(dollar, true);
                    }
                } else {
                    Set<Character> doubt = union(weighing.leftSide, weighing.rightSide);

                    for (Map.Entry<Character, Boolean> dollar : dollars.entrySet()) {
                        if (!doubt.contains(dollar.getKey())) {
                            dollars.put(dollar.getKey(), true);
                        }
                    }

                    int index2 = 0;
                    for (Weighing weighing2 : weighings) {
                        if (index == index2 || "even".equals(weighing2.balance)) {
                            index2++;
                            continue;
                        }

                        for (char item : unionMinusIntersection(weighing.leftSide, weighing2.leftSide)) {
                            dollars.put(item, true);
                        }

                        for (char item : unionMinusIntersection(weighing.rightSide, weighing2.rightSide)) {
                            dollars.put(item, true);
                        }

                        index2++;
                    }
                }
                index++;
            }

            char falseDollar = dollars.entrySet().stream()
                .filter(d -> !d.getValue())
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);

            String falseDollarWeigh = "";
            for (Weighing weighing : weighings) {
                if (!"up".equals(weighing.balance)) continue;

                falseDollarWeigh = weighing.leftSide.contains(falseDollar) ? "heavy" : "light";
            }

            result.append(falseDollar).append(" is the counterfeit coin and it is ").append(falseDollarWeigh).append(".\n");
        }

        System.out.print(result.toString());
        scanner.close();
    }

    public static Set<Character> unionMinusIntersection(Set<Character> set1, Set<Character> set2) {
        Set<Character> unionMinusIntersection = new HashSet<>(set1);
        unionMinusIntersection.addAll(set2);

        Set<Character> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);

        unionMinusIntersection.removeAll(intersection);

        return unionMinusIntersection;
    }

    public static Set<Character> union(Set<Character> set1, Set<Character> set2) {
        Set<Character> union = new HashSet<>(set1);
        union.addAll(set2);

        return union;
    }

    public static Set<Character> toCharacterSet(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        return set;
    }

    static class Weighing {
        Set<Character> leftSide;
        Set<Character> rightSide;
        String balance;

        Weighing(Set<Character> leftSide, Set<Character> rightSide, String balance) {
            this.leftSide = leftSide;
            this.rightSide = rightSide;
            this.balance = balance;
        }
    }
}