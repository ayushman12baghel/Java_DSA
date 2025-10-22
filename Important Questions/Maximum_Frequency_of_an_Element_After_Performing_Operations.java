import java.util.*;

//O(Math.max(maxElement,n))
class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n = nums.length;

        int maxElement = Integer.MIN_VALUE;
        for (int num : nums) {
            maxElement = Math.max(maxElement, num);
        }

        maxElement += k;
        int freq[] = new int[maxElement + 1];
        for (int num : nums) {
            freq[num]++;
        }

        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }

        int result = 0;

        for (int target = 0; target <= maxElement; target++) {
            if (freq[target] == 0) {
                continue;
            }

            int left = Math.max(0, target - k);
            int right = Math.min(maxElement, target + k);

            int totalCount = freq[right] - (left == 0 ? 0 : freq[left - 1]);
            int targetCount = freq[target] - (target == 0 ? 0 : freq[target - 1]);

            int requiredOperations = totalCount - targetCount;
            int maxFreq = targetCount + Math.min(numOperations, requiredOperations);

            result = Math.max(result, maxFreq);
        }

        return result;
    }
}