import java.util.*;

//Approach Greedy O(n)
class Solution {
    public int minMen(int nums[]) {
        int n = nums.length;

        int maxReach[] = new int[n + 1];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == -1) {
                continue;
            }

            int left = Math.max(0, i - nums[i]);
            int right = Math.min(n, i + nums[i] + 1);

            maxReach[left] = Math.max(maxReach[left], right);
        }

        int maxEnd = 0;
        int currEnd = 0;
        int count = 0;

        for (int i = 0; i < maxReach.length; i++) {
            maxEnd = Math.max(maxEnd, maxReach[i]);

            if (i >= currEnd) {
                if (i >= maxEnd) {
                    return -1;
                }

                count++;
                currEnd = maxEnd;
            }

            if (currEnd >= n) {
                return count;
            }
        }

        return -1;
    }
}