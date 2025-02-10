import java.util.*;

public class Clear_Digits {

    // Approach 1 O(n2)
    public static String clearDigits(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < sb.length()) {
            if (Character.isDigit(str.charAt(i))) {
                sb.deleteCharAt(i);

                if (i > 0) {
                    sb.deleteCharAt(i - 1);
                    i--;
                }
            } else {
                i++;
            }
        }

        return sb.toString();
    }

    // Approach 2 Stack O(n) O(n) space

    public static String clearDigits2(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c) && !stack.isEmpty()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    // Approach 3 O(n) O(1) space
    public static String clearDigits3(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c) && sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String args[]) {
        String str = "cb34";
        System.out.println(clearDigits(str).length());
        System.out.println(clearDigits2(str).length());
        System.out.println(clearDigits3(str).length());
    }
}
