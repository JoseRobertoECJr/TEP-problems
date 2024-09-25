import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long nBulbs;
        
        while ((nBulbs = scanner.nextLong()) != 0) {
            System.out.println(Math.sqrt(nBulbs) % 1 == 0 ? "yes" : "no");
        }
        
        scanner.close();
    }
}
