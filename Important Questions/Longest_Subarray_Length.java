import java.util.*;

//O(n)
class Solution {
    public static int longestSubarray(int[] nums) {
        int pge[] = previousGreaterElement(nums);
        int nge[] = nextGreaterElement(nums);

        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            int left = pge[i];
            int right = nge[i];

            if (right - left - 1 >= nums[i]) {
                maxLength = Math.max(maxLength, right - left - 1);
            }
        }

        return maxLength;
    }

    public static int[] previousGreaterElement(int nums[]) {
        int n = nums.length;

        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }

            stack.push(i);
        }

        return ans;
    }

    public static int[] nextGreaterElement(int nums[]) {
        int n = nums.length;

        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[i] = n;
            } else {
                ans[i] = stack.peek();
            }

            stack.push(i);
        }

        return ans;
    }
}