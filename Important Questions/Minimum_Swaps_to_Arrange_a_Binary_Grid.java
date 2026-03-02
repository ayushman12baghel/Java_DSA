import java.util.*;

//Approach O(n^2)
class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;

        int endZeros[] = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            int j = n - 1;

            while (j >= 0 && grid[i][j] == 0) {
                count++;
                j--;
            }

            endZeros[i] = count;
        }

        int steps = 0;

        for (int i = 0; i < n; i++) {
            int j = i;
            int need = n - i - 1;

            while (j < n && endZeros[j] < need) {
                j++;
            }

            if (j == n) {
                return -1;
            }

            steps += (j - i);

            while (j > i) {
                int temp = endZeros[j];
                endZeros[j] = endZeros[j - 1];
                endZeros[j - 1] = temp;
                j--;
            }
        }

        return steps;
    }
}