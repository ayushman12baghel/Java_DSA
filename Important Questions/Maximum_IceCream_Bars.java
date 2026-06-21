import java.util.*;

//Approach Soring O(nlogn)
class Solution {
    public int maxIceCream(int[] nums, int coins) {
        Arrays.sort(nums);

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= coins) {
                coins -= nums[i];
                count++;
            } else {
                break;
            }
        }

        return count;
    }
}