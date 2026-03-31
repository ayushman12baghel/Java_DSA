import java.util.*;

//Approach 1 Using Memoisation O(n)
class Solution {
    public int maxProfit(int arr[], int k) {
        int dp[][] = new int[arr.length][2];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(arr, 0, k, true, dp);
    }

    public int solve(int nums[], int index, int k, boolean canBuy, int dp[][]) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index][canBuy ? 1 : 0] != -1) {
            return dp[index][canBuy ? 1 : 0];
        }

        int result = 0;

        if (canBuy) {
            int take = solve(nums, index + 1, k, false, dp) - nums[index] - k;
            int notTake = solve(nums, index + 1, k, canBuy, dp);

            result = Math.max(take, notTake);
        } else {
            int sell = nums[index] + solve(nums, index + 1, k, true, dp);
            int skip = solve(nums, index + 1, k, false, dp);

            result = Math.max(sell, skip);
        }

        return dp[index][canBuy ? 1 : 0] = result;
    }
}

// Approach 2 Tabulation O(n)
class Solution {
    public int maxProfit(int nums[], int k) {
        int n = nums.length;

        int dp[][] = new int[nums.length + 1][2];

        for (int i = n - 1; i >= 0; i--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                int result = 0;

                if (canBuy == 1) {
                    int take = dp[i + 1][0] - nums[i] - k;
                    int skip = dp[i + 1][1];
                    result = Math.max(take, skip);
                } else {
                    int sell = dp[i + 1][1] + nums[i];
                    int skip = dp[i + 1][0];
                    result = Math.max(sell, skip);
                }

                dp[i][canBuy] = result;
            }
        }

        return dp[0][1];
    }

    public int solve(int nums[], int index, int k, boolean canBuy, int dp[][]) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index][canBuy ? 1 : 0] != -1) {
            return dp[index][canBuy ? 1 : 0];
        }

        int result = 0;

        if (canBuy) {
            int take = solve(nums, index + 1, k, false, dp) - nums[index] - k;
            int notTake = solve(nums, index + 1, k, canBuy, dp);

            result = Math.max(take, notTake);
        } else {
            int sell = nums[index] + solve(nums, index + 1, k, true, dp);
            int skip = solve(nums, index + 1, k, false, dp);

            result = Math.max(sell, skip);
        }

        return dp[index][canBuy ? 1 : 0] = result;
    }
}

// Approach 3 Optimal Without Space O(n)
class Solution {
    public int maxProfit(int nums[], int k) {
        int n = nums.length;

        int futureBuy = 0;
        int futureSell = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int canBuy = 0; canBuy <= 1; canBuy++) {
                int result = 0;

                if (canBuy == 1) {
                    int take = futureSell - nums[i] - k;
                    int skip = futureBuy;

                    result = Math.max(take, skip);
                } else {
                    int sell = futureBuy + nums[i];
                    int skip = futureSell;
                    result = Math.max(sell, skip);
                }

                if (canBuy == 1) {
                    futureBuy = result;
                } else {
                    futureSell = result;
                }
            }
        }

        return futureBuy;
    }
}
