import java.util.*;

public class Maximum_Sum_of_Elements_not_Part_of_LIS {

    public static int nonLisMaxSum(int nums[]) {
        int n = nums.length;
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        return totalSum - smallestLISsum(nums);
    }

    public static int smallestLISsum(int nums[]) {
        int n = nums.length;
        int dp[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            dp[i][1] = nums[i];
        }

        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    int newLength = dp[j][0] + 1;
                    int newSum = dp[j][1] + nums[i];

                    if (newLength > dp[i][0] || (newLength == dp[i][0] && newSum < dp[i][1])) {
                        dp[i][0] = newLength;
                        dp[i][1] = newSum;
                    }
                }
            }

            maxLength = Math.max(maxLength, dp[i][0]);
        }

        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[i][0] == maxLength) {
                minSum = Math.min(minSum, dp[i][1]);
            }
        }

        return minSum;
    }

    public static void main(String[] args) {
        int nums[] = { 5, 4, 3, 2, 1 };

        System.out.println(nonLisMaxSum(nums));
    }
}
