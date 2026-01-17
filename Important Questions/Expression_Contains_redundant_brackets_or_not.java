import java.util.*;

// Approach Using Stack O(n)
class Solution {
    public static boolean checkRedundancy(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c != ')') {
                stack.push(c);
            } else {
                boolean found = false;

                while (!stack.isEmpty() && stack.peek() != '(') {
                    if (check(stack.peek())) {
                        found = true;
                    }

                    stack.pop();
                }
                stack.pop();

                if (!found) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean check(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
