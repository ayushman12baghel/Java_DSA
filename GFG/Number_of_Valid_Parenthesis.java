import java.util.*;

// Approach O(4^n/n^3/2)
class Solution {
    int findWays(int n) {
        if (n % 2 != 0) {
            return 0;
        }

        return solve(n / 2, 0, 0);
    }

    public int solve(int n, int oc, int cc) {
        if (oc == n && cc == n) {
            return 1;
        }

        int count = 0;
        if (oc < n) {
            count += solve(n, oc + 1, cc);
        }
        if (oc > cc) {
            count += solve(n, oc, cc + 1);
        }

        return count;
    }
}
