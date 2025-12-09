import java.util.*;

//O(n)
class Solution {
    public ArrayList<Integer> findDuplicates(int[] nums) {
        // code here
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            if (set.contains(num)) {
                ans.add(num);
            }

            set.add(num);
        }

        return ans;
    }
}