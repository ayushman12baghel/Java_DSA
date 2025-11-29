import java.util.*;

//Approach 1 Memoisation O(n*k)
class Solution {
    public int maxProfit(int k, int[] prices) {
        int dp[][][] = new int[prices.length][2][k + 1];
        for (int plane[][] : dp) {
            for (int row[] : plane) {
                Arrays.fill(row, -1);
            }
        }

        return solve(prices, 0, 1, 0, k, dp);
    }

    public int solve(int nums[], int index, int canBuy, int count, int k, int dp[][][]) {
        if (index >= nums.length || count >= k) {
            return 0;
        }
        if (dp[index][canBuy][count] != -1) {
            return dp[index][canBuy][count];
        }
        int ans = solve(nums, index + 1, canBuy, count, k, dp);
        if (canBuy == 1) {
            ans = Math.max(ans, -nums[index] + solve(nums, index + 1, 0, count, k, dp));
        } else {
            ans = Math.max(ans, nums[index] + solve(nums, index + 1, 1, count + 1, k, dp));
        }

        return dp[index][canBuy][count] = ans;
    }
}

// Approach 2 Bottom Up O(n)
class Solution {
    public int maxProfit(int k, int[] nums) {
        int n = nums.length;
        int dp[][][] = new int[n + 1][2][k + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int canBuy = 0; canBuy < 2; canBuy++) {
                for (int count = 0; count < k; count++) {
                    int ans = dp[i + 1][canBuy][count];

                    if (canBuy == 1) {
                        ans = Math.max(ans, -nums[i] + dp[i + 1][0][count]);
                    } else {
                        ans = Math.max(ans, nums[i] + dp[i + 1][1][count + 1]);
                    }

                    dp[i][canBuy][count] = ans;
                }
            }
        }

        return dp[0][1][0];
    }
}