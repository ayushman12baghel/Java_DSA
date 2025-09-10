import java.util.*;

class Solution {
    public int myAtoi(String s) {
        s = s.trim();

        if (s.length() == 0) {
            return 0;
        }

        int sign = 1;
        long ans = 0;
        if (s.charAt(0) == '-') {
            sign = -1;
        }

        int index = (s.charAt(0) == '-' || s.charAt(0) == '+' ? 1 : 0);

        while (index < s.length()) {
            if (s.charAt(index) == ' ' || !Character.isDigit(s.charAt(index))) {
                break;
            }

            ans = (ans * 10 + (s.charAt(index) - '0'));

            if (sign == -1 && -1 * ans < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            if (sign == 1 && ans > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            index++;
        }

        return (int) (sign * ans);
    }
}