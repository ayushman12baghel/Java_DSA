import java.util.*;

// Approach 1 Using Greedy Approach O(nlogn)
class Solution {
    public int maxSumDivThree(int[] nums) {
        List<Integer> remain1 = new ArrayList<>();
        List<Integer> remain2 = new ArrayList<>();
        int sum = 0;

        for (int num : nums) {
            sum += num;

            if (num % 3 == 1) {
                remain1.add(num);
            } else if (num % 3 == 2) {
                remain2.add(num);
            }
        }

        if (sum % 3 == 0) {
            return sum;
        }

        Collections.sort(remain1);
        Collections.sort(remain2);
        int result = 0;

        if (sum % 3 == 1) {
            int remove1 = (remain1.size() >= 1 ? remain1.get(0) : Integer.MAX_VALUE);
            int remove2 = (remain2.size() >= 2 ? remain2.get(0) + remain2.get(1) : Integer.MAX_VALUE);
            result = Math.min(remove1, remove2);
        } else {
            int remove2 = (remain2.size() >= 1 ? remain2.get(0) : Integer.MAX_VALUE);
            int remove1 = (remain1.size() >= 2 ? remain1.get(0) + remain1.get(1) : Integer.MAX_VALUE);
            result = Math.min(remove1, remove2);
        }

        return sum - Math.max(0, result);
    }
}

// Approach 2 Using Memoisation O(n)
class Solution {
    public int maxSumDivThree(int[] nums) {
        int dp[][] = new int[nums.length][3];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums, 0, 0, dp);
    }

    public int solve(int nums[], int index, int mod, int dp[][]) {
        if (index >= nums.length) {
            return mod == 0 ? 0 : Integer.MIN_VALUE;
        }

        if (dp[index][mod] != -1) {
            return dp[index][mod];
        }

        int take = nums[index] + solve(nums, index + 1, (nums[index] + mod) % 3, dp);
        int notTake = solve(nums, index + 1, mod, dp);

        return dp[index][mod] = Math.max(take, notTake);
    }
}

// Approach 3 Bottom Up O(n)
class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;

        int dp[][] = new int[n + 1][3];
        for (int row[] : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        dp[n][0] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int mod = 0; mod < 3; mod++) {
                int newMod = (mod + nums[i]) % 3;

                int take = (dp[i + 1][newMod] == Integer.MIN_VALUE ? Integer.MIN_VALUE : nums[i] + dp[i + 1][newMod]);
                int notTake = dp[i + 1][mod];

                dp[i][mod] = Math.max(take, notTake);
            }
        }

        return Math.max(0, dp[0][0]);
    }
}