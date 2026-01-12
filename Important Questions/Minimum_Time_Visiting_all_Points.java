import java.util.*;

// O(n)
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int count = 0;

        for (int i = 1; i < points.length; i++) {
            int prevX = points[i - 1][0];
            int prevY = points[i - 1][1];
            int x = points[i][0];
            int y = points[i][1];

            count += Math.max(Math.abs(prevX - x), Math.abs(prevY - y));
        }

        return count;
    }
}