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

    public static int longestSubstringWithoutRepeating2(String str) {
        int start = 0;
        int end = 0;
        int maxLen = 0;
        List<Character> list = new ArrayList<>();

        while (end < str.length()) {
            if (!list.contains(str.charAt(end))) {
                list.add(str.charAt(end));
                end++;
                maxLen = Math.max(list.size(), maxLen);
            } else {
                list.remove(Character.valueOf(str.charAt(start)));
                start++;
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";

        System.out.println(longestSubstringWithoutRepeating(str));
        System.out.println(longestSubstringWithoutRepeating2(str));
    }
}
