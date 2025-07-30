import java.util.*;

public class Longest_Subarray_With_Maximum_Bitwise_And {

    // My Approach Two Pass
    public static int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(num, max);
        }

        int currentCount = 0;
        int maxCount = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                if (currentCount != 0 && nums[i - 1] == max) {
                    currentCount++;
                    maxCount = Math.max(maxCount, currentCount);
                } else {
                    currentCount = 1;
                }
            }
        }

        return maxCount;
    }

    // Optimised One Pass
    public static int longestSubarray2(int[] nums) {
        int max = 0;
        int maxLength = 0;
        int streak = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                streak = 0;
                maxLength = 0;
            }

            if (nums[i] == max) {
                streak++;
            } else {
                streak = 0;
            }

            maxLength = Math.max(maxLength, streak);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 2, 3, 3, 2, 2 };

        System.out.println(longestSubarray(nums));
        System.out.println(longestSubarray2(nums));
    }
}
