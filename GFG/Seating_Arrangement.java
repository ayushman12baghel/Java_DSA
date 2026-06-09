import java.util.*;

// Greedy O(n)
class Solution {
    public boolean canSeatAllPeople(int k, int[] seats) {
        // code here
        for (int i = 1; i < seats.length; i++) {
            if (seats[i] == seats[i - 1] && seats[i] == 1) {
                return false;
            }
        }

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                boolean left = (i == 0 || seats[i - 1] == 0);
                boolean right = (i == seats.length - 1 || seats[i + 1] == 0);

                if (left && right) {
                    seats[i] = 1;
                    k--;
                }
            }
        }

        return k <= 0;
    }
}