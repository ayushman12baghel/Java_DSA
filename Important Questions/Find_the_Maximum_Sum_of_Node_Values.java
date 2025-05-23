import java.util.*;

public class Find_the_Maximum_Sum_of_Node_Values {

    public static long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        int xorCount = 0;
        int minNuksaan = Integer.MAX_VALUE;

        for (int num : nums) {
            if ((num ^ k) > num) {
                sum += (num ^ k);
                xorCount++;
            } else {
                sum += num;
            }

            minNuksaan = Math.min(minNuksaan, Math.abs(num - (num ^ k)));
        }

        if (xorCount % 2 == 0) {
            return sum;
        }

        return sum - minNuksaan;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 1 };
        int edges[][] = { { 0, 1 }, { 0, 2 } };
        int k = 3;

        System.out.println(maximumValueSum(nums, k, edges));
    }
}
