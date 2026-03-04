import java.util.*;

// Approach Using Sliding Window O(n)
class Solution {
    public int maxSubarrayXOR(int[] nums, int k) {
        int currentXor = 0;

        for (int i = 0; i < k; i++) {
            currentXor ^= nums[i];
        }

        int maxXor = currentXor;
        int i = 0;
        int j = k;

        while (j < nums.length) {
            currentXor ^= nums[j];

            if (j - i + 1 > k) {
                currentXor ^= nums[i];
                i++;
            }

            maxXor = Math.max(maxXor, currentXor);
            j++;
        }

        return maxXor;
    }
}
