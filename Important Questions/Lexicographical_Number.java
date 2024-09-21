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

    public static void main(String args[]) {
        int n = 12;
        List<Integer> list = lexicalOrder(n);
        System.out.println(list);
    }
}
