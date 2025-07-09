import java.util.*;

public class Sum_Of_Subarray_Minimums {

    // Stack O(n)
    public static int sumSubarrayMins(int[] nums) {
        int mod = 1000000007;
        int n = nums.length;
        long ans = 0;
        Stack<Integer> stack = new Stack<>();
        int left[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            } else {
                left[i] = -1;
            }

            stack.push(i);
        }

        int right[] = new int[n];
        stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            } else {
                right[i] = n;
            }

            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            long leftCount = i - left[i];
            long rightCount = right[i] - i;
            long contrib = (leftCount * rightCount) % mod;
            contrib = (contrib * nums[i]) % mod;
            ans = (ans + contrib) % mod;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        int nums[] = { 3, 1, 2, 4 };

        System.out.println(sumSubarrayMins(nums));
    }
}
