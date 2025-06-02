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
