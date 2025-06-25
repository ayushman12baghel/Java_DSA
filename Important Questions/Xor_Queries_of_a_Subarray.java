import java.util.*;

public class Xor_Queries_of_a_Subarray {

    // Approach 1 Brute Force O(n*m)
    public static int[] xorQueries(int[] arr, int[][] queries) {
        int ans[] = new int[queries.length];
        int j = 0;

        for (int query[] : queries) {
            int left = query[0];
            int right = query[1];
            int sum = 0;

            for (int i = left; i <= right; i++) {
                sum ^= arr[i];
            }
            ans[j++] = sum;
        }

        return ans;
    }

    // Approach 2 Optimised O(n+m)
    public static int[] xorQueries2(int[] arr, int[][] queries) {
        int prefix[] = new int[arr.length];
        prefix[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            prefix[i] = arr[i] ^ prefix[i - 1];
        }

        int ans[] = new int[queries.length];
        int i = 0;

        for (int query[] : queries) {
            int left = query[0];
            int right = query[1];

            if (left == 0) {
                ans[i++] = prefix[right];
            } else {
                ans[i++] = prefix[right] ^ prefix[left - 1];
            }
        }

        return ans;
    }
}
