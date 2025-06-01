import java.util.*;

public class Distribute_Candies_among_Childrens_II {

    // Approach 1 T.L.E
    public static long distributeCandies(int n, int limit) {
        long count = 0;

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

    // Approach 2 O(n)
    public static long distributeCandies2(int n, int limit) {
        long count = 0;

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
    }
}
