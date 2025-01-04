import java.util.HashSet;
import java.util.Set;

public class Unique_Length_3_palindrome {
    public static int countPalindromicSubsequence(String s) {
        int ans = 0;
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }

        for (char c : set) {
            int left = -1;
            int right = -1;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == c) {
                    if (left == -1) {
                        left = i;
                    }
                    right = i;
                }
            }

            Set<Character> middle = new HashSet<>();
            for (int i = left + 1; i < right; i++) {
                middle.add(s.charAt(i));
            }
            ans += middle.size();
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "aabca";

        System.out.println(countPalindromicSubsequence(s));
    }
}
