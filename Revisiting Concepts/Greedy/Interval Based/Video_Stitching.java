import java.util.*;

//Approach Greedy O(n)
class Solution {
    public int videoStitching(int[][] clips, int time) {
        int maxReach[] = new int[time + 1];

        for (int clip[] : clips) {
            int left = clip[0];
            int right = clip[1];
            if (left < time) {
                maxReach[left] = Math.max(maxReach[left], right);
            }
        }

        int count = 0;
        int currentEnd = 0;
        int maxEnd = 0;

        for (int i = 0; i < maxReach.length; i++) {
            maxEnd = Math.max(maxReach[i], maxEnd);

            if (i == currentEnd) {
                if (i >= maxEnd) {
                    return -1;
                }

                count++;
                currentEnd = maxEnd;
            }

            if (currentEnd >= time) {
                return count;
            }
        }

        return -1;
    }
}