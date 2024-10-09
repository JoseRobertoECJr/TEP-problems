import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String inputStr = "";
        
        while (scanner.hasNext()) {
            
            int passwordLength = Integer.parseInt(scanner.next());

            String message = scanner.next();

            Map<String, Integer> substringsCount = new HashMap<>();

            int maxOcc = 0;
            String strMaxOcc = "";

            for (int i = 0; i <= message.length() - passwordLength; i++) {
                
                String substring = message.substring(i, i + passwordLength);
                
                substringsCount.put(substring, substringsCount.getOrDefault(substring, 0) + 1);

                if (substringsCount.get(substring) > maxOcc) {
                    strMaxOcc = substring;
                    maxOcc = substringsCount.get(substring);
                }
            }

            System.out.println(strMaxOcc);
        }

        scanner.close();
    }
}