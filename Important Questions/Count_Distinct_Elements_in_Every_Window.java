import java.util.*;

//Approach Using HashMap O(n)
class Solution {
    ArrayList<Integer> countDistinct(int nums[], int k) {
        int n = nums.length;

        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;

        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            if (j - i + 1 >= k) {
                ans.add(map.size());
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }

                i++;
            }

            j++;
        }

        return ans;
    }
}