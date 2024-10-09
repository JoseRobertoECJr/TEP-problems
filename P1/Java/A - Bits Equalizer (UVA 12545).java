import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCases = scanner.nextInt();
        for (int i = 0; i < numCases; i++) {

            String S = scanner.next();
            String T = scanner.next();
            
            int S0 = S.length() - S.replace("0", "").length();
            int S1 = S.length() - S.replace("1", "").length();
            int SX = S.length() - S.replace("?", "").length();
            
            int T0 = T.length() - T.replace("0", "").length();
            int T1 = T.length() - T.replace("1", "").length();
            
            if(T0 > S0 + SX)
            {
                System.out.println("Case " + (i+1) + ": " + "-1");
                continue;
            }
            
            int switchesQnt1 = T1 - S1;
            int switchesQnt0 = T0 - S0;
            
            char[] SC = S.toCharArray();
            char[] TC = T.toCharArray();
            
            int switches = 0;
            for (int j = 0; j < S.length(); j++) {
                if (SC[j] == '?' && TC[j] == '0' && switchesQnt0 > 0) {
                    SC[j] = '0';
                    
                    switchesQnt0--;
                    switches++;
                } else if (SC[j] == '?' && TC[j] == '1' && switchesQnt1 > 0) {
                    SC[j] = '1';
                    
                    switchesQnt1--;
                    switches++;
                }
            }
            
            for (int j = 0; j < S.length(); j++) {
                if (SC[j] == '?' && switchesQnt0 > 0) {
                    SC[j] = '0';
                    
                    switchesQnt0--;
                    switches++;
                } else if (SC[j] == '?' && switchesQnt1 > 0) {
                    SC[j] = '1';
                    
                    switchesQnt1--;
                    switches++;
                }
            }
            
            for (int j = 0; j < S.length() && switchesQnt1 > 0; j++) {
                if (SC[j] == '0' && TC[j] == '1') {
                    SC[j] = '1';
                    
                    switchesQnt1--;
                    switches++;
                }
            }
            
            
            for (int j = 0; j < S.length() && switchesQnt1 > 0; j++) {
                if (SC[j] == '0') {
                    SC[j] = '1';
                    
                    switchesQnt1--;
                    switches++;
                }
            }
            
            int strSwitches = 0;
            for (int j = 0; j < S.length(); j++) {
                if(SC[j] != TC[j]) strSwitches++;
            }
            
            System.out.println("Case " + (i+1) + ": " + (switches + strSwitches/2));

        }

        
        scanner.close();
    }
}
