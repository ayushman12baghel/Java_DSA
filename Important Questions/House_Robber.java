public class House_Robber {

    public static int rob(int nums[]) {
        if (nums.length == 0) {
            return 0;
        }
        int dp[] = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }

    public static void main(String args[]) {
        int nums[] = { 2, 1, 1, 2 };

        System.out.println(rob(nums));
    }
}
