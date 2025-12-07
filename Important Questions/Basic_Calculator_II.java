import java.util.*;

//Approach 1 Using Stack O(n)
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        char lastSign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c != ' ') {
                if (lastSign == '+') {
                    stack.push(number);
                } else if (lastSign == '-') {
                    stack.push(-number);
                } else if (lastSign == '/') {
                    stack.push(stack.pop() / number);
                } else if (lastSign == '*') {
                    stack.push(stack.pop() * number);
                }

                lastSign = c;
                number = 0;
            }
        }

        if (lastSign == '+') {
            stack.push(number);
        } else if (lastSign == '-') {
            stack.push(-number);
        } else if (lastSign == '/') {
            stack.push(stack.pop() / number);
        } else if (lastSign == '*') {
            stack.push(stack.pop() * number);
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }
}

// Approach 2 Without Using Space O(n)
class Solution {
    public int calculate(String s) {
        int sum = 0;
        int last = 0;
        int number = 0;
        char lastSign = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (c != ' ') {
                if (lastSign == '+') {
                    sum += last;
                    last = number;
                } else if (lastSign == '-') {
                    sum += last;
                    last = -number;
                } else if (lastSign == '/') {
                    last = last / number;
                } else if (lastSign == '*') {
                    last = last * number;
                }

                lastSign = c;
                number = 0;
            }
        }

        if (lastSign == '+') {
            sum += last;
            last = number;
        } else if (lastSign == '-') {
            sum += last;
            last = -number;
        } else if (lastSign == '/') {
            last = last / number;
        } else if (lastSign == '*') {
            last = last * number;
        }

        return sum + last;
    }
}