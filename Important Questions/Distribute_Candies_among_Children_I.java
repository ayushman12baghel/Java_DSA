import java.util.*;

public class Distribute_Candies_among_Children_I {

    // Approach 1 Brute Force O(n^3)
    public static int distributeCandies(int n, int limit) {
        int count = 0;

        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                for (int k = 0; k <= limit; k++) {
                    if (i + j + k == n) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    // Little Optimised
    public static int distributeCandies2(int n, int limit) {
        int count = 0;

        for (int i = 0; i <= n; i++) {
            if (i > limit) {
                continue;
            }
            for (int j = 0; j <= n - i; j++) {
                if (j > limit) {
                    continue;
                }
                for (int k = 0; k <= n - i - j; k++) {
                    if (k > limit) {
                        continue;
                    }
                    if (i + j + k == n) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    // Approach 2
    public static int distributeCandies3(int n, int limit) {
        int count = 0;

        for (int i = 0; i <= Math.min(limit, n); i++) {
            for (int j = 0; j <= Math.min(limit, n - i); j++) {
                int k = n - i - j;

                if (k >= 0 && k <= limit) {
                    count++;
                }
            }
        }

        return count;
    }

    // Approach 3
    public static int distributeCandies4(int n, int limit) {
        int count = 0;

        int minCh1 = Math.max(0, n - 2 * limit);
        int maxCh1 = Math.min(n, limit);

        for (int i = minCh1; i <= maxCh1; i++) {// fixing Child1
            int N = n - i;// for child2 and child3

            int minCh2 = Math.max(0, N - limit);
            int maxCh2 = Math.min(N, limit);

            count += (maxCh2 - minCh2 + 1);
        }

        return count;
    }

    public static void main(String args[]) {
        int n = 3, limit = 3;
        System.out.println(distributeCandies(n, limit));
        System.out.println(distributeCandies2(n, limit));
        System.out.println(distributeCandies3(n, limit));
        System.out.println(distributeCandies4(n, limit));
    }
}
