import java.util.*;

public class Longest_Unequal_Adjacent_Groups_Subsequences_II {

    // Using LIS Pattern
    public static List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        int dp[] = new int[n];
        int parent[] = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);
        int maxLength = 1;
        int longestSubIndex = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] != groups[j] && words[i].length() == words[j].length()
                        && hammingDistance(words[i], words[j])) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                        parent[i] = j;
                        if (maxLength < dp[i]) {
                            maxLength = dp[i];
                            longestSubIndex = i;
                        }
                    }
                }
            }
        }

        List<String> result = new ArrayList<>();

        while (longestSubIndex != -1) {
            result.add(words[longestSubIndex]);
            longestSubIndex = parent[longestSubIndex];
        }

        Collections.reverse(result);

        return result;
    }

    public static boolean hammingDistance(String str1, String str2) {
        int diff = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diff += 1;
            }
        }

        if (diff > 1) {
            return false;
        }

        return diff == 1;
    }

    public static void main(String args[]) {
        String words[] = { "bab", "dab", "cab" };
        int[] groups = { 1, 2, 2 };

        System.out.println(getWordsInLongestSubsequence(words, groups));
    }
}
