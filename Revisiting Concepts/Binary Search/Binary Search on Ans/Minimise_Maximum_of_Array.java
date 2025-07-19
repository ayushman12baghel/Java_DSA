import java.util.*;

public class Minimise_Maximum_of_Array {

    public static int minimizeArrayValue(int[] nums) {
        int left = 0;
        int right = Integer.MIN_VALUE;
        for (int num : nums) {
            right = Math.max(right, num);
        }

        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(nums, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int nums2[], int expectedMax) {
        long nums[] = new long[nums2.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums2[i];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > expectedMax) {
                return false;
            }

            long buffer = expectedMax - nums[i];
            nums[i + 1] = nums[i + 1] - buffer;
        }

        return nums[nums.length - 1] <= expectedMax;
    }

    public static void main(String[] args) {
        int nums[] = { 3, 7, 1, 6 };

        System.out.println(minimizeArrayValue(nums));
    }
}
