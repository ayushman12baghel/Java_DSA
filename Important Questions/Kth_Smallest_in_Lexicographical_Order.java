import java.util.*;

public class Kth_Smallest_in_Lexicographical_Order {

    public static int firstKthNumber(int n, int k) {
        int curr = 1;
        k -= 1; // Since we have already taken 1, we need more k-1 elements

        while (k > 0) {
            int count = Count(curr, curr + 1, n);
            // If the steps are less than or equal to k, we skip this prefix's subtree
            if (count <= k) {
                curr++;
                // Move to the next prefix and decrease k by the number of steps we skip
                k -= count;
            } else {
                curr *= 10;
                // Move to the next level of the tree and decrement k by 1
                k--;
            }
        }

        return curr;
    }

    // To count how many numbers exist between prefix1 and prefix2
    public static int Count(long curr, long next, int n) {
        int countNum = 0;

        while (curr <= n) {
            countNum += (next - curr);
            curr *= 10;
            next *= 10;
            next = Math.min((long) n + 1, next);
        }

        return countNum;
    }

    public static void main(String args[]) {
        int n = 13;
        int k = 2;

        System.out.println(firstKthNumber(n, k));
    }
}
