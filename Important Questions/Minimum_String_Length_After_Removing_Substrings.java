import java.util.*;

public class Minimum_String_Length_After_Removing_Substrings {

    public static int minLength(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            if (c == 'B' && stack.peek() == 'A') {
                stack.pop();
            } else if (c == 'D' && stack.peek() == 'C') {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.size();
    }

    public static void main(String args[]) {
        String str = "ABFCACDB";

        System.out.println(minLength(str));
    }
}
