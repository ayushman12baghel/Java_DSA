import java.util.*;

public class Maximum_Difference_Between_Adjacent_Elements_In_Circular_Array {

    public static int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxDifference = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {
            maxDifference = Math.max(maxDifference, Math.abs(nums[i] - nums[i + 1]));
        }

        maxDifference = Math.max(maxDifference, Math.abs(nums[0] - nums[n - 1]));

        return maxDifference;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 4 };
        System.out.println(maxAdjacentDistance(nums));
    }
}
