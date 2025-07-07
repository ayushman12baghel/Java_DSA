import java.util.*;

public class Continuous_Subarrays {

    // Approach 1 Using Treemap and Sliding Window O(n) as the size of the map will
    // not exceed 3 and O(1) space complexity
    public static long continuousSubarrays(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int i = 0;
        int j = 0;
        long ans = 0;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.lastKey() - map.firstKey() > 2) {
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;
            }

            ans += (j - i + 1);

            j++;
        }

        return ans;
    }

    // Approach Using 2 Deques Sliding Window O(n)
    public static long continuousSubarrays2(int[] nums) {
        int n = nums.length;
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        long ans = 0;

        while (j < n) {
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[j]) {
                maxDeque.pollLast();
            }

            maxDeque.offerLast(j);

            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[j]) {
                minDeque.pollLast();
            }

            minDeque.offerLast(j);

            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > 2) {
                if (maxDeque.peekFirst() == i) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() == i) {
                    minDeque.pollFirst();
                }

                i++;
            }

            ans += (j - i + 1);

            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums[] = { 5, 4, 2, 4 };

        System.out.println(continuousSubarrays(nums));
        System.out.println(continuousSubarrays2(nums));
    }
}
