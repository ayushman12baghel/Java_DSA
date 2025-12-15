import java.util.*;

class Solution {
    public long getDescentPeriods(int[] prices) {
        long result = 1;
        long length = 1;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] - 1 == prices[i]) {
                length++;
            } else {
                length = 1;
            }

            result += length;
        }

        return result;
    }
}