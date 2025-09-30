import java.util.*;

//O(n*2^n)
class Solution {
    public ArrayList<String> binstr(int n) {
        ArrayList<String> result = new ArrayList<>();
        solve(n, new StringBuilder(), result);

        return result;
    }

    public void solve(int n, StringBuilder sb, ArrayList<String> result) {
        if (n == 0) {
            result.add(sb.toString());
            return;
        }

        sb.append('0');
        solve(n - 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);

        sb.append('1');
        solve(n - 1, sb, result);
        sb.deleteCharAt(sb.length() - 1);
    }
}
