import java.util.*;

//O(n)
class Solution {
    public int minParentheses(String s) {
        int n = s.length();
        int balance = 0;
        int insertions = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                balance++;
            } else {
                if (balance > 0) {
                    balance--;
                } else {
                    insertions++;
                }
            }
        }

        return balance + insertions;
    }
}