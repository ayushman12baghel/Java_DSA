import java.util.*;

class Solution {
    public int countPartitions(int[] nums) {
        int totalSum = 0;
        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            totalSum += num;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            currentSum += nums[i];

            if (currentSum % 2 == (totalSum - currentSum) % 2) {
                count++;
            }
        }

        return count;
    }
}