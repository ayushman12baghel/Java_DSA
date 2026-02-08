import java.util.*;

// Approach Using Difference Array O(n)
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int maxDistance = 0;

        for (int trip[] : trips) {
            maxDistance = Math.max(maxDistance, trip[2]);
        }

        int maxFreq[] = new int[maxDistance + 2];
        for (int trip[] : trips) {
            maxFreq[trip[1]] += trip[0];
            maxFreq[trip[2]] -= trip[0];
        }

        int currentCapacity = 0;

        for (int i = 0; i < maxFreq.length; i++) {
            currentCapacity += maxFreq[i];

            if (currentCapacity > capacity) {
                return false;
            }
        }

        return true;
    }
}