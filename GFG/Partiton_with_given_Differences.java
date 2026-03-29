import java.util.*;

//Approach 1 Memoisation O(n*totalSUm)
class Solution {
    public int countPartitions(int[] nums, int diff) {
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        int dp[][] = new int[nums.length][totalSum + 1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums, 0, 0, totalSum, diff, dp);
    }

    public int solve(int nums[], int index, int currentSum, int totalSum, int diff, int dp[][]) {
        if (index >= nums.length) {
            int sum2 = totalSum - currentSum;

            if (sum2 - currentSum == diff) {
                return 1;
            } else {
                return 0;
            }
        }

        if (dp[index][currentSum] != -1) {
            return dp[index][currentSum];
        }

        int take = solve(nums, index + 1, currentSum + nums[index], totalSum, diff, dp);
        int skip = solve(nums, index + 1, currentSum, totalSum, diff, dp);

        return dp[index][currentSum] = take + skip;
    }
}

// Approach 2 Tabulation O(n*totalSum)
class Solution {
    public int countPartitions(int[] nums, int diff) {
        int n = nums.length;
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        if ((totalSum - diff) < 0 || (totalSum - diff) % 2 != 0) {
            return 0;
        }

        int dp[][] = new int[nums.length + 1][totalSum + 1];
        int targetSum = (totalSum - diff) / 2;
        dp[n][targetSum] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int currentSum = 0; currentSum <= totalSum; currentSum++) {
                int take = 0;
                if (currentSum + nums[i] <= totalSum) {
                    take = dp[i + 1][currentSum + nums[i]];
                }
                int skip = dp[i + 1][currentSum];

                dp[i][currentSum] = take + skip;
            }
        }

        return dp[0][0];
    }
}

// Approach 3 Optimal with O(totalSum) space
class Solution {
    public int countPartitions(int[] nums, int diff) {
        int n = nums.length;
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        if ((totalSum - diff) < 0 || (totalSum - diff) % 2 != 0) {
            return 0;
        }

        int dp[] = new int[totalSum + 1];
        int targetSum = (totalSum - diff) / 2;
        dp[targetSum] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int currentSum = 0; currentSum <= totalSum; currentSum++) {
                int take = 0;
                if (currentSum + nums[i] <= totalSum) {
                    take = dp[currentSum + nums[i]];
                }
                int skip = dp[currentSum];

                dp[currentSum] = take + skip;
            }
        }

        return dp[0];
    }
}