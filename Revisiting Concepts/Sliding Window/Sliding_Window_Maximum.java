import java.util.*;

public class Sliding_Window_Maximum {

    // Approach 1 Using SlidingWindow with TreeMap O(nlogn)
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans[] = new int[n - k + 1];
        int x = 0;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            if (j - i + 1 == k) {
                ans[x++] = map.lastKey();
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;
            }

            j++;
        }

        return ans;
    }

    // Approach 2 Using SlidingWindow with Deque O(n)
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        int x = 0;
        int j = 0;
        Deque<Integer> deque = new ArrayDeque<>();

        while (j < n) {
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[j]) {
                deque.pollLast();
            }

            deque.addLast(j);

            if (deque.peekFirst() <= j - k) {
                deque.pollFirst();
            }

            if (j >= k - 1) {
                ans[x++] = nums[deque.peekFirst()];
            }

            j++;
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int ans[] = maxSlidingWindow(nums, k);

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}
