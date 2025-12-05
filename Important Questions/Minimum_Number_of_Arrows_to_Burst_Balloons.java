import java.util.*;

// Approach 1 Sorting Based on Start Interval
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int prev[] = points[0];
        int count = 1;

        for (int i = 1; i < points.length; i++) {
            int prevStart = prev[0];
            int prevEnd = prev[1];
            int currentStart = points[i][0];
            int currentEnd = points[i][1];

            if (prevEnd < currentStart) {
                count++;
                prev = points[i];
            } else {
                prev[0] = Math.max(prevStart, currentStart);
                prev[1] = Math.min(currentEnd, prevEnd);
            }
        }

        return count;
    }
}

// Approach 2 Sorting Based on End Interval
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int prevEnd = points[0][1];
        int count = 1;

        for (int i = 1; i < points.length; i++) {
            int currentStart = points[i][0];

            if (currentStart > prevEnd) {
                prevEnd = points[i][1];
                count++;
            }
        }

        return count;
    }
}