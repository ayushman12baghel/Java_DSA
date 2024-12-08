import java.util.*;

public class Minimum_Limit_of_Balls_Bag {

    public static boolean isPossible(int mid, int nums[], int maxOps) {
        int total = 0;

        for (int num : nums) {
            int ops = num / mid;
            if (num % mid == 0) {
                ops--;
            }

            total += ops;
        }

        if (total > maxOps) {
            return false;
        }

        return true;
    }

    public static int minimiseSize(int nums[], int operations) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        int result = 0;

        for (int num : nums) {
            right = Math.max(num, right);
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(mid, nums, operations)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String args[]) {
        int nums[] = { 2, 4, 8, 2 };
        int operations = 4;

        System.out.println(minimiseSize(nums, operations));
    }
}
