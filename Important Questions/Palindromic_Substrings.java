import java.util.*;

public class Palindromic_Substrings {
    // Approach 1
    public static boolean checkPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    public static int countSubstring(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (checkPalindrome(s, i, j)) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // Approach 2
    public static int expandFromCentre(String str, int left, int right) {
        int count = 0;
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
            count++;
        }

        return count;
    }

    public static int countSubstring2(String str) {
        int n = str.length();
        if (n <= 1) {
            return n;
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            count += expandFromCentre(str, i, i);
            count += expandFromCentre(str, i, i + 1);
        }

        return count;
    }

    // Approach 3 Using Dynamic Programming
    // Time Complexity: O(n^2) Using Memoisation
    public static int countSubstrings(String s) {
        int ans = 0;
        int dp[][] = new int[s.length()][s.length()];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (isPalindrome(s, i, j, dp)) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static boolean isPalindrome(String str, int i, int j, int dp[][]) {
        if (i >= j) {
            return true;
        }

        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        if (str.charAt(i) == str.charAt(j)) {
            boolean val = isPalindrome(str, i + 1, j - 1, dp);
            if (val) {
                dp[i][j] = 1;
            } else {
                dp[i][j] = 0;
            }

            return val;
        }

        dp[i][j] = 0;
        return false;
    }

    // Using Tabulation Bottom Up
    public static int countSubstrings2(String s) {
        int count = 0;
        int n = s.length();
        boolean dp[][] = new boolean[n][n];

        for (int L = 1; L <= n; L++) {
            for (int i = 0; i + L - 1 < n; i++) {
                int j = i + L - 1;

                if (i == j) {
                    dp[i][i] = true;
                } else if (i + 1 == j) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }

                if (dp[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "aaa";
        System.out.println(countSubstring(str));

        System.out.println(countSubstring2(str));
        System.out.println(countSubstrings(str));
        System.out.println(countSubstrings2(str));
    }
}
