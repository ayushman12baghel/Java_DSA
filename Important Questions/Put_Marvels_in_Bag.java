import java.util.*;

public class Put_Marvels_in_Bag {

    public static long putMarbles(int[] weights, int k) {
        int pairSum[] = new int[weights.length - 1];
        for (int i = 0; i < pairSum.length; i++) {
            pairSum[i] = weights[i] + weights[i + 1];
        }

        Arrays.sort(pairSum);
        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < k - 1; i++) {
            sum1 += pairSum[i];
            sum2 += pairSum[pairSum.length - i - 1];
        }

        return sum2 - sum1;
    }

    public static void main(String args[]) {
        int weights[] = { 1, 3, 5, 1 };
        int k = 2;

        System.out.println(putMarbles(weights, k));
    }
}
