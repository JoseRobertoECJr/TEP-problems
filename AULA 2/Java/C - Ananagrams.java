import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>();
        String wordsStr;

        while (!(wordsStr = scanner.nextLine()).equals("#")) {
            words.addAll(Arrays.asList(wordsStr.split(" ")));
        }

        List<String> relativeAnagrams = new ArrayList<>();

        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).length() == 1) {
                relativeAnagrams.add(words.get(i));
                continue;
            }

            char[] word1Array = words.get(i).toUpperCase().toCharArray();
            Arrays.sort(word1Array);
            String word1 = new String(word1Array);

            boolean isAnagram = false;
            for (int j = 0; j < words.size(); j++) {
                if (i != j && words.get(i).length() == words.get(j).length()) {
                    char[] word2Array = words.get(j).toUpperCase().toCharArray();
                    Arrays.sort(word2Array);
                    String word2 = new String(word2Array);

                    if (word1.equals(word2)) {
                        isAnagram = true;
                        break;
                    }
                }
            }

            if (!isAnagram) {
                relativeAnagrams.add(words.get(i));
            }
        }

        Collections.sort(relativeAnagrams);
        for (String relativeAnagram : relativeAnagrams) {
            System.out.println(relativeAnagram);
        }
    }
}