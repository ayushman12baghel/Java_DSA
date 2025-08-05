import java.util.*;

public class Allocate_Minimum_Pages {

    // Using Binary Search On Ans
    public static int findPages(int nums[], int k) {
        if (k > nums.length) {
            return -1;
        }

        int left = nums[0];
        int right = 0;
        for (int num : nums) {
            left = Math.max(num, left);
            right += num;
        }

        int result = -1;

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

    public static boolean isPossible(int nums[], int maxPages, int k) {
        int count = 1;
        int currentPages = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + currentPages > maxPages) {
                count++;
                currentPages = nums[i];
            } else {
                currentPages += nums[i];
            }
        }

        return count <= k;
    }

    public static void main(String[] args) {
        int nums[] = { 12, 34, 67, 90 };
        int k = 2;

        System.out.println(findPages(nums, k));
    }
}
