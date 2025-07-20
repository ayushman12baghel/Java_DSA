import java.util.*;

public class Minimum_Cost_to_Make_Array_Equal {

    // Approach Using Binary Search on Ans
    public static long minCost(int nums[], int cost[]) {
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }

        long ans = Long.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            long costAtMid = getTotalCost(nums, cost, mid);
            ans = Math.min(ans, costAtMid);

            if (costAtMid > getTotalCost(nums, cost, mid + 1)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return ans == Long.MAX_VALUE ? 0 : ans;
    }

    public static long getTotalCost(int nums[], int cost[], int target) {
        long result = 0;

        for (int i = 0; i < nums.length; i++) {
            result += (long) Math.abs(nums[i] - target) * cost[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, 5, 2 };
        int cost[] = { 2, 3, 1, 14 };

        System.out.println(minCost(nums, cost));
    }
}
