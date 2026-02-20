import java.util.*;

// Approach Recursion + Sorting O(n^2logn) // Hint like Balanced Parenthesis
class Solution {
    public String makeLargestSpecial(String s) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        int count = 0;

        for (int j = 0; j < s.length(); j++) {
            count += s.charAt(j) == '0' ? -1 : 1;

            if (count == 0) {
                String inner = s.substring(i + 1, j);
                ans.add('1' + makeLargestSpecial(inner) + '0');
                i = j + 1;
            }
        }

        Collections.sort(ans, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String temp : ans) {
            sb.append(temp);
        }

        return sb.toString();
    }
}