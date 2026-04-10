import java.util.*;

//Approach 1 Brute Force O(n^3)
class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        if (n < 3) {
            return -1;
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] == nums[j] && nums[j] == nums[k]) {
                        int distance = 2 * (k - i);
                        ans = Math.min(distance, ans);
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}

// Approach 2 Using HashMap O(n)
class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;

        if (n <= 2) {
            return -1;
        }

        int result = Integer.MAX_VALUE;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            if (map.get(nums[i]).size() >= 3) {
                List<Integer> list = map.get(nums[i]);
                int first = list.get(list.size() - 3);
                result = Math.min(result, i + i - first - first);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}