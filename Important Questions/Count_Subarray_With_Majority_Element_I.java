import java.util.*;

//Approach 1 Brute Force O(n^2)
class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == target) {
                    count++;
                }

                int size = j - i + 1;
                if (size / 2 < count) {
                    ans++;
                }
            }
        }

        return ans;
    }
}

// Approach 2 Using Prefix Sum O(n)
class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int currentSum = 0;
        int smallerCount = 0;
        int ans = 0;

        map.put(0, 1);

        for (int num : nums) {
            if (num == target) {
                smallerCount += map.getOrDefault(currentSum, 0);
                currentSum++;
            } else {
                currentSum--;
                smallerCount -= map.getOrDefault(currentSum, 0);
            }

            ans += smallerCount;

            map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        }

        return ans;
    }
}