import java.util.*;

public class Check_if_Parenthesis_String_can_be_Valid {

    public static boolean canValid(String str, String locked) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> openClose = new Stack<>();
        if (str.length() % 2 != 0) {
            return false;
        }

        for (int i = 0; i < str.length(); i++) {
            if (locked.charAt(i) == '0') {
                openClose.push(i);
            } else if (str.charAt(i) == '(') {
                open.push(i);
            } else {
                if (!open.isEmpty()) {
                    open.pop();
                } else if (!openClose.isEmpty()) {
                    openClose.pop();
                } else {
                    return false;
                }
            }
        }

        while (!open.isEmpty() && !openClose.isEmpty() && open.peek() < openClose.peek()) {
            open.pop();
            openClose.pop();
        }

        return open.isEmpty();
    }

    // Constant Space

    public static boolean canBeValid2(String s, String locked) {
        if (s.length() % 2 != 0) {
            return false;
        }

        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || locked.charAt(i) == '0') {
                open++;
            } else {
                open--;
            }

            if (open < 0) {
                return false;
            }
        }

        int close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')' || locked.charAt(i) == '0') {
                close++;
            } else {
                close--;
            }

            if (close < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        String str = "))()))";
        String locked = "010100";

        System.out.println(canValid(str, locked));
        System.out.println(canBeValid2(str, locked));
    }
}
