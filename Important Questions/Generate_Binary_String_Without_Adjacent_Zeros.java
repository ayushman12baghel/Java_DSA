import java.util.*;

class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        solve(n, new StringBuilder(), -1, result);

        return result;
    }

    public void solve(int n, StringBuilder sb, int prev, List<String> result) {
        if (n == sb.length()) {
            result.add(sb.toString());
            return;
        }

        sb.append('1');
        solve(n, sb, 1, result);
        sb.deleteCharAt(sb.length() - 1);

        if (prev != 0) {
            sb.append('0');
            solve(n, sb, 0, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}