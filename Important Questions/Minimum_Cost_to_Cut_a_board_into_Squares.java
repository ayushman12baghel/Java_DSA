import java.util.*;

//Greedyily Cutting costly Edges first
class Solution {
    public static int minCost(int n, int m, int[] x, int[] y) {
        int total = 0;
        int horCount = 1;
        int verCount = 1;

        Arrays.sort(x);
        Arrays.sort(y);

        int i = x.length - 1;
        int j = y.length - 1;

        while (i >= 0 && j >= 0) {
            if (x[i] >= y[j]) {
                total += (x[i] * horCount);
                verCount++;
                i--;
            } else {
                total += (y[j] * verCount);
                horCount++;
                j--;
            }
        }

        while (i >= 0) {
            total += (x[i] * horCount);
            verCount++;
            i--;
        }

        while (j >= 0) {
            total += (y[j] * verCount);
            horCount++;
            j--;
        }

        return total;
    }
}
