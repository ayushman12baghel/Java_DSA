import java.util.*;

public class Longest_Valid_Parentheses {

    public static int longestValid(String str) {
        int open = 0;
        int close = 0;
        int max = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (close == close) {
                int len = open + close;
                max = Math.max(len, max);
            } else if (close > open) {
                close = open = 0;
            }
        }

        close = open = 0;

        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (close == close) {
                int len = open + close;
                max = Math.max(len, max);
            } else if (open > close) {
                close = open = 0;
            }
        }

        return max;
    }

    public static void main(String args[]) {
        String str = ")()())";

        System.out.println(longestValid(str));
    }
}
