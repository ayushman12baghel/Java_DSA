import java.util.*;

//Approach Greedy O(n)
class Solution {
    public int minTaps(int n, int[] ranges) {
        int maxReach[] = new int[n + 1];

        for (int i = 0; i < ranges.length; i++) {
            int left = Math.max(0, i - ranges[i]);
            int right = Math.min(n, i + ranges[i]);

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

                currEnd = maxEnd;
                count++;
            }

            if (currEnd >= n) {
                return count;
            }
        }

        return -1;
    }
}