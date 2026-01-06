import java.util.*;

//Approach Using Sliding Window
class Solution {
    public int maxSubarrayXOR(int[] nums, int k) {
        int n = nums.length;

        int i = 0;
        int j = 0;
        int currentSum = 0;
        int maxSum = 0;

        while (j < n) {
            currentSum ^= nums[j];

            if (j - i + 1 > k) {
                currentSum ^= nums[i];
                i++;
            }

            if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, currentSum);
            }

            j++;
        }

        return maxSum;
    }
}
