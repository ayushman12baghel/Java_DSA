import java.util.*;

public class Longest_Increasing_Decreasing_Subarray {

    public static int longestMonotonicSubarray(int nums[]) {
        int count1 = 1;
        int count2 = 1;
        int maxCount = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count1++;
                count2 = 1;
            } else if (nums[i] < nums[i + 1]) {
                count2++;
                count1 = 1;
            } else {
                count1 = 1;
                count2 = 1;
            }

            maxCount = Math.max(count1, Math.max(maxCount, count2));
        }

        return maxCount;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 4, 3, 3, 2 };

        System.out.println(longestMonotonicSubarray(nums));
    }
}
