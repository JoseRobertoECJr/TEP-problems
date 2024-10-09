import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();

            char[] wordChrs = word.toCharArray();
            Arrays.sort(wordChrs);

            do {
                System.out.println(new String(wordChrs));
            } while (nextPermutation(wordChrs));

            System.out.println("");
        }

        scanner.close();
    }

    public static boolean nextPermutation(char[] array) {
        int i = array.length - 2;
        while (i >= 0 && Character.compare(array[i], array[i + 1]) >= 0) {
            i--;
        }

        if (i < 0) {
            return false;
        }

        int j = array.length - 1;
        while (Character.compare(array[i], array[j]) >= 0) {
            j--;
        }

        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        int start = i + 1;
        int end = array.length - 1;

        while (start < end) {
            temp = array[start];
            array[start] = array[end];
            array[end] = temp;

            start++;
            end--;
        }

        return true;
    }
}
