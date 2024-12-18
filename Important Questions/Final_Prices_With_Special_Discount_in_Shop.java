import java.util.*;

public class Final_Prices_With_Special_Discount_in_Shop {

    public static int[] finalPrices(int prices[]) {
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[prices.length];

        for (int i = prices.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                ans[i] = prices[i] - stack.peek();
            } else {
                ans[i] = prices[i];
            }
            stack.push(prices[i]);
        }

        return ans;
    }

    public static void main(String args[]) {
        int prices[] = { 8, 4, 6, 2, 3 };

        int ans[] = finalPrices(prices);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}
