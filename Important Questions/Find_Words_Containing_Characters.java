import java.util.*;

public class Find_Words_Containing_Characters {

    // Approach 1 -> Using different Function
    public static List<Integer> findWordsContaining(String words[], char x) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String current = words[i];

            if (find(current, x)) {
                result.add(i);
            }
        }

        return result;
    }

    public static boolean find(String current, char x) {
        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) == x) {
                return true;
            }
        }

        return false;
    }

    // Approach 2 -> recommended
    public static List<Integer> findWordsContaining2(String[] words, char x) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String current = words[i];

            if (current.indexOf(x) != -1) {
                result.add(i);
            }
        }

        return result;
    }

    // Approach 3 -> Using lambda function
    public static List<Integer> findWordsContaining3(String[] words, char x) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String current = words[i];

            if (words[i].chars().anyMatch(ch -> ch == x)) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String args[]) {
        String words[] = { "abc", "bcd", "aaaa", "cbc" };
        char x = 'a';

        System.out.println(findWordsContaining(words, x));
        System.out.println(findWordsContaining2(words, x));
        System.out.println(findWordsContaining3(words, x));
    }
}
