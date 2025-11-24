import java.util.*;

//O(n)
class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int prefix = 0;

        for (int num : nums) {
            prefix = ((prefix << 1) + num) % 5;
            ans.add(prefix % 5 == 0);
        }

        return ans;
    }
}