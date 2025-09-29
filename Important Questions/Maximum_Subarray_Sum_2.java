import java.util.*;

//Approach 1 Using Sliding Window TreeMap O(nlogk)
class Solution {
    public int maxSubarrSum(int[] nums, int a, int b) {
        int n = nums.length;

        long prefix[] = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        TreeMap<Long, Integer> map = new TreeMap<>();
        int maxSum = Integer.MIN_VALUE;

        for (int r = 0; r < n; r++) {
            if (r - a + 1 >= 0) {
                long val = prefix[r - a + 1];
                map.put(val, map.getOrDefault(val, 0) + 1);
            }

            if (r - b >= 0) {
                long val = prefix[r - b];
                map.put(val, map.get(val) - 1);
                if (map.get(val) == 0) {
                    map.remove(val);
                }
            }

            if (!map.isEmpty()) {
                long first = map.firstKey();
                long sum = prefix[r + 1] - first;
                maxSum = Math.max(maxSum, (int) sum);
            }
        }

        return maxSum;
    }
}

// Approach 2 Using Deque O(n)
class Solution {
    public int maxSubarrSum(int[] nums, int a, int b) {
        int n = nums.length;

        long prefix[] = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        Deque<Integer> maxDeque = new ArrayDeque<>();
        int maxSum = Integer.MIN_VALUE;

        for (int r = 0; r < n; r++) {
            if (r - a + 1 >= 0) {
                int index = r - a + 1;

                while (!maxDeque.isEmpty() && prefix[maxDeque.peekLast()] >= prefix[index]) {
                    maxDeque.pollLast();
                }

                maxDeque.offerLast(index);
            }

            while (!maxDeque.isEmpty() && maxDeque.peekFirst() < r - b + 1) {
                maxDeque.pollFirst();
            }

            if (!maxDeque.isEmpty()) {
                long sum = prefix[r + 1] - prefix[maxDeque.peekFirst()];
                maxSum = Math.max(maxSum, (int) sum);
            }
        }

        return maxSum;
    }
}