import java.util.*;

//O(n)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        }

        int start = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 != nums[i]) {
                if (start == nums[i - 1]) {
                    ans.add(String.valueOf(start));
                } else {
                    ans.add(start + "->" + nums[i - 1]);
                }

                start = nums[i];
            }
        }

        if (start == nums[nums.length - 1]) {
            ans.add(String.valueOf(start));
        } else {
            ans.add(start + "->" + nums[nums.length - 1]);
        }

        return ans;
    }
}