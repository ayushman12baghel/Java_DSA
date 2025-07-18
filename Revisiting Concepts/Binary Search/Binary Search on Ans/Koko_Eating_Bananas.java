import java.util.*;

public class Koko_Eating_Bananas {

    // Approach Using Binary Search
    public static int minEatingSpeed(int piles[], int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;

        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(piles, mid, h)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int piles[], int mid, int h) {
        for (int pile : piles) {
            h -= (pile + mid - 1) / mid;

            if (h < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int piles[] = { 3, 6, 7, 11 };
        int h = 8;

        System.out.println(minEatingSpeed(piles, h));
    }
}
