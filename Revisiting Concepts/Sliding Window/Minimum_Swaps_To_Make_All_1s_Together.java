import java.util.*;

public class Minimum_Swaps_To_Make_All_1s_Together {

    // Using Sliding Window O(n)
    public static int minSwaps(int[] nums) {
        int n = nums.length;
        int totalOne = 0;

        for (int num : nums) {
            totalOne += num;
        }

        if (totalOne == 0) {
            return -1;
        }

        int i = 0;
        int j = 0;
        int onesTogether = 0;
        int maxOnesTogether = 0;

        while (j < n) {
            onesTogether += nums[j];

            if (j - i + 1 > totalOne) {
                onesTogether -= nums[i];
                i++;
            }

            maxOnesTogether = Math.max(maxOnesTogether, onesTogether);

            j++;
        }

        return totalOne - maxOnesTogether;
    }

    public static void main(String[] args) {
        int nums[] = { 0, 1, 0, 1, 1, 0, 0 };

        System.out.println(minSwaps(nums));
    }
}
