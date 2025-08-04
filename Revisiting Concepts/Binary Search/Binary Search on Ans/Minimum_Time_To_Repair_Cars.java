import java.util.*;

public class Minimum_Time_To_Repair_Cars {

    // Approach Using Binary Search on Ans
    public static long repairCars(int ranks[], int cars) {
        long left = 1;
        long right = Long.MIN_VALUE;
        for (int rank : ranks) {
            right = Math.max(right, (long) rank * cars * cars);
        }

        long result = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (isPossible(ranks, mid, cars)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int ranks[], long minutes, int cars) {
        long count = 0;

        for (int rank : ranks) {
            count += Math.sqrt(minutes / rank);
        }

        return count >= cars;
    }

    public static void main(String[] args) {
        int ranks[] = { 4, 2, 3, 1 };
        int cars = 10;

        System.out.println(repairCars(ranks, cars));
    }
}
