import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        String input;
        
        while (!(input = scanner.nextLine()).equals("0 0")) {
            int[] table = Arrays.stream(input.split(" "))
                                .mapToInt(Integer::parseInt)
                                .toArray();
            int m = Math.min(table[0], table[1]);
            int n = Math.max(table[0], table[1]);
            
            if (m == 1) {
                result.append(n).append(" knights may be placed on a ")
                      .append(table[0]).append(" row ").append(table[1])
                      .append(" column board.\n");
                continue;
            }
            
            if (m == 2) {
                int maxKnightsM2 = n + (n % 4 == 3 ? 1 : n % 4);
                result.append(maxKnightsM2).append(" knights may be placed on a ")
                      .append(table[0]).append(" row ").append(table[1])
                      .append(" column board.\n");
                continue;
            }
            
            int maxKnights = (m * n + 1) / 2;
            result.append(maxKnights).append(" knights may be placed on a ")
                  .append(table[0]).append(" row ").append(table[1])
                  .append(" column board.\n");
        }
        System.out.println(result.substring(0, result.length() - 1));
    }
}