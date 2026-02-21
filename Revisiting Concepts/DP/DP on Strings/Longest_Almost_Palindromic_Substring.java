import java.util.*;

// Approach 1 Using Expand From Middle O(n^2) with O(1) Space
class Solution {
    public int almostPalindromic(String s) {
        int n = s.length();
        int ans = 1;

        for (int i = 0; i < n; i++) {
            int odd = expand(s, i, i);
            int even = expand(s, i, i + 1);

            ans = Math.max(ans, Math.max(odd, even));
        }

        return ans;
    }

    public int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        int maxLength = right - left - 1;

        // Skip from left
        if (left >= 0) {
            int l1 = left - 1;
            int r1 = right;

            while (l1 >= 0 && r1 < s.length() && s.charAt(l1) == s.charAt(r1)) {
                l1--;
                r1++;
            }

            maxLength = Math.max(maxLength, r1 - l1 - 1);
        }

        // Skip from right
        if (right < s.length()) {
            int l2 = left;
            int r2 = right + 1;

            while (l2 >= 0 && r2 < s.length() && s.charAt(l2) == s.charAt(r2)) {
                l2--;
                r2++;
            }

            maxLength = Math.max(maxLength, r2 - l2 - 1);
        }

        return maxLength;
    }
}

// Approach 2 With K Deletions DP Tabulation Time O(n^2) With O(n^2) Space
class Solution {
    public int almostPalindromic(String s) {
        return longestPalindromeWithKDeletions(s, 1);
    }

    public int longestPalindromeWithKDeletions(String s, int k) {
        int n = s.length();

        int dp[][] = new int[n][n];
        int maxLength = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);
                }

                if (dp[i][j] <= k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }
}