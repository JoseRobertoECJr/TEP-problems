import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr;

        while (!(inputStr = scanner.nextLine()).equals(".")) {
            int exp = 1;

            for (int i = 1; i <= inputStr.length() / 2; i++) {
                String substring = inputStr.substring(0, i);
                boolean isEqual = true;

                for (int j = i; j < inputStr.length(); j += i) {
                    String substringTest = inputStr.substring(j, j + i);

                    if (!substring.equals(substringTest)) {
                        isEqual = false;
						i = j;
                        break;
                    }
                }

                if (isEqual) {
                    exp = inputStr.length() / i;
                    break;
                }
            }

            System.out.println(exp);
        }

        scanner.close();
    }
}
