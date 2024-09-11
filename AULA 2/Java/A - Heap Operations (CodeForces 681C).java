import java.util.*;

public class Main {
    public static void main(String[] args) {
        StringBuilder result = new StringBuilder();

        Scanner scanner = new Scanner(System.in);
        int numCases = Integer.parseInt(scanner.nextLine());

        TreeMap<Integer, Integer> list = new TreeMap<>();

        for (int i = 0; i < numCases; i++) {
            String commandLineStr = scanner.nextLine();

            if (commandLineStr == null) {
                break;
            }

            String[] commandStr = commandLineStr.split(" ");

            int number = 0;

            String command = commandStr[0];

            if (commandStr.length > 1) {
                number = Integer.parseInt(commandStr[1]);
            }

            if (command.equals("insert")) {
                result = insert(list, number, result);
            } else if (command.equals("removeMin")) {
                if (list.isEmpty()) {
                    result = insert(list, 0, result);
                }
                result = removeMin(list, result);
            } else if (command.equals("getMin")) {
                result = getMin(list, number, result);
            }
        }

        String resultStr = result.toString().trim();

        System.out.println((resultStr.length() > 0 ? resultStr.split("\n").length : 0));
        System.out.println(result);
    }

    public static StringBuilder insert(TreeMap<Integer, Integer> list, int item, StringBuilder result) {
        result.append("insert ").append(item).append("\n");

        list.put(item, list.getOrDefault(item, 0) + 1);

        return result;
    }

    public static StringBuilder removeMin(TreeMap<Integer, Integer> list, StringBuilder result) {
        result.append("removeMin\n");

        Map.Entry<Integer, Integer> min = list.firstEntry();

        if (min.getValue() == 1) {
            list.pollFirstEntry();
        } else {
            list.put(min.getKey(), min.getValue() - 1);
        }

        return result;
    }

    public static StringBuilder getMin(TreeMap<Integer, Integer> list, int item, StringBuilder result) {

        while (!list.isEmpty() && list.firstKey() < item) {
            result = removeMin(list, result);
        }

        if (list.isEmpty() || list.firstKey() != item) {
            result.append("insert ").append(item).append("\n");
            list.put(item, 1);
        }

        result.append("getMin ").append(item).append("\n");

        return result;
    }
}