import java.util.*;

//Approach Brute Force O(n^2/k)  T.L.E
class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        long ans = Long.MIN_VALUE;
        long prefix[] = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for (int i = 0; i <= n; i++) {
            for (int j = i + k; j <= n; j += k) {
                long currentSum = prefix[j] - prefix[i];

                ans = Math.max(ans, currentSum);
            }
        }

        return ans;
    }
}

// Approach 2 Kadane's Algo O(n)
class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;

        long ans = Long.MIN_VALUE;
        long prefix[] = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for (int i = 0; i < k; i++) {
            long sum = 0;

            for (int j = i; j + k <= n; j += k) {
                long currSum = prefix[j + k] - prefix[j];
                sum = Math.max(sum + currSum, currSum);
                ans = Math.max(ans, sum);
            }
        }

        return ans;
    }
}