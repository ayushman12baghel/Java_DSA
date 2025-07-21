import java.util.*;

public class Maximum_Running_Time_of_N_batteries {

    // Binary Search on Ans
    public static long maxRunTime(int n, int[] batteries) {
        long left = 0;
        long right = 0;

        for (int num : batteries) {
            right += num;
        }

        long result = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (isPossible(n, batteries, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int n, int batteries[], long target) {
        long total = 0;

        for (int num : batteries) {
            total += Math.min(num, target);
        }

        return total >= n * target;
    }

    public static void main(String[] args) {
        int n = 2;
        int batteries[] = { 3, 3, 3 };

        System.out.println(maxRunTime(n, batteries));
    }
}
