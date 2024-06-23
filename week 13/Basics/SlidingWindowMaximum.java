import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int index = 0;
        Deque<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!q.isEmpty() && q.peek() == i - k) {
                q.remove();
            }
            while (!q.isEmpty() && nums[q.peekLast()] < nums[i]) {
                q.removeLast();
            }
            q.add(i);
            if (i >= k - 1) {
                ans[index++] = nums[q.peek()];
            }
        }
        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int k = 3;
        int ans[] = maxSlidingWindow(nums, k);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
