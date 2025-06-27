import java.util.*;

public class Palindromic_Substrings {

    // Approach 1 Using Memoisation // Not Efficient O(n^3)
    public static int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        Boolean dp[][] = new Boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j, dp)) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean isPalindrome(String str, int i, int j, Boolean dp[][]) {
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int left = i;
        int right = j;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return dp[i][j] = false;
            }

            left++;
            right--;
        }

        return dp[i][j] = true;
    }

    // Approach 2 Palindromic Substrings BluePrint Bottom Up O(n^2)
    public static int countSubstrings2(String s) {
        int n = s.length();
        boolean dp[][] = new boolean[n][n];
        int count = 0;

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

                if (dp[i][j] == true) {
                    count++;
                }
            }
        }

        return count;
    }

    // Approach 3 O(n^2) -> Expand From Center
    public static int countSubstrings3(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            count += expand(s, i, i);
            count += expand(s, i, i + 1);
        }

        return count;
    }

    public static int expand(String str, int left, int right) {
        int count = 0;

        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        String str = "aaa";

        System.out.println(countSubstrings(str));
        System.out.println(countSubstrings2(str));
        System.out.println(countSubstrings3(str));
    }
}
