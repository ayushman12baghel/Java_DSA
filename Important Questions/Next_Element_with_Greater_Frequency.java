import java.util.*;

//Approach Using HashMap and Stack O(n)
class Solution {
    public ArrayList<Integer> nextFreqGreater(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && map.get(stack.peek()) <= map.get(nums[i])) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans.add(-1);
            } else {
                ans.add(stack.peek());
            }

            stack.push(nums[i]);
        }

        Collections.reverse(ans);

        return ans;
    }
}