import java.util.*;

public class Generate_Parenthesis {
    static List<String> parenthesis = new ArrayList<>();
    static Stack<Character> s = new Stack<>();

    public static List<String> generateParenthesis(int n) {
        helper(n, 0, 0);
        return parenthesis;
    }

    public static void helper(int n, int oc, int cc) {
        if (cc == n && oc == n) {
            StringBuilder sb = new StringBuilder();
            for (char c : s) {
                sb.append(c);
            }
            parenthesis.add(sb.toString());
        }

        if (oc < n) {
            s.add('(');
            helper(n, oc + 1, cc);
            s.pop();
        }
        if (cc < oc) {
            s.add(')');
            helper(n, oc, cc + 1);
            s.pop();
        }
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> list = generateParenthesis(n);

        System.out.println(list);
    }
}

// Using only StringBuilder no Stack
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n, 0, 0, ans, new StringBuilder());

        return ans;
    }

    public void solve(int n, int oc, int cc, List<String> ans, StringBuilder sb) {
        if (oc == n && cc == n) {
            ans.add(sb.toString());
            return;
        }

        if (oc < n) {
            sb.append('(');
            solve(n, oc + 1, cc, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (cc < oc) {
            sb.append(')');
            solve(n, oc, cc + 1, ans, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}