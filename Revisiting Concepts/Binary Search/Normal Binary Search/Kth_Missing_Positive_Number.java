import java.util.*;

public class Kth_Missing_Positive_Number {

    // Approach 1 Brute Force O(n)
    public static int findKthPositive(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int num = 1;

        while (i < n && k > 0) {
            if (nums[i] == num) {
                i++;
            } else {
                k--;
            }

            num++;
        }

        while (k-- > 0) {
            num++;
        }

        return num - 1;
    }

    // Approach 2 Using Binary Search O(logn)
    public static int findKthPositive2(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int missing = nums[mid] - (mid + 1);

            if (missing < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left + k;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 3, 4, 7, 11 };
        int k = 5;

        System.out.println(findKthPositive2(nums, k));
    }
}
