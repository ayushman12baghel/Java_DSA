import java.util.*;

//O(log(n))
class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev = n & 1;
        n = n >> 1;

        while (n > 0) {
            int current = n & 1;
            if (prev == current) {
                return false;
            }

            prev = current;
            n = n >> 1;
        }

        return true;
    }
}