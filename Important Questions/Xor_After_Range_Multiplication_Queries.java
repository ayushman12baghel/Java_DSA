import java.util.*;

//O(n*m)
class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int mod = 1000000007;

        for (int query[] : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];

            for (int i = l; i <= r; i += k) {
                nums[i] = (int) ((1L * nums[i] * v) % mod);
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= nums[i];
        }

        return result;
    }
}