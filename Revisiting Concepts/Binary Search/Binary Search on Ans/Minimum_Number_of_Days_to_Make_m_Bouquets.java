import java.util.*;

public class Minimum_Number_of_Days_to_Make_m_Bouquets {

    // Binary Search on Ans O(nlogn)
    public static int minDays(int[] bloomDay, int m, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < bloomDay.length; i++) {
            max = Math.max(max, bloomDay[i]);
            min = Math.min(min, bloomDay[i]);
        }

        int left = min;
        int right = max;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(bloomDay, m, k, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int nums[], int m, int k, int mid) {
        int count = 0;
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid) {
                count++;
            } else {
                count = 0;
            }

            if (count >= k) {
                ans++;
                count = 0;
            }
        }

        return ans >= m;
    }

    public static void main(String[] args) {
        int bloomDay[] = { 7, 7, 7, 7, 12, 7, 7 }, m = 2, k = 3;

        System.out.println(minDays(bloomDay, m, k));
    }
}
