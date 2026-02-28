import java.util.*;

// Approach 1 O(n)
class Solution {
    public int concatenatedBinary(int n) {
        int mod = (int) 1e9 + 7;
        long result = 0;

        for (int i = 1; i <= n; i++) {
            int digits = (int) (Math.log(i) / Math.log(2)) + 1;
            result = ((result << digits) % mod + i) % mod;
        }

        return (int) result;
    }
}

// Approach 2
class Solution {
    public int concatenatedBinary(int n) {
        int mod = (int) 1e9 + 7;
        long result = 0;
        int digits = 0;

        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                digits++;
            }

            result = ((result << digits) % mod + i) % mod;
        }

        return (int) result;
    }
}