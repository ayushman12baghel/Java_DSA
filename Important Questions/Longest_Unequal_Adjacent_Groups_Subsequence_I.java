import java.util.*;

public class Longest_Unequal_Adjacent_Groups_Subsequence_I {

    // Brute Force
    public static List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            List<String> temp = new ArrayList<>();
            temp.add(words[i]);

            for (int j = i + 1; j < words.length; j++) {
                if (groups[j - 1] != groups[j]) {
                    temp.add(words[j]);
                }
            }

            if (temp.size() > ans.size()) {
                ans = temp;
            }
        }

        return ans;
    }

    // Greedy Approach
    public static List<String> getLongestSubsequence2(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (groups[i] != groups[i - 1]) {
                ans.add(words[i]);
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        String words[] = { "a", "b", "c", "d" };
        int[] groups = { 1, 0, 1, 1 };

        System.out.println(getLongestSubsequence(words, groups));
        System.out.println(getLongestSubsequence2(words, groups));
    }
}
