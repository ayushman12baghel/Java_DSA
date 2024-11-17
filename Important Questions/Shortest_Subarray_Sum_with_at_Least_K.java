import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Shortest_Subarray_Sum_with_at_Least_K {

    public static int shortestSubarray(int nums[], int k) {
        int n = nums.length;
        long prefix[] = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefix[i] - prefix[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }

            while (!deque.isEmpty() && prefix[i] <= prefix[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String args[]) {
        int nums[] = { 2, -1, 2 };
        int k = 3;

        System.out.println(shortestSubarray(nums, k));
    }
}
