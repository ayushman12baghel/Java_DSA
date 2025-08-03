import java.util.*;

public class Minimum_Milit_of_Balls_in_a_Bag {

    public static int minimumSize(int[] nums, int maxOperations) {
        int maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
            maxValue = Math.max(maxValue, num);
        }

        int left = 1;
        int right = maxValue;
        int result = maxValue;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(nums, mid, maxOperations)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int nums[], int target, int maxOperations) {
        long operations = 0;

        for (int num : nums) {
            operations += (num / target);

            if (num % target == 0) {
                operations--;
            }
        }

        return operations <= maxOperations;
    }

    public static void main(String[] args) {
        int nums[] = { 2, 4, 8, 2 };
        int maxOperations = 4;

        System.out.println(minimumSize(nums, maxOperations));
    }
}
