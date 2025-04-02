import java.util.*;

public class Maximum_Value_of_Ordered_Tripplet_I {

    // Brute Force O(n^3)
    public static long maximumTripletValue(int nums[]) {
        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    ans = Math.max(ans, (long) (nums[i] - nums[j]) * nums[k]);
                }
            }
        }

        return ans;
    }

    // Optimised with O(n) space
    public static long maximumTripletValue2(int nums[]) {
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

        long ans = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            ans = Math.max(ans, (long) (leftMax[i] - nums[i]) * rightMax[i]);
        }

        return ans;
    }

    public static long maximumTripletValue3(int nums[]) {
        long maxI = 0;
        long maxDiff = 0;
        long ans = 0;

        for (int i = 0; i < nums.length; i++) {
            ans = Math.max(maxDiff * nums[i], ans);
            maxI = Math.max(maxI, (long) nums[i]);
            maxDiff = Math.max(maxDiff, (long) maxI - nums[i]);
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 12, 6, 1, 2, 7 };
        System.out.println(maximumTripletValue(nums));
        System.out.println(maximumTripletValue2(nums));
        System.out.println(maximumTripletValue3(nums));
    }
}
