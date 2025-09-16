import java.util.*;

//Approach Using Stack
class Solution {
    public int evaluatePostfix(String[] arr) {
        int n = arr.length;

        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for (String str : arr) {

            if ((Character.isDigit(str.charAt(0))) || (str.length() > 1 && str.charAt(0) == '-')) {
                stack.push(Integer.parseInt(str));
            } else {
                int value1 = stack.pop();
                int value2 = stack.pop();

                if (str.equals("*")) {
                    stack.push(value2 * value1);
                } else if (str.equals("+")) {
                    stack.push(value2 + value1);
                } else if (str.equals("-")) {
                    stack.push(value2 - value1);
                } else if (str.equals("/")) {
                    stack.push(floorDiv(value2, value1));
                } else if (str.equals("^")) {
                    stack.push((int) Math.pow(value2, value1));
                }
            }
        }

        return stack.pop();
    }

    public int floorDiv(int a, int b) {
        if (a * b < 0 && a % b != 0) {
            return a / b - 1;
        }

        return a / b;
    }
}