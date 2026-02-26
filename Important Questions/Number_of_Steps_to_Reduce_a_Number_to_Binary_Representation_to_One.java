import java.util.*;

//Approach Brute Force O(2*n)
class Solution {
    public int numSteps(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        int count = 0;

        while (sb.length() > 1) {
            if (sb.charAt(sb.length() - 1) == '0') {
                sb.deleteCharAt(sb.length() - 1);
                count++;
            } else {
                addOne(sb);
                count++;
            }
        }

        return count;
    }

    public void addOne(StringBuilder sb) {
        int n = sb.length();

        int carry = 1;
        int i = n - 1;

        while (i >= 0 && carry != 0) {
            int current = sb.charAt(i) == '0' ? 0 : 1;
            int sum = current + carry;
            carry = sum / 2;
            sb.setCharAt(i, (char) ((sum % 2) + '0'));
            i--;
        }

        if (carry != 0) {
            sb.insert(0, '1');
        }
    }
}