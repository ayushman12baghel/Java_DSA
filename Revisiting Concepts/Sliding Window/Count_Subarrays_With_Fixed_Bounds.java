import java.util.*;

public class Count_Subarrays_With_Fixed_Bounds {

    // Sliding Window
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        int minIndex = -1;
        int maxIndex = -1;
        int culpritIndex = -1;
        int n = nums.length;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] > maxK || nums[i] < minK) {
                culpritIndex = i;
            }

            if (nums[i] == minK) {
                minIndex = i;
            }
            if (nums[i] == maxK) {
                maxIndex = i;
            }

            long smallerIndex = Math.min(minIndex, maxIndex);
            long temp = smaller - culpritIndex;

            ans += (temp <= 0 ? 0 : temp);
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 3, 5, 2, 7, 5 };
        int minK = 1;
        int maxK = 5;
    }
}
