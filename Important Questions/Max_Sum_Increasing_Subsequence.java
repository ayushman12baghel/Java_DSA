import java.util.*;

//Approach Using Memoisation O(n^2) Time and O(n^2) Space 
class Solution {
    public int maxSumIS(int nums[]) {
        int n = nums.length;
        int dp[][] = new int[n][n + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums, 0, -1, dp);
    }

    public int solve(int nums[], int index, int prevIndex, int dp[][]) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }

        int take = 0;
        if (prevIndex == -1 || nums[prevIndex] < nums[index]) {
            take = nums[index] + solve(nums, index + 1, index, dp);
        }

        int notTake = solve(nums, index + 1, prevIndex, dp);

        return dp[index][prevIndex + 1] = Math.max(take, notTake);
    }
}

// Approach Using Tabulation O(n^2) Time ans O(n) Space
class Solution {
    public int maxSumIS(int nums[]) {
        int n = nums.length;

        int dp[] = new int[n];
        dp[0] = nums[0];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int maxSum = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxSum = Math.max(maxSum, dp[j]);
                }
            }

            dp[i] = maxSum + nums[i];
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}

// Approach 3 Using TreeMap O(nlogn) Time and O(n) Space
class Solution {
    public int maxSumIS(int nums[]) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = 0;

        for (int num : nums) {
            Map.Entry<Integer, Integer> entry = map.lowerEntry(num);
            int bestSmaller = (entry == null ? 0 : entry.getValue());

            int currSum = bestSmaller + num;

            if (map.getOrDefault(num, 0) < currSum) {
                map.put(num, currSum);

                Integer higher = map.higherKey(num);
                while (higher != null && map.get(higher) < currSum) {
                    map.remove(higher);
                    higher = map.higherKey(num);
                }
            }

            ans = Math.max(ans, currSum);
        }

        return ans;
    }
}