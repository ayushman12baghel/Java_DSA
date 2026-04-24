import java.util.*;

class Solution {
    public int visibleBuildings(int nums[]) {
        int ans = 1;

        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (max <= nums[i]) {
                ans++;
                max = nums[i];
            }
        }

        return ans;
    }
}