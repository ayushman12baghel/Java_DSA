import java.util.*;

public class Palindrome_Partitioning_II {

    // Memoisation O(n^2)
    public static int minCut(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int dp2[][] = new int[n][n];
        for (int row[] : dp2) {
            Arrays.fill(row, -1);
        }

        for (int L = 1; L <= n; L++) {
            for (int i = 0; i + L - 1 < n; i++) {
                int j = i + L - 1;

                if (i == j) {
                    dp[i][j] = true;
                } else if (i + 1 == j) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        return solve(s, 0, n - 1, dp, dp2);
    }

    public static int solve(String str, int i, int j, boolean dp[][], int dp2[][]) {
        if (i >= j) {
            return 0;
        }

        if (dp2[i][j] != -1) {
            return dp2[i][j];
        }

        if (dp[i][j]) {
            return dp2[i][j] = 0;
        }

        int cuts = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            if (dp[i][k]) {
                int right = solve(str, k + 1, j, dp, dp2);
                cuts = Math.min(cuts, right + 1);
            }
        }

        return dp2[i][j] = cuts;
    }

    // Tabulation O(n^2)
    public static int minCut2(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];

        for (int L = 1; L <= n; L++) {
            for (int i = 0; i + L - 1 < n; i++) {
                int j = i + L - 1;

                if (i == j) {
                    dp[i][j] = true;
                } else if (i + 1 == j) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        int cuts[] = new int[n];
        Arrays.fill(cuts, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            if (dp[0][i]) {
                cuts[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (dp[j + 1][i]) {
                        cuts[i] = Math.min(cuts[i], cuts[j] + 1);
                    }
                }
            }
        }

        return cuts[n - 1];
    }

    // Approach 2 Expand Around Center O(n^2)
    public static int minCut3(String s) {
        int n = s.length();
        int cuts[] = new int[n];
        Arrays.fill(cuts, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            expand(s, i, i, cuts);
            expand(s, i, i + 1, cuts);
        }

        return cuts[n - 1];
    }

    public static void expand(String str, int left, int right, int cuts[]) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            if (left == 0) {
                cuts[right] = 0;
            } else {
                cuts[right] = Math.min(cuts[right], cuts[left - 1] + 1);
            }

            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        String s = "aab";

        System.out.println(minCut(s));
        System.out.println(minCut2(s));
        System.out.println(minCut3(s));
    }
}
