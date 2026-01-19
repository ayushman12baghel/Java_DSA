import java.util.*;

// Approach Using Stack O(n)
class Solution {
    public String removeKdig(String s, int k) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }

            if (!stack.isEmpty() || c != '0') {
                stack.push(c);
            }
        }

        while (!stack.isEmpty() && k-- > 0) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            stack.push('0');
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}