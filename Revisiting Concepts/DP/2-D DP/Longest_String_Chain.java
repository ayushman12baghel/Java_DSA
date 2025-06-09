import java.util.*;

public class Longest_String_Chain {

    // Approach 1 -> By Memoisation
    public static int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        int dp[][] = new int[n][n + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(words, 0, -1, dp);
    }

    public static int solve(String words[], int index, int prevIndex, int dp[][]) {
        if (index >= words.length) {
            return 0;
        }

        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }

        int take = 0;
        if (prevIndex == -1 || isPredecessor(words[index], words[prevIndex])) {
            take = solve(words, index + 1, index, dp) + 1;
        }

        int notTake = solve(words, index + 1, prevIndex, dp);

        return dp[index][prevIndex + 1] = Math.max(take, notTake);
    }

    public static boolean isPredecessor(String longer, String shorter) {
        if (longer.length() != shorter.length() + 1) {
            return false;
        }

        int j = 0;
        int i = 0;
        while (i < longer.length()) {
            if (j < shorter.length() && longer.charAt(i) == shorter.charAt(j)) {
                j++;
            }

            i++;
        }

        return j == shorter.length();
    }

    // Approach 2 -> By Tabulation
    public static int longestStrChain2(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isPredecessor(words[i], words[j])) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }

        return max;
    }

    public static void main(String args[]) {
        String words[] = { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" };

        System.out.println(longestStrChain(words));
        System.out.println(longestStrChain2(words));
    }
}
