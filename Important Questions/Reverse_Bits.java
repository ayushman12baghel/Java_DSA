import java.util.*;

// O(1)
class Solution {
    public int reverseBits(int n) {
        int ans = 0;

        for (int i = 1; i <= 32; i++) {
            ans <<= 1;
            ans = (ans | (n & 1));
            n >>= 1;
        }

        return ans;
    }
}

// For Negative Integers also
class Solution {
    public int reverseBits(int n) {
        int ans = 0;

        for (int i = 1; i <= 32; i++) {
            ans <<= 1;
            ans = (ans | (n & 1));
            n >>>= 1;
        }

        return ans;
    }
}