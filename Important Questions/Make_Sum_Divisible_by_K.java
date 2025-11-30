import java.util.*;

// O(n)
class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum = (sum + num) % p;
        }

        int need = sum % p;
        if (need == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = n;
        sum = 0;

        for (int i = 0; i < n; i++) {
            sum = (sum + nums[i]) % p;
            int target = (sum - need + p) % p;

            if (map.containsKey(target)) {
                ans = Math.min(ans, i - map.get(target));
            }

            map.put(sum % p, i);
        }

        return ans == n ? -1 : ans;
    }
}