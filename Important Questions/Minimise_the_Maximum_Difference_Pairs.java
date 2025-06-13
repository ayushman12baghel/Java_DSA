import java.util.*;

public class Minimise_the_Maximum_Difference_Pairs {

    // Binary Search on Ans
    public static int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);

        int left = 0;
        int right = nums[n - 1] - nums[0];
        int result = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isValid(nums, p, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static boolean isValid(int nums[], int p, int mid) {
        int i = 0;
        int pairs = 0;

        while (i < nums.length - 1) {
            if (nums[i + 1] - nums[i] <= mid) {
                pairs++;
                i += 2;
            } else {
                i++;
            }
        }

        return pairs >= p;
    }

    public static void main(String args[]) {
        int nums[] = { 10, 1, 2, 7, 1, 3 };
        int p = 2;

        System.out.println(minimizeMax(nums, p));
    }
}
