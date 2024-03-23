import java.util.*;

public class Valid_Parentheses {
    public static boolean ValidParentheses(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (s.isEmpty()) {
                s.push(str.charAt(i));
            } else if (s.peek() == '(' && str.charAt(i) == ')') {
                s.pop();
            } else if (s.peek() == '[' && str.charAt(i) == ']') {
                s.pop();
            } else if (s.peek() == '{' && str.charAt(i) == '}') {
                s.pop();
            } else {
                s.push(str.charAt(i));
            }
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        String str = "(){}[]";
        System.out.println(ValidParentheses(str));
    }
}
