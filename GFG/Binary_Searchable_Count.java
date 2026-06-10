import java.util.*;

//Approach O(n)
class Solution {
    public int binarySearchable(int[] arr) {
        int n = arr.length;
        int count = 0;

        java.util.ArrayDeque<long[]> stack = new java.util.ArrayDeque<>();

        stack.push(new long[] { 0, n - 1, Long.MIN_VALUE, Long.MAX_VALUE });

        while (!stack.isEmpty()) {
            long[] cur = stack.pop();

            int l = (int) cur[0];
            int r = (int) cur[1];
            long low = cur[2];
            long high = cur[3];

            if (l > r)
                continue;

            int mid = l + (r - l) / 2;
            int val = arr[mid];

            if (val > low && val < high) {
                count++;
            }

            stack.push(new long[] { l, mid - 1, low, Math.min(high, val) });

            stack.push(new long[] { mid + 1, r, Math.max(low, val), high });
        }

        return count;
    }
}