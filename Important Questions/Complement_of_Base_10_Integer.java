import java.util.*;

// Approach 1 O(log(n))
class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }

        int mask = 1;
        while (mask < n) {
            mask = (mask << 1) | 1;
        }

        return n ^ mask;
    }

}

    // Approach 2class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) {
            return 1;
        }

        int temp = n;
        int ans = 0;

        for (int i = 0; i < 32; i++) {
            if (temp == 0) {
                break;
            }

            int bit = (n >> i) & 1;
            int flipped = bit ^ 1;
            ans = ans | (flipped << i);
            temp >>= 1;
        }

        return ans;
    }
}