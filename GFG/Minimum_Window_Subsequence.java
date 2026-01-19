import java.util.*;

// Approach 2 Pointer O(n*m)
class Solution {
    public String minWindow(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int i = 0;
        int j = 0;
        int minLength = Integer.MAX_VALUE;
        String ans = "";

        while (i < n) {
            if (s1.charAt(i) == s2.charAt(j)) {
                j++;
            }

            if (j == m) {
                int end = i;
                j--;

                while (j >= 0) {
                    if (s2.charAt(j) == s1.charAt(i)) {
                        j--;
                    }

                    i--;
                }

                i++;

                int length = end - i + 1;

                if (length < minLength) {
                    minLength = length;
                    ans = s1.substring(i, end + 1);
                }

                j = 0;
            }

            i++;
        }

        return ans;
    }
}
