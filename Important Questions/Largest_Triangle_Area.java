import java.util.*;

//Approach 1 O(n^3)
class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    ans = Math.max(ans, getArea(points[i], points[j], points[k]));
                }
            }
        }

        return ans;
    }

    public double getArea(int p1[], int p2[], int p3[]) {
        return 0.5 * Math.abs(
                p1[0] * (p2[1] - p3[1]) +
                        p2[0] * (p3[1] - p1[1]) +
                        p3[0] * (p1[1] - p2[1]));
    }
}