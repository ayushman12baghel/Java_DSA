import java.util.*;

//Approach Using DP O(n^2)
class Solution {
    public static int longestBitonicSequence(int n, int[] nums) {
        if (n < 3) {
            return 0;
        }

        int inc[] = new int[n];
        int dec[] = new int[n];

        for (int i = 0; i < n; i++) {
            inc[i] = 1;
            dec[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    inc[i] = Math.max(inc[i], inc[j] + 1);
                }
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    dec[i] = Math.max(dec[i], dec[j] + 1);
                }
            }
        }

        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            if (inc[i] > 1 && dec[i] > 1) {
                maxLength = Math.max(maxLength, inc[i] + dec[i] - 1);
            }
        }

        return maxLength;
    }
}
