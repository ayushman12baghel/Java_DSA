import java.util.*;

public class Sliding_Window_Maximum {

    public static int[] maxSlidingWindow(int nums[], int k) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.addLast(i);

            if (i >= k - 1) {
                result.add(nums[deque.peekFirst()]);
            }
        }

        int ans[] = new int[result.size()];
        int i = 0;

        for (int num : result) {
            ans[i++] = num;
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        int ans[] = maxSlidingWindow(nums, k);

        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
