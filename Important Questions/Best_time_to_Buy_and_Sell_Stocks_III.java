import java.util.*;

//Approach Using Memoisation O(n)
class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length][2][2];
        for (int plane[][] : dp) {
            for (int row[] : plane) {
                Arrays.fill(row, -1);
            }
        }

        return solve(prices, 0, 1, 0, dp);
    }

    public int solve(int nums[], int index, int canBuy, int count, int dp[][][]) {
        if (index >= nums.length || count >= 2) {
            return 0;
        }
        if (dp[index][canBuy][count] != -1) {
            return dp[index][canBuy][count];
        }
        int ans = solve(nums, index + 1, canBuy, count, dp);
        if (canBuy == 1) {
            ans = Math.max(ans, -nums[index] + solve(nums, index + 1, 0, count, dp));
        } else {
            ans = Math.max(ans, nums[index] + solve(nums, index + 1, 1, count + 1, dp));
        }

        return dp[index][canBuy][count] = ans;
    }
}

// Approach 2 Bottom UP O(n)
class Solution {
    public int maxProfit(int[] nums) {
        int n = nums.length;
        int dp[][][] = new int[n + 1][2][3];

        for (int i = n - 1; i >= 0; i--) {
            for (int canBuy = 0; canBuy < 2; canBuy++) {
                for (int count = 0; count < 2; count++) {
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