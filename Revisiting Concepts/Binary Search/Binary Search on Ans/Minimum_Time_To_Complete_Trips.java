import java.util.*;

public class Minimum_Time_To_Complete_Trips {

    // Approach Using Binary Search O(min(time[i])*log(min(time[i])*totalTrips))
    public static long minimumTime(int[] time, int totalTrips) {
        long left = 1;
        long right = Long.MAX_VALUE;

        for (int i = 0; i < time.length; i++) {
            right = Math.min(time[i], right);
        }

        right *= totalTrips;
        long result = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (isPossible(time, mid, totalTrips)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int time[], long mid, int totalTrips) {
        long count = 0;

        for (int num : time) {
            count += (mid / num);
        }

        return count >= totalTrips;
    }

    public static void main(String[] args) {
        int time[] = { 1, 2, 3 };
        int totalTrips = 5;

        System.out.println(minimumTime(time, totalTrips));
    }
}
