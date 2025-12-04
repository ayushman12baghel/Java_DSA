import java.util.*;

//Brute Force Using Sorting O(n logn)
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int n = nums.length;

        int current = 1;
        int maxLength = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            }
            if (nums[i - 1] + 1 == nums[i]) {
                current++;
            } else {
                maxLength = Math.max(current, maxLength);
                current = 1;
            }
        }

        return Math.max(current, maxLength);
    }
}

// Approach 2 Expand from Middle O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;

        if (n == 0) {
            return 0;
        }

        Map<Integer, Boolean> explored = new HashMap<>();
        int maxLength = 1;

        for (int num : nums) {
            explored.put(num, false);
        }

        for (int i = 0; i < n; i++) {
            int currentLength = 1;
            int nextNum = nums[i] + 1;

            while (explored.containsKey(nextNum) && explored.get(nextNum) == false) {
                explored.put(nextNum, true);
                currentLength++;
                nextNum++;
            }

            int prevNum = nums[i] - 1;
            while (explored.containsKey(prevNum) && explored.get(prevNum) == false) {
                explored.put(prevNum, true);
                currentLength++;
                prevNum--;
            }

            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }
}

// Approach 3 O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, false);
        }

        int maxLength = 0;

        for (int num : map.keySet()) {
            if (map.containsKey(num - 1)) {
                continue;
            }

            int currentLength = 0;
            while (map.containsKey(num)) {
                currentLength++;
                num++;
            }

            maxLength = Math.max(currentLength, maxLength);
        }

        return maxLength;
    }
}