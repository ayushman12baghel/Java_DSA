import java.util.*;

//Approach O(n) by counting the subarrays ending at index i  with O(n) space

class Solution {
    public int countIncreasing(int[] nums) {
        int n = nums.length;

        int result = 0;
        int dp[] = new int[n];

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                result += dp[i];
            }
        }

        return result;
    }
}

// Approach 2 Space Optimised O(n)
class Solution {
    public int countIncreasing(int[] nums) {
        int n = nums.length;

        int result = 0;
        int prev = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                int current = prev + 1;
                result += current;
                prev = current;
            } else {
                prev = 0;
            }
        }

        return result;
    }
}
