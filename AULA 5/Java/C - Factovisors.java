import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();

            int mAux = m;
            boolean isDivisible = true;

            for (int i = 2; i * i <= mAux && isDivisible; i++) {
                int count = 0;
                while (mAux % i == 0) {
                    mAux /= i;
                    count++;
                }

                if (count > 0) {
                    isDivisible = IsDivisible(n, i, count);
                }
            }

            if (mAux > 1 && isDivisible) {
                isDivisible = IsDivisible(n, mAux, 1);
            }

            System.out.println(m + (isDivisible ? " divides " : " does not divide ") + n + "!");
        }

        scanner.close();
    }

    public static boolean IsDivisible(int n, int num, int count) {
        for (long numFac = num; n / numFac > 0 && count > 0; numFac *= num) {
            count -= (int) (n / numFac);
        }

        return count <= 0;
    }
}
