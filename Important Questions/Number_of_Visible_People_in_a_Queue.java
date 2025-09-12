import java.util.*;

//Microsoft Online Interview
//Approach Using Stack O(n)
class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            int count = 0;

            while (!stack.isEmpty() && stack.peek() < heights[i]) {
                stack.pop();
                count++;
            }

            count = (!stack.isEmpty() ? count + 1 : count);
            ans[i] = count;
            stack.push(heights[i]);
        }

        return ans;
    }
}
