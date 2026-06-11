import java.util.*;

class Solution {
    int findIndex(String s) {
        int n = s.length();

        int close = 0;
        for (char ch : s.toCharArray()) {
            if (ch == ')')
                close++;
        }

        int open = 0;

        for (int i = 0; i < n; i++) {
            if (open == close)
                return i;

            if (s.charAt(i) == '(')
                open++;
            else
                close--;
        }

        return n;
    }
}