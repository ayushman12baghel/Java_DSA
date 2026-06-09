import java.util.*;

//Simulating backward O(logn)
class Solution {
    public int minStep(int n) {
        int count = 0;

        while (n > 1) {
            if (n % 3 == 0) {
                n /= 3;
            } else {
                n--;
            }

            count++;
        }

        return count;
    }
}
