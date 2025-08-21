import java.util.*;

public class Maximize_The_Minimum_Difference_Between_K_Elements {

    // Approach -> Binary Search on Ans O(nlogn)
    public static int maxMinDiff(int[] nums, int k) {
        int n = nums.length;

        Arrays.sort(nums);
        int left = 0;
        int right = nums[n - 1] - nums[0];
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(nums, mid, k)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int nums[], int mid, int k) {
        int count = 1;
        int first = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - first >= mid) {
                count++;
                first = nums[i];
            }

            if (count >= k) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int nums[] = { 1, 4, 9, 0, 2, 13, 3 };
        int k = 4;
    }
}
