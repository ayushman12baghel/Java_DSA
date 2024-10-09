import java.util.*;

public class Minimum_Add_to_Make_Parentheses_Valid {

    public static int minAddToMakeValid(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (c == ')' && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.size();
    }

    public static int minAddToMakeValid2(String str) {
        int open = 0;
        int close = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }

        return open + close;
    }

    public static void main(String args[]) {
        String str = "())";

        System.out.println(minAddToMakeValid(str));
        System.out.println(minAddToMakeValid2(str));
    }
}
