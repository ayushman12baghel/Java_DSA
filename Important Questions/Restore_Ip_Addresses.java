import java.util.*;

// Approach Backtracking O(m^k) => O(3^4) => 81
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return ans;
        }

        solve(s, 0, new StringBuilder(), 0, ans);

        return ans;
    }

    public void solve(String s, int index, StringBuilder sb, int parts, List<String> ans) {
        if (parts == 4) {
            if (index >= s.length()) {
                sb.deleteCharAt(sb.length() - 1);
                ans.add(sb.toString());
            }

            return;
        }

        for (int length = 1; length <= 3; length++) {
            if (length + index > s.length()) {
                break;
            }

            String part = s.substring(index, index + length);

            if (isValid(part)) {
                int startLength = sb.length();
                sb.append(part).append('.');
                solve(s, index + length, sb, parts + 1, ans);
                sb.delete(startLength, sb.length());
            }
        }
    }

    public boolean isValid(String part) {
        if (part.length() > 1 && part.charAt(0) == '0') {
            return false;
        }

        int value = Integer.parseInt(part);

        return value <= 255 && value >= 0;
    }
}