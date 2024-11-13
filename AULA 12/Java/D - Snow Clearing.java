import java.util.Scanner;
import java.util.StringTokenizer;
import java.text.DecimalFormat;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++)
        {
            double totalDist = 0;

            int x = scanner.nextInt();
            int y = scanner.nextInt();

            scanner.nextLine();
            
            while (scanner.hasNextLine())
            {
                String lineStr = scanner.nextLine();

                String[] line = lineStr.split(" ");

                if (lineStr.isEmpty()) break;

                x = Integer.parseInt(line[0]);
                y = Integer.parseInt(line[1]);
                int x2 = Integer.parseInt(line[2]);
                int y2 = Integer.parseInt(line[3]);

                totalDist += Math.sqrt((x - x2) * (x - x2) + (y - y2) * (y - y2));
            }

            double totalTime = (totalDist * 2.0 / 1000.0) / 20.0;

            int hours = (int) totalTime;
            int minutes = (int) Math.round((totalTime - (double)hours) * 60);

            System.out.printf("%d:%02d%n", minutes >= 60 ? hours+1 : hours, minutes >= 60 ? 0 : minutes);

            if (testCases > i + 1)
            {
                System.out.println();
            }
        }
    }
}
