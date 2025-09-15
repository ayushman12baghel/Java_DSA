import java.util.*;

//Greedy Approach O(n)
class Solution {
    public boolean stringStack(String pattern, String target) {
        int n = pattern.length();
        int m = target.length();

        int i = n - 1;
        int j = m - 1;

        while (i >= 0 && j >= 0) {
            if (pattern.charAt(i) == target.charAt(j)) {
                j--;
                i--;
            } else {
                i -= 2;
            }
        }

        return j < 0;
    }
}
