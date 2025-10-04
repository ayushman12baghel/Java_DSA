import java.util.*;

//O(4^n)
class Solution {
    public ArrayList<String> findExpr(String s, int target) {
        ArrayList<String> ans = new ArrayList<>();
        solve(s, target, 0, 0, 0, new StringBuilder(), ans);

        return ans;
    }

    public void solve(String s, int target, int index, int calc, int tail, StringBuilder sb, ArrayList<String> ans) {
        if (index >= s.length()) {
            if (target == calc) {
                ans.add(sb.toString());
            }

            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (s.charAt(index) == '0' && i > index) {
                break;
            }

            String currStr = s.substring(index, i + 1);
            int curr = Integer.parseInt(currStr);
            int length = sb.length();

            if (index == 0) {
                sb.append(currStr);
                solve(s, target, i + 1, curr, curr, sb, ans);
                while (sb.length() > length) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append('+').append(currStr);
                solve(s, target, i + 1, calc + curr, curr, sb, ans);
                while (sb.length() > length) {
                    sb.deleteCharAt(sb.length() - 1);
                }

                sb.append('-').append(currStr);
                solve(s, target, i + 1, calc - curr, -curr, sb, ans);
                while (sb.length() > length) {
                    sb.deleteCharAt(sb.length() - 1);
                }

                sb.append('*').append(currStr);
                solve(s, target, i + 1, calc - tail + tail * curr, tail * curr, sb, ans);
                while (sb.length() > length) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}