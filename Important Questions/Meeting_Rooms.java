import java.util.*;

//Approach Using Sorting O(nlogn)
class Solution {
    static boolean canAttend(int[][] nums) {
        Arrays.sort(nums, (a, b) -> a[0] - b[0]);
        int count = 1;
        int lastEnding = nums[0][1];

        for (int i = 1; i < nums.length; i++) {
            if (lastEnding > nums[i][0]) {
                return false;
            } else {
                lastEnding = nums[i][1];
            }
        }

        return true;
    }
}