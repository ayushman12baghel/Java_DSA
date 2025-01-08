import java.util.*;

public class Lexicographical_Number {
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ans.add(i);
        }
        Collections.sort(ans, (a, b) -> Integer.toString(a).compareTo(Integer.toString(b)));
        return ans;
    }

    // DFS
    public static List<Integer> lexicalOrder2(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= 9; i++) {
            solve(i, n, result);
        }

        return result;
    }

    public static void solve(int current, int n, List<Integer> result) {
        if (current > n) {
            return;
        }

        result.add(current);

        for (int i = 0; i <= 9; i++) {
            int newNum = current * 10 + i;
            if (newNum > n) {
                return;
            }
            solve(newNum, n, result);
        }
    }

    public static void main(String args[]) {
        int n = 12;
        List<Integer> list = lexicalOrder(n);
        System.out.println(list);
        System.out.println(lexicalOrder2(n));
    }
}
