import java.util.*;

//Approach Using Stack O(n)
class Solution {
    public int maxPeople(int[] nums) {
        int n = nums.length;

        int pse[] = previousSmallerElement(nums);
        int nse[] = nextGreaterElement(nums);

        int maxAns = 0;

        for (int i = 0; i < n; i++) {
            int leftCount = i - pse[i];
            int rightCount = nse[i] - i;

            maxAns = Math.max(maxAns, rightCount + leftCount - 1);
        }

        return maxAns;
    }

    public int[] previousSmallerElement(int nums[]) {
        int n = nums.length;

        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
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

    public int[] nextGreaterElement(int nums[]) {
        int n = nums.length;

        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
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
