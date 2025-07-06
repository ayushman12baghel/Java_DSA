import java.util.*;

public class Minimum_Swaps_To_Make_All_1s_Together_II {

    // Using Sliding Window and 2*n iterations T.C-> O(n)
    public static int minSwaps(int[] nums) {
        int n = nums.length;
        int totalOne = 0;

        for (int num : nums) {
            totalOne += num;
        }

        int currentOne = 0;
        int maxOneTogether = 0;
        int i = 0;
        int j = 0;

        while (j < 2 * n) {
            currentOne += nums[j % n];

            if (j - i + 1 > totalOne) {
                currentOne -= nums[i % n];
                i++;
            }

            maxOneTogether = Math.max(maxOneTogether, currentOne);

            j++;
        }

        return totalOne - maxOneTogether;
    }

    public static void main(String[] args) {
        int nums[] = { 0, 1, 1, 1, 0, 0, 1, 1, 0 };

        System.out.println(minSwaps(nums));
    }
}
