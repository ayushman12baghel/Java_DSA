import java.util.*;

//Approach Using Stack O(n)
class Solution {
    public int sumOfMax(int[] nums) {
        int n = nums.length;

        int leftMin[] = new int[n];
        int rightMin[] = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                leftMin[i] = -1;
            } else {
                leftMin[i] = stack.peek();
            }

            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                rightMin[i] = n;
            } else {
                rightMin[i] = stack.peek();
            }

            stack.push(i);
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int leftCount = i - leftMin[i];
            int rightCount = rightMin[i] - i;
            ans += (rightCount * leftCount * nums[i]);
        }

        return ans;
    }
}