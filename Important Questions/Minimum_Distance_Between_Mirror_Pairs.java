import java.util.*;

// Approach O(nlogn)
class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                ans = Math.min(ans, i - map.get(nums[i]));
            }

            int reverse = reverse(nums[i]);
            map.put(reverse, i);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int reverse(int num) {
        int reverse = 0;

        while (num > 0) {
            int ld = num % 10;
            reverse = (reverse * 10 + ld);
            num /= 10;
        }

        return reverse;
    }
}
