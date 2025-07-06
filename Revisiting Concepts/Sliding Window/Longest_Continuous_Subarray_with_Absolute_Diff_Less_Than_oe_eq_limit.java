import java.util.*;

public class Longest_Continuous_Subarray_with_Absolute_Diff_Less_Than_oe_eq_limit {

    // Approach 1 Using TreeMap O(nlogL)
    public static int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 0;
        int j = 0;
        int maxLength = 0;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);

            j++;
        }

        return maxLength;
    }

    // Approach 2 Using 2 Deques O(n)
    public static int longestSubarray2(int nums[], int limit) {
        int n = nums.length;
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        int maxLength = 0;

        while (j < n) {
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[j]) {
                maxDeque.pollLast();
            }

            maxDeque.offerLast(j);

            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[j]) {
                minDeque.pollLast();
            }

            minDeque.offerLast(j);

            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                if (maxDeque.peekFirst() == i) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == i) {
                    minDeque.pollFirst();
                }

                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);

            j++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int nums[] = { 10, 1, 2, 4, 7, 2 };
        int limit = 5;

        System.out.println(longestSubarray(nums, limit));
        System.out.println(longestSubarray2(nums, limit));
    }
}
