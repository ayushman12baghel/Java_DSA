import java.util.*;

// Approach 1 Memoisation O(n*capacity)
class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
        int dp[][] = new int[val.length][capacity + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(val, wt, 0, capacity, dp);
    }

    public int solve(int nums[], int weight[], int index, int capacity, int dp[][]) {
        if (index >= nums.length || capacity == 0) {
            return 0;
        }

        if (dp[index][capacity] != -1) {
            return dp[index][capacity];
        }

        int result = 0;
        if (weight[index] <= capacity) {
            int take = solve(nums, weight, index, capacity - weight[index], dp) + nums[index];
            result = take;
        }

        result = Math.max(result, solve(nums, weight, index + 1, capacity, dp));

        return dp[index][capacity] = result;
    }
}

// Approach 2 Tabulation O(n*capacity)
class Solution {
    public int knapSack(int value[], int weight[], int capacity) {
        int n = value.length;
        int dp[][] = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int c = 0; c <= capacity; c++) {
                int result = 0;

                if (weight[i - 1] <= c) {
                    result = dp[i][c - weight[i - 1]] + value[i - 1];
                }

                result = Math.max(dp[i - 1][c], result);

                dp[i][c] = result;
            }
        }

        return dp[n][capacity];
    }
}

// Approach 3 Space Optimised O(n*capacity)
class Solution {
    public int knapSack(int value[], int weight[], int capacity) {
        int n = value.length;
        int dp[] = new int[capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int c = 0; c <= capacity; c++) {
                int result = 0;

                if (weight[i - 1] <= c) {
                    result = dp[c - weight[i - 1]] + value[i - 1];
                }

                result = Math.max(dp[c], result);

                dp[c] = result;
            }
        }

        return dp[capacity];
    }
}