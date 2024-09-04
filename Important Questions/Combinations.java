import java.util.*;

public class Combinations {

    public static List<List<Integer>> combination(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(1, n, new ArrayList(), list, k);

        return list;
    }

    public static void backtrack(int start, int n, List<Integer> curr, List<List<Integer>> list, int k) {
        if (curr.size() == k) {
            list.add(new ArrayList(curr));
            return;
        }

        for (int i = start; i <= n; i++) {
            curr.add(i);
            backtrack(i + 1, n, curr, list, k);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String args[]) {
        int n = 4;
        int k = 2;

        List<List<Integer>> list = combination(n, k);

        for (List<Integer> x : list) {
            System.out.print(x);
        }
    }
}
