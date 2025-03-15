import java.util.Arrays;

public class House_Robber_4 {

    // Approach 1 Using DP O(n*k) T.L.E
    public static int minCapability(int[] nums, int k) {
        int dp[][] = new int[nums.length + 1][k + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return solve(nums, k, 0, dp);
    }

    public static int solve(int nums[], int k, int i, int dp[][]) {
        if (k == 0) {
            return 0;
        }

        if (i >= nums.length) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][k] != -1) {
            return dp[i][k];
        }

        int taken = Math.max(nums[i], solve(nums, k - 1, i + 2, dp));
        int notTaken = solve(nums, k, i + 1, dp);

        return dp[i][k] = Math.min(taken, notTaken);
    }

    // Approach 2 Using Binary Search Greedily O(nlogn)
    public static int minCapability2(int[] nums, int k) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            left = Math.min(left, nums[i]);
            right = Math.max(right, nums[i]);
        }

        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(nums, k, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int nums[], int k, int mid) {
        int houseCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid) {
                houseCount++;
                i++;
            }
        }

        return houseCount >= k;
    }

    public static void main(String args[]) {
        int nums[] = { 2, 3, 5, 9 };
        int k = 2;
        System.out.println(minCapability(nums, k));
        System.out.println(minCapability2(nums, k));
    }
}
