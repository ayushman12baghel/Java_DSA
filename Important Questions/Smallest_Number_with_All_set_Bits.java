import java.util.*;

class Solution {
    public int smallestNumber(int n) {
        if (n == 1) {
            return 1;
        }

        int countBit = getBitCount(n);

        int ans = (1 << countBit) - 1;

        return ans;
    }

    public int getBitCount(int n) {
        int count = 0;

        while (n != 0) {
            n /= 2;
            count++;
        }

        return count;
    }
}

class Solution {
    public int smallestNumber(int n) {
        if (n == 1) {
            return 1;
        }

        int ans = 1;

        while (ans < n) {
            ans = ans * 2 + 1;
        }

        return ans;
    }
}