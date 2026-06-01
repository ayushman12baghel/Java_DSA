import java.util.*;

// Approach Greedy O(n)
class Solution {
    public int findMaxProduct(int[] nums) {
        int n = nums.length;

        int zeroCount = 0;
        int negCount = 0;
        int maxNeg = Integer.MIN_VALUE;
        int mod = 1000000007;
        if (n == 1) {
            return nums[0];
        }

        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else if (num < 0) {
                negCount++;
                maxNeg = Math.max(maxNeg, num);
            }
        }

        if (zeroCount == n) {
            return 0;
        }

        if (negCount == 1 && negCount + zeroCount == n) {
            return 0;
        }

        long prod = 1;
        boolean skipped = false;

        for (int num : nums) {
            if (num == 0) {
                continue;
            }

            if (negCount % 2 != 0 && maxNeg == num && !skipped) {
                skipped = true;
                continue;
            }

            prod = (prod * num) % mod;
        }

        return (int) (prod + mod) % mod;
    }
}