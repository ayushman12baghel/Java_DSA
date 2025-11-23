import java.util.*;

//O(n)
class Solution {
    public int[] lexSmallestNegatedPerm(int n, long target) {
        long totalSum = (long) n * (n + 1) / 2;

        if (Math.abs(target) > totalSum || (totalSum - target) % 2 != 0) {
            return new int[] {};
        }

        boolean isNegative[] = new boolean[n + 1];
        long needNegative = (totalSum - target) / 2;

        for (int i = n; i >= 1; i--) {
            if (needNegative >= i) {
                isNegative[i] = true;
                needNegative -= i;
            }
        }

        int ans[] = new int[n];
        int index = 0;
        for (int i = n; i >= 1; i--) {
            if (isNegative[i]) {
                ans[index++] = -i;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!isNegative[i]) {
                ans[index++] = i;
            }
        }

        return ans;
    }
}