import java.util.*;

public class Minimum_Time_to_Repair_Cars {

    // Binary Search on Ans i.e time Time Complexity => O ( Nlog (max time))
    public static long repairCars(int ranks[], int cars) {
        long left = 1;
        long right = 0;

        for (int i = 0; i < ranks.length; i++) {
            right = Math.max(right, (long) ranks[i] * cars * cars);
        }

        long result = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (isPossible(ranks, cars, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int ranks[], int cars, long mid) {
        long count = 0;

        for (int i = 0; i < ranks.length; i++) {
            count += (long) (Math.sqrt(mid / ranks[i]));
        }

        return count >= cars;
    }

    public static void main(String args[]) {
        int ranks[] = { 4, 2, 3, 1 };
        int cars = 10;

        System.out.println(repairCars(ranks, cars));
    }
}