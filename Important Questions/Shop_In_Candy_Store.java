import java.util.*;

public class Shop_In_Candy_Store {

    // Greedy Approach -> Sorting
    public static ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        int n = prices.length;
        Arrays.sort(prices);
        int min = 0;
        int max = 0;

        int i = 0;
        int j = n - 1;
        while (i <= j) {
            min += prices[i++];
            j -= k;
        }

        i = 0;
        j = n - 1;
        while (i <= j) {
            max += prices[j--];
            i += k;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(min);
        ans.add(max);

        return ans;
    }

    public static void main(String[] args) {
        int prices[] = { 3, 2, 1, 4 };
        int k = 2;

        System.out.println(minMaxCandy(prices, k));
    }
}
