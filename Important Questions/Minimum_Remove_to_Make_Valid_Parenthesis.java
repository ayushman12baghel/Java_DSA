import java.util.*;

public class Minimum_Remove_to_Make_Valid_Parenthesis {

    // Approach 1 Using Stack and Set T.C => O(n) Space => O(n)
    public static String minRemoveToMakeValid(String str) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ')') {
                if (stack.isEmpty()) {
                    set.add(i);
                } else {
                    stack.pop();
                }
            } else if (c == '(') {
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            set.add(stack.pop());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (!set.contains(i)) {
                sb.append(str.charAt(i));
            }
        }

        return sb.toString();
    }

    // Approach 2 Using 2 Passes T.C => O(n) Space => O(1)
    public static String minRemoveToMakeValid2(String str) {
        int open = 0;
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c == '(') {
                open++;
                sb.append(c);
            } else if (c == ')') {
                if (open == 0) {
                    continue;
                } else {
                    open--;
                    sb.append(c);
                }
            } else {
                sb.append(c);
            }
        }

        while (open > 0) {
            for (int i = sb.length() - 1; i >= 0; i--) {
                if (sb.charAt(i) == '(') {
                    sb.deleteCharAt(i);
                    open--;
                    break;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        String str = "lee(t(c)o)de)";

        System.out.println(minRemoveToMakeValid(str));
        System.out.println(minRemoveToMakeValid2(str));
    }
}
