import java.util.*;

// Approach 1 Brute Force(n*k)
class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();

        for (int i = 0; i + 2 * k <= n; i++) {
            if (isIncreasing(nums, i, k)) {
                if (isIncreasing(nums, i + k, k)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isIncreasing(List<Integer> nums, int index, int k) {
        for (int i = index; i < index + k - 1; i++) {
            if (nums.get(i) >= nums.get(i + 1)) {
                return false;
            }
        }

        return true;
    }
}

// Approach 2 O(n)
class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int currentLength = 1;
        int prevLength = 0;

        for (int i = 1; i < n; i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                currentLength++;
            } else {
                prevLength = currentLength;
                currentLength = 1;
            }

            if (currentLength >= 2 * k) {
                return true;
            }

            if (Math.min(currentLength, prevLength) >= k) {
                return true;
            }
        }

        return false;
    }
}