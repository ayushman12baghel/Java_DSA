import java.util.*;

//O(n^2)
class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder(s);

        while (n > 2) {
            for (int i = 0; i < n - 1; i++) {
                int a = sb.charAt(i) - '0';
                int b = sb.charAt(i + 1) - '0';
                int sum = (a + b) % 10;
                sb.setCharAt(i, (char) (sum + '0'));
            }
            n--;
        }

        return sb.charAt(0) == sb.charAt(1);
    }
}