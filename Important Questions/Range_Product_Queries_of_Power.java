import java.util.*;

public class Range_Product_Queries_of_Power {

    public static int[] productQueries(int n, int[][] queries) {
        int mod = 1000000007;
        List<Integer> power = new ArrayList<>();
        int ans[] = new int[queries.length];

        for (int i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                power.add(1 << i);
            }
        }

        int j = 0;
        for (int query[] : queries) {
            long product = 1;
            for (int i = query[0]; i <= query[1]; i++) {
                product = (product * power.get(i)) % mod;
            }
            ans[j++] = (int) product;
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 15, queries[][] = { { 0, 1 }, { 2, 2 }, { 0, 3 } };
        int ans[] = productQueries(n, queries);

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}