import java.util.*;

public class Longest_Palindromic_Substring {

    // Approach 1 Brute Force Memoisation O(n^2)
    public static String longestPalindrome(String s) {
        int n = s.length();
        String ans = "";
        Boolean dp[][] = new Boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j, dp) && j - i + 1 > ans.length()) {
                    ans = s.substring(i, j + 1);
                }
            }
        }

        return ans;
    }

    private static boolean isPalindrome(String s, int i, int j, Boolean dp[][]) {
        if (i >= j)
            return true;

        if (dp[i][j] != null)
            return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = isPalindrome(s, i + 1, j - 1, dp);
        } else {
            dp[i][j] = false;
        }

        return dp[i][j];
    }

    // Approach 2 Using BluePrint Tabulation O(n^2)
    public static String longestPalindrome2(String s) {
        int n = s.length();

        String ans = "";
        boolean dp[][] = new boolean[n + 1][n + 1];

        for (int L = 1; L <= n; L++) {
            for (int i = 0; i + L - 1 < n; i++) {
                int j = i + L - 1;
                if (i == j) {
                    dp[i][j] = true;
                } else if (i + 1 == j) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) ? true : false);
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }

                if (dp[i][j] && ans.length() < j - i + 1) {
                    ans = s.substring(i, j + 1);
                }
            }
        }

        return ans;
    }

    // Approach 3 Using Expand From Center O(n^2)
    public static String longestPalindrome3(String s) {
        int n = s.length();
        String ans = "";

        for (int i = 0; i < n; i++) {
            String odd = expand(s, i, i);
            String even = expand(s, i, i + 1);

            if (odd.length() > ans.length()) {
                ans = odd;
            }
            if (even.length() > ans.length()) {
                ans = even;
            }
        }

        return ans;
    }

    public static String expand(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }

        return str.substring(left + 1, right);
    }

    public static void main(String args[]) {
        String s = "babad";

        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome2(s));
        System.out.println(longestPalindrome3(s));
    }
}
