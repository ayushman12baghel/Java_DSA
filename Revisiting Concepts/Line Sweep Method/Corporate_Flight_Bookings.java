import java.util.*;

// Approach Using Difference Array Technique O(n)
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int diff[] = new int[n];

        for (int booking[] : bookings) {
            int left = booking[0] - 1;
            int right = booking[1] - 1;
            int people = booking[2];

            diff[left] += people;
            if (right + 1 < n) {
                diff[right + 1] -= people;
            }
        }

        int currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += diff[i];
            diff[i] = currentSum;
        }

        return diff;
    }
}