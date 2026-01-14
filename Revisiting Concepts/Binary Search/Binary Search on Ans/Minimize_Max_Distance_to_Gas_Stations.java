import java.util.*;

// Approach Binary Search on Double values O(nlog(gap))
class Solution {
    public double minMaxDist(int[] stations, int K) {
        double left = 0.0;
        double right = 0.0;

        for (int i = 1; i < stations.length; i++) {
            right = Math.max(right, (double) Math.abs(stations[i - 1] - stations[i]));
        }

        while (left < right) {
            if (right - left < 1e-7) {
                break;
            }

            double mid = left + (right - left) / 2.0;

            if (isPossible(stations, mid, K)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return left;
    }

    public boolean isPossible(int stations[], double mid, int k) {
        int usedCount = 0;

        for (int i = 1; i < stations.length; i++) {
            int gap = Math.abs(stations[i] - stations[i - 1]);

            usedCount += (int) gap / mid;
        }

        return usedCount <= k;
    }
}
