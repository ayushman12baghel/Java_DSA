import java.util.*;

class Solution {
    public boolean isSumOfConsecutive(int n) {
        // code here
        if (n <= 2) {
            return false;
        }

        if ((n & (n - 1)) == 0) {
            return false;
        }

        return true;
    }
}