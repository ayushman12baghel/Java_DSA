import java.util.*;

public class House_Robber_IV {

    // Approach 1 Doing Memoisation O(n*k) M.L.E
    public static int minCapability(int[] nums, int k) {
        int dp[][] = new int[nums.length][k + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums, 0, k, dp);
    }

    public static int solve(int nums[], int index, int k, int dp[][]) {
        if (k == 0) {
            return 0;
        }

        if (index >= nums.length) {
            return Integer.MAX_VALUE;
        }

        if (dp[index][k] != -1) {
            return dp[index][k];
        }

        int take = Math.max(nums[index], solve(nums, index + 2, k - 1, dp));
        int skip = solve(nums, index + 1, k, dp);

        return dp[index][k] = Math.min(take, skip);
    }

    // Optimal Approach Binary Search on Ans
    public static int minCapability2(int nums[], int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        int left = min;
        int right = max;
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(nums, mid, k)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int nums[], int target, int k) {
        int count = 0;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] <= target) {
                count++;
                i++;
            }

            i++;
        }

        return count >= k;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 3, 5, 9 };
        int k = 2;

        System.out.println(minCapability(nums, k));
        System.out.println(minCapability2(nums, k));
    }
}
