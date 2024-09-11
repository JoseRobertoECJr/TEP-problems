import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Character, Character> reverseDict = new HashMap<>();
        reverseDict.put('A', 'A');
        reverseDict.put('E', '3'); reverseDict.put('3', 'E');
        reverseDict.put('H', 'H');
        reverseDict.put('I', 'I');
        reverseDict.put('J', 'L'); reverseDict.put('L', 'J');
        reverseDict.put('M', 'M');
        reverseDict.put('O', 'O');
        reverseDict.put('S', '2'); reverseDict.put('2', 'S');
        reverseDict.put('T', 'T');
        reverseDict.put('U', 'U');
        reverseDict.put('V', 'V');
        reverseDict.put('W', 'W');
        reverseDict.put('X', 'X');
        reverseDict.put('Y', 'Y');
        reverseDict.put('Z', '5'); reverseDict.put('5', 'Z');
        reverseDict.put('1', '1');
        reverseDict.put('8', '8');

        Scanner scanner = new Scanner(System.in);
        String result = "";

        while (scanner.hasNext()) {
            
            String word = scanner.next();
            
            boolean isPalindrome = true;
            boolean isMirrored = true;
            List<Character> chars = new ArrayList<>();
            for (char c : word.toCharArray()) {
                chars.add(c);
            }
            int wordLength = chars.size();

            while (!chars.isEmpty()) {
                if (chars.size() >= 2) {
                    char firstChar = shift(chars);
                    char lastChar = pop(chars);

                    isPalindrome = !isPalindrome ? false : firstChar == lastChar;
                    isMirrored = !isMirrored ? false : reverseDict.containsKey(firstChar) && reverseDict.get(firstChar) == lastChar;
                } else if (chars.size() == 1) {
                    char lastChar = pop(chars);
                    isMirrored = !isMirrored ? false : reverseDict.containsKey(lastChar) && reverseDict.get(lastChar) == lastChar;
                }
            }

            result += word
                    + (!isPalindrome && !isMirrored ? " -- is not a palindrome." : "")
                    + (isPalindrome && !isMirrored ? " -- is a regular palindrome." : "")
                    + (!isPalindrome && isMirrored ? " -- is a mirrored string." : "")
                    + (isPalindrome && isMirrored ? " -- is a mirrored palindrome." : "")
                    + "\n\n";
        }

        System.out.print(result);
    }

    public static char pop(List<Character> list) {
        char result = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return result;
    }

    public static char shift(List<Character> list) {
        char result = list.get(0);
        list.remove(0);
        return result;
    }
}
