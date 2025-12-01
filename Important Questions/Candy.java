import java.util.*;

public class Candy {

    // Approach 1 O(n) space
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int ans = 0;

        int left[] = new int[n];
        int right[] = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            ans += Math.max(left[i], right[i]);
        }

        return ans;
    }

    public static void main(String args[]) {
        int ratings[] = { 1, 0, 2 };
        System.out.println(candy(ratings));
    }
}

// Approach 2
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int count[] = new int[n];
        Arrays.fill(count, 1);
        int candy = n;
        int i = 1;

        while (i < n) {
            if (ratings[i] == ratings[i - 1]) {
                i++;
                continue;
            }

            int peak = 0;
            while (ratings[i] > ratings[i - 1]) {
                peak++;
                candy += peak;
                i++;

                if (i == n) {
                    return candy;
                }
            }

            int dip = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
                dip++;
                candy += dip;
                i++;
            }

            candy -= Math.min(peak, dip);
        }

        return candy;
    }
}