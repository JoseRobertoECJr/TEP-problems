import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        StringBuilder resultStr = new StringBuilder();

        int casesQnt = Integer.parseInt(scanner.next());

        for (int i = 0; i < casesQnt; i++) {
            int result = 0;

            int numQnt = Integer.parseInt(scanner.next());
            
            Map<Integer, Integer> listInts = new HashMap<>();
            
            for (int index = 1; index <= numQnt; index++) {
                
                listInts.put(index, Integer.parseInt(scanner.next()));
            }

            for (int j = 1; j < numQnt; j++) {
                for (int k = listInts.get(j) - j % listInts.get(j); k <= numQnt; k += listInts.get(j)) {
                    if (k <= j) continue;

                    int multp = listInts.get(j) * listInts.get(k);

                    if (multp == j + k) result++;
                }
            }

            resultStr.append(result).append("\n");
        }

        System.out.println(resultStr.toString());
    }
}