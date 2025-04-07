public class Partition_Equal_Subset_Sum {

    // Approach 1 Using Recursion and Memoisation
    public static boolean canPartition1(int nums[]) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        Boolean dp[][] = new Boolean[nums.length][target + 1];

        return solve(nums, 0, target, 0, dp);
    }

    public static boolean solve(int nums[], int i, int target, int sum, Boolean dp[][]) {
        if (sum == target) {
            return true;
        }

        if (i >= nums.length || sum > target) {
            return false;
        }

        if (dp[i][sum] != null) {
            return dp[i][sum];
        }

        boolean taken = solve(nums, i + 1, target, sum + nums[i], dp);
        boolean notTaken = solve(nums, i + 1, target, sum, dp);

        return dp[i][sum] = (taken || notTaken);
    }

    public static boolean canPartition(int arr[]) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        int W = sum / 2;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = Math.max(arr[i - 1] + dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        int sum1 = dp[n][W];
        int sum2 = sum - sum1;

        if (sum1 - sum2 == 0) {
            return true;
        }

        return false;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 5, 11, 5 };

        System.out.println(canPartition(arr));
        System.out.println(canPartition1(arr));
    }
}
