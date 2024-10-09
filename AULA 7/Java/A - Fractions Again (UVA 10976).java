import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext())
        {
            int k = scanner.nextInt();

            List<Pair> pairs = new ArrayList<>();

            for (int i = k + 1; i <= k * 2; i++)
            {
                if ((k * i) % (i - k) == 0)
                {
                    pairs.add(new Pair((k * i) / (i - k), i));
                }
            }

            System.out.println(pairs.size());

            for (Pair pair : pairs)
            {
                System.out.printf("1/%d = 1/%d + 1/%d\n", k, pair.x, pair.y);
            }
        }

        scanner.close();
    }

    static class Pair
    {
        int x;
        int y;

        public Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}
