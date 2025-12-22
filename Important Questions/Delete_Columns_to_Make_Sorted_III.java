import java.util.*;

//O(n*m*m)
class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        int dp[] = new int[m];
        Arrays.fill(dp, 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < i; j++) {
                boolean valid = true;
                for (int k = 0; k < n; k++) {
                    String str = strs[k];

                    if (str.charAt(j) > str.charAt(i)) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = 1;
        for (int i = 0; i < dp.length; i++) {
            maxLength = Math.max(dp[i], maxLength);
        }

        return m - maxLength;
    }
}