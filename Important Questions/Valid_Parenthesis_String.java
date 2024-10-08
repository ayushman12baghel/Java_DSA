import java.util.*;

public class Valid_Parenthesis_String {

    public static boolean checkValidString(String str) {
        int maxOpen = 0;
        int minOpen = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '(') {
                maxOpen++;
                minOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else {// *
                minOpen--;
                maxOpen++;
            }

            if (minOpen < 0) {
                minOpen = 0;
            }

            if (maxOpen < 0) {
                return false;
            }
        }

        return minOpen == 0;
    }

    public static void main(String args[]) {
        String str = "(*))";

        System.out.println(checkValidString(str));
    }
}
