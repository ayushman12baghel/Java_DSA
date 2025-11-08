import java.util.*;

//Approach Using Binary Search on Ans and Difference Array Technique O(n*(log(sum+k)))
class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;

        long diff[] = new long[n];
        long start = Long.MAX_VALUE;
        long end = 0;
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = i + r;
            diff[left] += stations[i];
            if (right + 1 < n) {
                diff[right + 1] -= stations[i];
            }

            start = Math.min(start, stations[i]);
            end += stations[i];
        }

        end += k;
        long result = start;

        while (start <= end) {
            long mid = start + (end - start) / 2;

            if (isPossible(stations, diff, r, k, mid)) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return result;
    }

    public boolean isPossible(int stations[], long diff[], int r, int k, long mid) {
        int n = stations.length;
        long newDiff[] = Arrays.copyOf(diff, n);
        long cumSum = 0;

        for (int i = 0; i < n; i++) {
            cumSum += newDiff[i];

            if (cumSum < mid) {
                long need = mid - cumSum;
                if (need > k) {
                    return false;
                }

                k -= need;
                cumSum += need;

                if (i + 2L * r + 1 < n) {
                    newDiff[(int) (i + 2L * r + 1)] -= need;
                }
            }
        }

        return true;
    }
}