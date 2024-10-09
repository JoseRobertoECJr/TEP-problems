import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int max = 65000;
        List<Boolean> primeList = calcPrimes(max);

        Scanner scanner = new Scanner(System.in);
        String input;
        while (!(input = scanner.nextLine()).equals("0")) {
            int n = Integer.parseInt(input);

            boolean isPossiblePrime = true;

            for (int i = 2; i < n && !primeList.get(n); i++) {
                if (fermatTest(i, n, n) != i) {
                    isPossiblePrime = false;
                    break;
                }
            }

            if (isPossiblePrime && !primeList.get(n)) {
                System.out.println("The number " + n + " is a Carmichael number.");
            } else {
                System.out.println(n + " is normal.");
            }
        }

        scanner.close();
    }

    public static List<Boolean> calcPrimes(int max) {
        List<Boolean> primeList = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            primeList.add(i != 0 && i != 1);
        }

        for (int i = 2; i < max / 2; i++) {
            if (primeList.get(i)) {
                for (int j = 2 * i; j < max; j += i) {
                    primeList.set(j, false);
                }
            }
        }

        return primeList;
    }

    public static long fermatTest(int a, int n, int m) {
        if (n == 0) {
            return 1;
        } else {
            if (n % 2 == 0) {
                long temp = fermatTest(a, n / 2, m);
                return (temp * temp) % m;
            } else {
                return (fermatTest(a, n - 1, m) * (a % m)) % m;
            }
        }
    }
}