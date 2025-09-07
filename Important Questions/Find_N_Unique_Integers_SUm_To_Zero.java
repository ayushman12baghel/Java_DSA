import java.util.*;

class Solution {
    public int[] sumZero(int n) {
        int ans[] = new int[n];
        int x = 0;

        for (int i = 1; i <= n / 2; i++) {
            ans[x++] = i;
            ans[x++] = -i;
        }

        if (n % 2 != 0) {
            ans[x++] = 0;
        }

        return ans;
    }
}