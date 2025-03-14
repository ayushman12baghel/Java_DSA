import java.util.*;

public class Maximum_Candies_Allocated_to_K_Children {

    // Approach 1 Using Greedy O(n*max(nums[i]))
    public static int maximumCandies(int[] candies, long k) {
        int maxCandies = candies[0];

        for (int i = 1; i < candies.length; i++) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }

        for (int i = maxCandies; i >= 1; i--) {
            int count = 0;

            for (int j = 0; j < candies.length; j++) {
                count += candies[j] / i;
            }

            if (count >= k) {
                return i;
            }
        }

        return 0;
    }

    // Approach 2 Using Binary Search O(nlogn)
    public static int maximumCandies2(int[] candies, int k) {
        int maxCandies = candies[0];
        long total = candies[0];

        for (int i = 1; i < candies.length; i++) {
            maxCandies = Math.max(maxCandies, candies[i]);
            total += candies[i];
        }

        if (total < k) {
            return 0;
        }

        int left = 1;
        int right = maxCandies;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (solve(candies, k, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static boolean solve(int candies[], long k, int mid) {
        long count = 0;

        for (int j = 0; j < candies.length; j++) {
            count += candies[j] / mid;
        }

        if (count >= k) {
            return true;

        }

        return false;
    }

    public static void main(String args[]) {
        int candies[] = { 5, 8, 6 };
        int k = 3;
        System.out.println(maximumCandies(candies, k));
        System.out.println(maximumCandies2(candies, k));
    }
}