import java.util.*;

//Approach O(n^2)
class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;

        long ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int overlapWidth = Math.min(topRight[i][0], topRight[j][0])
                        - Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int overlapHeight = Math.min(topRight[i][1], topRight[j][1])
                        - Math.max(bottomLeft[i][1], bottomLeft[j][1]);

                if (overlapWidth > 0 && overlapHeight > 0) {
                    int overlap = Math.min(overlapWidth, overlapHeight);
                    ans = Math.max(ans, 1L * overlap * overlap);
                }
            }
        }

        return ans;
    }
}