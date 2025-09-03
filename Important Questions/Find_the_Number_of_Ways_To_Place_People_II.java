import java.util.*;

class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;

        Arrays.sort(points, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int count = 0;

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            int bestY = Integer.MIN_VALUE;

            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];

                if (y1 < y2) { // x2 and y2 should be above x1 and y1
                    continue;
                }

                if (y2 > bestY) {
                    count++;
                    bestY = y2;
                }
            }
        }

        return count;
    }
}