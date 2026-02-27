import java.util.*;

// Approach Using BFS O(2^n)
class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= 9; i++) {
            queue.offer(i);
        }

        for (int level = 1; level < n; level++) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                int lastDigit = current % 10;

                if (lastDigit + k <= 9) {
                    queue.offer(current * 10 + (lastDigit + k));
                }

                if (lastDigit - k >= 0 && k > 0) {
                    queue.offer(current * 10 + (lastDigit - k));
                }
            }
        }

        int ans[] = new int[queue.size()];
        int i = 0;
        while (!queue.isEmpty()) {
            ans[i++] = queue.poll();
        }

        return ans;
    }
}