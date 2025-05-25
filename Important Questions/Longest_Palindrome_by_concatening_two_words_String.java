import java.util.*;

public class Longest_Palindrome_by_concatening_two_words_String {

    public static int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int ans = 0;

        for (String word : words) {
            String reverse = "" + word.charAt(1) + word.charAt(0);

            if (map.containsKey(reverse) && map.get(reverse) > 0) {
                ans += 4;
                map.put(reverse, map.get(reverse) - 1);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String current = entry.getKey();

            if (entry.getValue() > 0 && current.charAt(0) == current.charAt(1)) {
                ans += 2;
                break;
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        String words[] = { "lc", "cl", "gg" };
        System.out.println(longestPalindrome(words));
    }
}
