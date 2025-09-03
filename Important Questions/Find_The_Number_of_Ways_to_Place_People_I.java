import java.util.*;

//Approach 1 Brute Force O(n^3)
class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }

                int x2 = points[j][0];
                int y2 = points[j][1];
                boolean isPossible = true;

                if (x2 >= x1 && y1 >= y2) {
                    for (int k = 0; k < n; k++) {
                        if (i == k || j == k) {
                            continue;
                        }

                        int x3 = points[k][0];
                        int y3 = points[k][1];

                        if ((x2 >= x3 && x3 >= x1) && (y1 >= y3 && y3 >= y2)) {
                            isPossible = false;
                            break;
                        }
                    }

                    if (isPossible) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}

// Approach 2 Using SOrting
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