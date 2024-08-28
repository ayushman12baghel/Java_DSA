public class Maximum_Subarray {

    public static int maxSubarray(int nums[]) {
        int curr = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            curr = curr + nums[i];
            maxSum = Math.max(curr, maxSum);
            if (curr <= 0) {
                curr = 0;
            }
        }

        return maxSum;
    }

    public static int maxSubarray2(int nums[]) {
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            ans = Math.max(dp[i], ans);
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        System.out.println(maxSubarray(nums));
        System.out.println(maxSubarray2(nums));
    }
}
