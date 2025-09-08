import java.util.*;

//O(n*logn)
class Solution {
    public int[] getNoZeroIntegers(int n) {
        for (int i = 1; i < n; i++) {
            int j = n - i;

            if (!containsZero(i) && !containsZero(j)) {
                return new int[] { i, j };
            }
        }

        return new int[] { 0, 0 };
    }

    public boolean containsZero(int n) {
        while (n > 0) {
            int ld = n % 10;
            if (ld == 0) {
                return true;
            }

            n /= 10;
        }

        return false;
    }
}