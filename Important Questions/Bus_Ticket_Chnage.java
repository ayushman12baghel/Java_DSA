import java.util.*;

//Approach O(n)
class Solution {
    public boolean canServe(int[] nums) {
        int five = 0;
        int ten = 0;

        for (int num : nums) {
            if (num == 5) {
                five++;
            } else if (num == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else {
                if (ten > 0 && five > 0) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}