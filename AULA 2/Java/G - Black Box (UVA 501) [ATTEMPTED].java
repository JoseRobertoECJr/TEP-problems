import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();

        int numCases = Integer.parseInt(scanner.nextLine());

        for (int j = 0; j < numCases; j++) {
            scanner.nextLine(); // blank line
            int dataSetsNum = Integer.parseInt(scanner.next()); // number of data
			int getsNum = Integer.parseInt(scanner.next());
			
			ArrayList<String> dataSet = new ArrayList<>();

			for(int n = 0; n < dataSetsNum; n++)
			{
				dataSet.add(scanner.next());
			}
			
			ArrayList<String> gets = new ArrayList<>();

			for(int n = 0; n < getsNum; n++)
			{
				gets.add(scanner.next());
			}
			
            LinkedList<Integer> blackBox = new LinkedList<>();
            int i = 0;


            int numberOfADD = 0;
            for (String data : dataSet) {
                int numberToADD = Integer.parseInt(data);

                addBefore(blackBox, numberToADD);

                numberOfADD++;

                while (!gets.isEmpty() && Integer.parseInt(gets.get(0)) == numberOfADD) {
                    gets.remove(0);

                    result.append(blackBox.get(i)).append("\n");

                    i++;
                }
            }
            result.append("\n");
        }

        System.out.print(result.substring(0, result.length() - 1));
    }

    public static void addBefore(LinkedList<Integer> list, int item) {
        ListIterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (iterator.next() > item) {
                iterator.previous();
                iterator.add(item);
                return;
            }
        }

        list.addLast(item);
    }
}