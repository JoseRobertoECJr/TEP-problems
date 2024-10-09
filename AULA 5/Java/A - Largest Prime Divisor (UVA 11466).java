import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long N;

        while ((N = scanner.nextLong()) != 0) {

            // Tratando numeros negativos
            if (N < 0) N *= -1;

            long largestPrimeDiv = -1;
            int count = 0;

            for (long i = 2; i * i <= N && N != 1; i++) {
                while (N % i == 0) {
                    N /= i;
                    largestPrimeDiv = i;
                }

                if (largestPrimeDiv == i) count++;
            }

            if (N != 1 && largestPrimeDiv != -1) {
                largestPrimeDiv = N;
            } else if (count == 1) {
                largestPrimeDiv = -1;
            }

            System.out.println(largestPrimeDiv);
        }

        scanner.close();
    }
}
