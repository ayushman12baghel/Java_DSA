import java.util.*;

//Approach Using Sliding Window O(n)
class Solution {
    public int maxOnes(int nums[], int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int zeros = 0;
        int maxSum = 0;
        int currentSum = 0;

        while (j < n) {
            if (nums[j] == 0) {
                zeros++;
            } else {
                currentSum += nums[j];
            }

            if (zeros > k) {
                currentSum -= nums[i];
                if (nums[i] == 0) {
                    zeros--;
                }

                i++;
            }

            maxSum = Math.max(maxSum, j - i + 1);

            j++;
        }

        return maxSum;
    }
}