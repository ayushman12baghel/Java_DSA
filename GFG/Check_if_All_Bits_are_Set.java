import java.util.*;

//O(n)
class Solution {
    public boolean isBitSet(int n) {
        if (n == 0) {
            return false;
        }

        int x = n + 1;
        return (x & (x - 1)) == 0;
    }
};