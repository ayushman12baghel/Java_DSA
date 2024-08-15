import java.util.*;

public class Longest_Substring_without_Repeating_Characters {

    public static int longestSubstringWithoutRepeating(String str) {
        int length = 0;
        HashSet<Character> set = new HashSet<>();
        int left = 0;

        // sliding window
        for (int right = 0; right < str.length(); right++) {
            if (!set.contains(str.charAt(right))) {
                set.add(str.charAt(right));
                length = Math.max(length, right - left + 1);
            } else {
                while (set.contains(str.charAt(right))) {
                    set.remove(str.charAt(left));
                    left++;
                }
                set.add(str.charAt(right));
            }
        }

        return length;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";

        System.out.println(longestSubstringWithoutRepeating(str));
    }
}
