import java.util.*;

public class Target_Sum {

    // Brute Force
    public static int findTargetSumWays(int nums[], int target) {
        int ans[] = new int[1];
        calculate(nums, target, 0, 0, ans);

        return ans[0];
    }

    public static void calculate(int nums[], int target, int index, int sum, int ans[]) {
        if (index == nums.length) {
            if (sum == target) {
                ans[0]++;
            }
        } else {
            // include
            calculate(nums, target, index + 1, sum + nums[index], ans);

            // exclude
            calculate(nums, target, index + 1, sum - nums[index], ans);
        }
    }

    // Approach 2 By using Map

    public static int findTargetSumWays2(int nums[], int target) {
        Map<String, Integer> map = new HashMap<>();

        return calculate2(nums, target, 0, 0, map);
    }

    public static int calculate2(int nums[], int target, int index, int sum, Map<String, Integer> map) {
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        }

        String key = index + "," + sum;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int add = calculate2(nums, target, index + 1, sum + nums[index], map);
        int subtract = calculate2(nums, target, index + 1, sum - nums[index], map);

        map.put(key, add + subtract);

        return map.get(key);
    }

    // Approach 3 Memoisation

    public static int findTargetSumWays3(int nums[], int target) {
        int totalSum[] = new int[1];

        for (int i = 0; i < nums.length; i++) {
            totalSum[0] += nums[i];
        }

        int dp[][] = new int[nums.length][2 * totalSum[0] + 1];

        for (int row[] : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return calculate3(nums, target, 0, 0, totalSum, dp);
    }

    public static int calculate3(int nums[], int target, int index, int sum, int totalSum[], int dp[][]) {
        if (index == nums.length) {
            return sum == target ? 1 : 0;
        } else {
            if (dp[index][totalSum[0] + sum] != Integer.MIN_VALUE) {
                return dp[index][totalSum[0] + sum];
            }

            int add = calculate3(nums, target, index + 1, sum + nums[index], totalSum, dp);
            int subtract = calculate3(nums, target, index + 1, sum - nums[index], totalSum, dp);

            dp[index][totalSum[0] + sum] = add + subtract;

            return dp[index][totalSum[0] + sum];
        }
    }

    // Approach 4 By Tabulation
    public static int findTargetSumWays4(int nums[], int target) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        int dp[][] = new int[nums.length][2 * totalSum + 1];
        dp[0][nums[0] + totalSum] += 1;
        dp[0][-nums[0] + totalSum] += 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = -totalSum; j <= totalSum; j++) {
                if (dp[i - 1][j + totalSum] > 0) {
                    dp[i][j + nums[i] + totalSum] += dp[i - 1][j + totalSum];
                    dp[i][j - nums[i] + totalSum] += dp[i - 1][j + totalSum];
                }
            }
        }

        return Math.abs(target) > totalSum ? 0 : dp[nums.length - 1][target + totalSum];
    }

    public static void main(String args[]) {
        int nums[] = { 1, 1, 1, 1, 1 };
        int target = 3;

        System.out.println(findTargetSumWays(nums, target));
        System.out.println(findTargetSumWays2(nums, target));
        System.out.println(findTargetSumWays3(nums, target));
        System.out.println(findTargetSumWays4(nums, target));
    }
}
