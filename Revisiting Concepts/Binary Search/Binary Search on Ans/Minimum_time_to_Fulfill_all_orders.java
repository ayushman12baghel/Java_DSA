import java.util.*;

// Approach Using Binary Search on Ans O(nlogm)
class Solution {
    public int minTime(int[] ranks, int n) {
        int minRank = Integer.MAX_VALUE;

        for (int num : ranks) {
            minRank = Math.min(minRank, num);
        }

        long left = 0;
        long right = 1L * minRank * n * (n + 1) / 2;
        long result = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (isPossible(ranks, mid, n)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (int) result;
    }

    public boolean isPossible(int ranks[], long mid, int n) {
        long count = 0;

        for (int rank : ranks) {
            long k = (long) ((-1 + Math.sqrt(1 + 8.0 * mid / rank)) / 2);
            count += k;

            if (count >= n) {
                return true;
            }
        }

        return false;
    }
}