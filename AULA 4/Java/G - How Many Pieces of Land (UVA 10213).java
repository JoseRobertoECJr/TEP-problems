import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int s = Integer.parseInt(scanner.next());

        for (int i = 0; i < s; i++) {
            BigInteger n = new BigInteger(scanner.next());
            
            BigInteger B1 = BigInteger.valueOf(1);
            BigInteger B2 = BigInteger.valueOf(2);
            BigInteger B3 = BigInteger.valueOf(3);
            BigInteger B24 = BigInteger.valueOf(24);
            

            BigInteger maxPieces = ((n
                        .multiply(n.subtract(B1))
                        .multiply(n.subtract(B2))
                        .multiply(n.subtract(B3))
                    ).divide(B24)
                ).add((
                        n.multiply(n.subtract(B3))
                    ).divide(B2)
                ).add(n).add(B1);
                
            System.out.println(maxPieces);
        }

        scanner.close();
    }
}