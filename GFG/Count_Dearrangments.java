import java.util.*;

class Solution {
    public int derangeCount(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 0;
        if (n == 2)
            return 1;

        return (n - 1) * (derangeCount(n - 1) + derangeCount(n - 2));
    }
};