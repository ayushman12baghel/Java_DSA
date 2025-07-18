import java.util.*;

public class Word_Break {

    // Approach 1 Memoisation O(n^2)
    public static boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(s, 0, set, dp);
    }

    public static boolean solve(String s, int index, Set<String> set, int dp[]) {
        if (index >= s.length()) {
            return true;
        }

        if (dp[index] != -1) {
            return dp[index] == 1 ? true : false;
        }

        for (int i = index; i < s.length(); i++) {
            String split = s.substring(index, i + 1);

            if (set.contains(split) && solve(s, i + 1, set, dp)) {
                dp[index] = 1;
                return true;
            }
        }

        dp[index] = 0;
        return false;
    }

    // Approach 2 Tabulation O(n^2)
    public static boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> set = new HashSet<>(wordDict);
        boolean dp[] = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                String split = s.substring(j, i);
                if (dp[j] && set.contains(split)) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");

        System.out.println(wordBreak(s, wordDict));
        System.out.println(wordBreak2(s, wordDict));
    }
}
