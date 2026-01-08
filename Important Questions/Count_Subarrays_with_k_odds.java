import java.util.*;

// Approach By counting at most K - k-1 == k O(n)
class Solution {
    public int countSubarrays(int[] nums, int k) {
        return solve(nums, k) - solve(nums, k - 1);
    }

    public int solve(int nums[], int k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        int count = 0;

        while (j < n) {
            if (nums[j] % 2 != 0) {
                k--;
            }

            while (k < 0) {
                if (nums[i] % 2 != 0) {
                    k++;
                }

                i++;
            }

            count += (j - i);
            j++;
        }

        return count;
    }
}

// Approach 2 Using HashMap prefix Sum O(n)
class Solution {
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int odd = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 != 0) {
                odd++;
            }

            if (map.containsKey(odd - k)) {
                count += map.get(odd - k);
            }

            map.put(odd, map.getOrDefault(odd, 0) + 1);
        }

        return count;
    }
}
