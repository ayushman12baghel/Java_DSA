import java.util.*;

public class Maximum_Value_of_Ordered_Tripplet_II {

    // Approach 1 Using LeftMax and RightMax
    public static long maximumTripletValue(int[] nums) {
        int leftMax[] = new int[nums.length];
        int rightMax[] = new int[nums.length];

        leftMax[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], nums[i - 1]);
        }

        rightMax[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], nums[i + 1]);
        }

        long result = 0;

        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, (long) (leftMax[i] - nums[i]) * rightMax[i]);
        }

        return result;
    }

    // Approach 2 Without Extra Space
    public static long maximumTripletValue2(int[] nums) {
        long maxI = 0;
        long maxDiff = 0;
        long result = 0;

        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, maxDiff * nums[i]);
            maxI = Math.max(maxI, nums[i]);
            maxDiff = Math.max(maxDiff, maxI - nums[i]);
        }

        return result;
    }

    public static void main(String args[]) {
        int nums[] = { 12, 6, 1, 2, 7 };

        System.out.println(maximumTripletValue(nums));
        System.out.println(maximumTripletValue2(nums));
    }
}
