import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        
        Map<Character, Character> simbolDict = new HashMap<>();
        simbolDict.put('[', ']');
        simbolDict.put('(', ')');
        
        int numCases = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < numCases; i++) {
            List<Character> seqQueue = new ArrayList<>();
            String sequenceStr = scanner.nextLine();
            char[] sequence = sequenceStr.toCharArray();
            
            if (sequenceStr.isEmpty()) {
                result.append("Yes\n");
                continue;
            }
            
            boolean isRight = true;
            for (char simbol : sequence) {
                if (simbol == '(' || simbol == '[') {
                    seqQueue.add(simbol);
                } else if ((simbol == ')' || simbol == ']') && (seqQueue.isEmpty() || simbolDict.get(seqQueue.remove(seqQueue.size() - 1)) != simbol)) {
                    isRight = false;
                    break;
                }
            }
            
            result.append(isRight && seqQueue.isEmpty() ? "Yes\n" : "No\n");
        }
        
        System.out.print(result.toString());
        scanner.close();
    }
}