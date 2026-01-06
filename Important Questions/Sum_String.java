import java.util.*;

//O(n^4)
class Solution {
    public boolean isSumString(String s) {
        int n = s.length();

        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(0) == '0' && i > 1) {
                break;
            }

            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == '0' && j - i > 1) {
                    break;
                }

                if (check(s, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean check(String s, int start, int mid, int end) {
        int n = s.length();
        String num1 = s.substring(start, mid);
        String num2 = s.substring(mid, end);

        while (end < n) {
            String sumStr = addStrings(num1, num2);

            if (!s.startsWith(sumStr, end)) {
                return false;
            }

            num1 = num2;
            num2 = sumStr;
            end += sumStr.length();
        }

        return true;
    }

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;

            if (i >= 0) {
                sum += (int) (num1.charAt(i) - '0');
            }
            if (j >= 0) {
                sum += (int) (num2.charAt(j) - '0');
            }

            carry = sum / 10;
            sb.append(sum % 10);
            i--;
            j--;
        }

        return sb.reverse().toString();
    }
}