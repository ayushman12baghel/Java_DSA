import java.util.*;

public class Maximum_Candies_Allocated_to_K_Children {

    public static int maximumCandies(int candies[], int k) {
        int n = candies.length;
        long total = 0;
        int maxCandies = candies[0];

        for (int candy : candies) {
            total += candy;
            maxCandies = Math.max(maxCandies, candy);
        }

        if (total < k) {
            return 0;
        }

        int left = 1;
        int right = maxCandies;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(candies, mid, k)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int nums[], int target, long k) {
        long count = 0;

        for (int num : nums) {
            count += (num / target);

            if (count >= k) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int candies[] = { 5, 8, 6 };
        int k = 3;

        System.out.println(maximumCandies(candies, k));
    }
}
