import java.util.*;

//Approach Greedy O(nlogn)
class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int n = val.length;

        double ratio[][] = new double[n][2];

        for (int i = 0; i < n; i++) {
            ratio[i][0] = i;
            ratio[i][1] = val[i] / (double) wt[i];
        }

        Arrays.sort(ratio, (a, b) -> Double.compare(b[1], a[1]));

        double total = 0;

        for (int i = 0; i < n; i++) {
            int index = (int) ratio[i][0];

            if (wt[index] <= capacity) {
                total += val[index];
                capacity -= wt[index];
            } else {
                total += (ratio[i][1] * capacity);
                return total;
            }
        }

        return total;
    }
}