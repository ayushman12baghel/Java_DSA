import java.util.*;

//Approach Using Binary Search on Ans O(nlog(min(nums)*mountainHeight))
class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 0;
        long right = workerTimes[0];

        for (int num : workerTimes) {
            right = Math.min(right, num);
        }

        right = 1L * right * mountainHeight * (mountainHeight + 1) / 2L;
        long result = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (isPossible(workerTimes, mountainHeight, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public boolean isPossible(int nums[], int target, long k) {
        int count = 0;

        for (int num : nums) {
            long n = (long) ((Math.sqrt(1.0 + 8.0 * ((double) k / num)) - 1.0) / 2);

            count += n;

            if (count >= target) {
                return true;
            }
        }

        return count >= target;
    }
}