import java.util.*;

//Approach Using Stack O(n)
class Solution {
    public ArrayList<Integer> calculateSpan(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans.add(i + 1);
            } else {
                ans.add(i - stack.peek());
            }

            stack.push(i);
        }

        return ans;
    }
}