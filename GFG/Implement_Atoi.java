import java.util.*;

class Solution {
    public int myAtoi(String s) {
        // code here
        s = s.trim();

        if (s.length() == 0) {
            return 0;
        }

        int sign = 1;
        if (s.charAt(0) == '-') {
            sign = -1;
        }

        int index = (s.charAt(0) == '+' || s.charAt(0) == '-') ? 1 : 0;
        long ans = 0;

        while (index < s.length()) {
            if (s.charAt(index) == ' ' || !Character.isDigit(s.charAt(index))) {
                break;
            }

            ans = (ans * 10 + (s.charAt(index) - '0'));
            if (sign == -1 && ans > (long) Integer.MAX_VALUE + 1) {
                return Integer.MIN_VALUE;
            }

            if (sign == 1 && Integer.MAX_VALUE < ans) {
                return Integer.MAX_VALUE;
            }

            index++;
        }

        return (int) (sign * ans);
    }
}