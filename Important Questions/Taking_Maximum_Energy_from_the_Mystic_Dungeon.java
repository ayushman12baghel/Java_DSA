import java.util.*;

//Approach 1 Using Memoisation O(n)
class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int result = Integer.MIN_VALUE;
        int dp[] = new int[energy.length];
        Arrays.fill(dp, Integer.MIN_VALUE);

        for (int start = 0; start < energy.length; start++) {
            result = Math.max(result, solve(energy, start, k, dp));
        }

        return result;
    }

    public int solve(int energy[], int index, int k, int dp[]) {
        if (index >= energy.length) {
            return 0;
        }

        if (dp[index] != Integer.MIN_VALUE) {
            return dp[index];
        }

        return dp[index] = energy[index] + solve(energy, index + k, k, dp);
    }
}

// Approach 2 Bottom Up O(n)
class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n = energy.length;
        int result = Integer.MIN_VALUE;

        int dp[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            if (i + k < n) {
                dp[i] = energy[i] + dp[i + k];
            } else {
                dp[i] = energy[i];
            }

            result = Math.max(result, dp[i]);
        }

        return result;
    }
}