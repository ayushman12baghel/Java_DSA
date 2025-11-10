import java.util.*;

//Approach 1 Brute Force O(n^2)
class Solution {
    public int minOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (num != 0) {
                set.add(num);
            }
        }

        int operations = 0;

        for (int num : set) {
            boolean pass = false;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == num) {
                    if (!pass) {
                        pass = true;
                        operations++;
                    }
                } else {
                    if (num > nums[i]) {
                        pass = false;
                    }
                }
            }
        }

        return operations;
    }
}

// Approach 2 Using Stack O(n)
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        Stack<Integer> stack = new Stack<>();
        int operations = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i]) {
                stack.pop();
            }

            if (nums[i] == 0) {
                continue;
            }

            if (stack.isEmpty() || stack.peek() < nums[i]) {
                operations++;
                stack.push(nums[i]);
            }
        }

        return operations;
    }
}