import java.util.*;

public class Maximum_Subarray_Sum_of_Subarray {

    // Approach 1 Using 2 Passes
    public static int maxAbsoluteSum(int nums[]) {
        int maxSum = nums[0];
        int minSum = nums[0];
        int currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(currSum + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }

        currSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.min(nums[i], currSum + nums[i]);
            minSum = Math.min(minSum, currSum);
        }

        return Math.max(maxSum, Math.abs(minSum));
    }

    // Approach 2 Using 1 Pass
    public static int maxAbsoluteSum2(int[] nums) {
        int minSum = nums[0];
        int maxSum = nums[0];
        int currSum = nums[0];
        int currSumMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
            currSumMin = Math.min(nums[i], currSumMin + nums[i]);
            minSum = Math.min(minSum, currSumMin);
        }

        return Math.max(maxSum, Math.abs(minSum));
    }

    public static void main(String args[]) {
        int nums[] = { 2, -5, 1, -4, 3, -2 };

        System.out.println(maxAbsoluteSum(nums));

        System.out.println(maxAbsoluteSum2(nums));
    }
}
