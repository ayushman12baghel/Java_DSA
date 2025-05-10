import java.util.*;

public class Minimum_sum_of_Two_arrays_after_replacing_zeros {

    // Greedy Approach
    public static long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long sum2 = 0;
        int zero1 = 0;
        int zero2 = 0;

        for (int num : nums1) {
            if (num == 0) {
                zero1++;
                sum1 += 1;
            }
            sum1 += num;
        }
        for (int num : nums2) {
            if (num == 0) {
                zero2++;
                sum2 += 1;
            }
            sum2 += num;
        }

        if ((sum1 > sum2 && zero2 == 0) || (sum2 > sum1 && zero1 == 0)) {
            return -1;
        }

        return Math.max(sum1, sum2);
    }

    public static void main(String args[]) {
        int nums1[] = { 3, 2, 0, 1, 0 };
        int nums2[] = { 6, 5, 0 };

        System.out.println(minSum(nums1, nums2));
    }
}
