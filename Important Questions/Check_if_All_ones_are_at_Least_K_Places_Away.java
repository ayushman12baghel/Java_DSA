import java.util.*;

class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int dist = 0;
        boolean found = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (!found) {
                    found = true;
                } else if (dist < k) {
                    return false;
                }

                dist = 0;
            } else {
                dist++;
            }
        }

        return true;
    }
}