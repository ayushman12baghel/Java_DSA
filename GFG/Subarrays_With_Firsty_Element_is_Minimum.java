import java.util.*;

//Approach Using Stack O(n)
class Solution {
    public int countSubarrays(int[] nums) {
        int n = nums.length;

        Stack<Integer> stack = new Stack<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i]) {
                stack.pop();
            }

            stack.push(nums[i]);
            count += stack.size();
        }

        return count;
    }
}
