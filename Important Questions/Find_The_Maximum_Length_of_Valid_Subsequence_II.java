import java.util.*;

public class Find_The_Maximum_Length_of_Valid_Subsequence_II {

    // Approach Dynamic Programming
    public static int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int dp[][] = new int[n][k];

        for (int row[] : dp) {
            Arrays.fill(row, 1);
        }

        int maxSub = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int mod = (nums[i] + nums[j]) % k;
                dp[i][mod] = Math.max(dp[i][mod], dp[j][mod] + 1);
                maxSub = Math.max(maxSub, dp[i][mod]);
            }
        }

        return maxSub;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 4, 5 };
        int k = 2;

        System.out.println(maximumLength(nums, k));
    }
}
