import java.util.*;

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;

        while (numBottles >= numExchange) {
            int temp = numBottles / numExchange;
            numBottles %= numExchange;
            numBottles += temp;
            ans += temp;
        }

        return ans;
    }
}