import java.util.*;

//Approach 1
class Solution {
    public int smallestRepunitDivByK(int k) {
        if (1 % k == 0) {
            return 1;
        }
        int length = 1;
        int mod = k;
        int prefix = 1;
        Set<Integer> set = new HashSet<>();
        set.add(1);

        while (true) {
            prefix = (prefix * 10 + 1) % mod;
            if (prefix % mod == 0) {
                return length + 1;
            } else if (set.contains(prefix % mod)) {
                return -1;
            } else {
                set.add(prefix % mod);
            }
            length++;
        }
    }
}

// Approach 2
class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k == 1) {
            return 1;
        }

        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }

        int remain = 0;

        for (int length = 1; length <= k; length++) {
            remain = (remain * 10 + 1) % k;

            if (remain == 0) {
                return length;
            }
        }

        return -1;
    }
}