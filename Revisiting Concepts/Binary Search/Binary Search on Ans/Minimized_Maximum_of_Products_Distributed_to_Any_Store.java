import java.util.*;

public class Minimized_Maximum_of_Products_Distributed_to_Any_Store {

    // Binary Search On Ans O(n*log(maxQuantity))
    public static int minimizedMaximum(int n, int quantities[]) {
        int maxQuantity = Integer.MIN_VALUE;
        for (int quantity : quantities) {
            maxQuantity = Math.max(maxQuantity, quantity);
        }

        int left = 1;
        int right = maxQuantity;
        int result = maxQuantity;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isPossible(quantities, n, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static boolean isPossible(int nums[], int n, int target) {
        int count = 0;
        for (int num : nums) {
            count += ((num + target - 1) / target);
        }

        return count <= n;
    }

    public static void main(String[] args) {
        int n = 7, quantities[] = { 15, 10, 10 };

        System.out.println(minimizedMaximum(n, quantities));
    }
}
