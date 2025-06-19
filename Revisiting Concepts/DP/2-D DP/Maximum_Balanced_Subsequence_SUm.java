import java.util.*;

public class Maximum_Balanced_Subsequence_SUm {

    // Approach 1 Using Memoisation T.L.E (LIS Code)
    public static long maxBalancedSubsequenceSum(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int positive = 0;
        for (int num : nums) {
            maxValue = Math.max(num, maxValue);
            if (num > 0) {
                positive++;
            }
        }

        if (positive == 0) {
            return maxValue;
        }

        long dp[][] = new long[nums.length][nums.length + 1];
        for (long row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums, 0, -1, dp);
    }

    public static long solve(int nums[], int index, int prevIndex, long dp[][]) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }

        long taken = 0;
        if (prevIndex == -1 || nums[index] - index >= nums[prevIndex] - prevIndex) {
            taken = nums[index] + solve(nums, index + 1, index, dp);
        }

        long notTaken = solve(nums, index + 1, prevIndex, dp);

        return dp[index][prevIndex + 1] = Math.max(taken, notTaken);
    }

    // Bottom Up of LIS Code T.L.E
    public static long maxBalancedSubsequenceSum2(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int positive = 0;
        for (int num : nums) {
            maxValue = Math.max(num, maxValue);
            if (num > 0) {
                positive++;
            }
        }

        if (positive == 0) {
            return maxValue;
        }

        long dp[] = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
        }

        long ans = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] - i >= nums[j] - j) {
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }

        return ans > maxValue ? ans : maxValue;
    }

    // Approach 2 Using Patience Sorting (TreeMap)
    public static long maxBalancedSubsequenceSum3(int nums[]) {
        int n = nums.length;
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = nums[i] - i;
        }

        TreeMap<Integer, Long> map = new TreeMap<>();
        long ans = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                ans = Math.max(ans, nums[i]);
            } else {
                long temp = nums[i];

                if (map.floorKey(arr[i]) != null) {// Go down from key, and find the closest match
                    temp += map.get(map.floorKey(arr[i]));
                }

                while (map.ceilingKey(arr[i]) != null && map.get(map.ceilingKey(arr[i])) < temp) {// Go up from key,
                    // and find the closest match
                    map.remove(map.ceilingKey(arr[i]));
                }

                if (map.floorKey(arr[i]) == null || map.get(map.floorKey(arr[i])) < temp) {
                    map.put(arr[i], temp);
                }

                ans = Math.max(ans, temp);
            }
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 3, 3, 5, 6 };

        System.out.println(maxBalancedSubsequenceSum(nums));
        System.out.println(maxBalancedSubsequenceSum2(nums));
        System.out.println(maxBalancedSubsequenceSum3(nums));
    }
}
