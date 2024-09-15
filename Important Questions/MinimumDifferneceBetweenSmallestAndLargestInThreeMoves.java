import java.util.*;

public class MinimumDifferneceBetweenSmallestAndLargestInThreeMoves {

    public static int minDifference(int nums[]) {
        int n = nums.length;
        if (n <= 4) {
            return 0;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;

        min = Math.min(nums[n - 1] - nums[3], min);
        min = Math.min(nums[n - 4] - nums[0], min);
        min = Math.min(nums[n - 2] - nums[2], min);
        min = Math.min(nums[n - 3] - nums[1], min);

        return min;
    }

    public static void main(String args[]) {
        int nums[] = { 5, 3, 2, 4 };

        System.out.println(minDifference(nums));
    }
}
