import java.util.*;

//Approach Using Sorting + Binary Search + Memoisation O(nlogn) -> Map as DP
class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : power) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int nums[] = new int[map.size()];
        int i = 0;
        for (int key : map.keySet()) {
            nums[i++] = key;
        }

        Arrays.sort(nums);
        Map<Integer, Long> dp = new HashMap<>();

        return solve(nums, 0, map, dp);
    }

    public long solve(int nums[], int index, Map<Integer, Integer> map, Map<Integer, Long> dp) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp.containsKey(index)) {
            return dp.get(index);
        }

        int takeIndex = binarySearch(nums, nums[index] + 3);

        long take = (long) nums[index] * map.get(nums[index]) + solve(nums, takeIndex, map, dp);
        long notTake = solve(nums, index + 1, map, dp);

        long result = Math.max(take, notTake);
        dp.put(index, result);

        return result;
    }

    public int binarySearch(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}

// Array as DP O(nlogn)
class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : power) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int nums[] = new int[map.size()];
        int i = 0;
        for (int key : map.keySet()) {
            nums[i++] = key;
        }

        Arrays.sort(nums);
        long dp[] = new long[nums.length];
        Arrays.fill(dp, -1);

        return solve(nums, 0, map, dp);
    }

    public long solve(int nums[], int index, Map<Integer, Integer> map, long dp[]) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int takeIndex = binarySearch(nums, nums[index] + 3);
        long take = (long) nums[index] * map.get(nums[index]) + solve(nums, takeIndex, map, dp);
        long notTake = solve(nums, index + 1, map, dp);

        return dp[index] = Math.max(take, notTake);
    }

    public int binarySearch(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}

// Approach 2 Bottom Up O(nlogn)
class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : power) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int nums[] = new int[map.size()];
        int i = 0;
        for (int key : map.keySet()) {
            nums[i++] = key;
        }

        Arrays.sort(nums);
        long dp[] = new long[nums.length + 1];

        for (i = nums.length - 1; i >= 0; i--) {
            int nextIndex = binarySearch(nums, nums[i] + 3);
            long take = (long) nums[i] * map.get(nums[i]) + dp[nextIndex];
            long notTake = dp[i + 1];

            dp[i] = Math.max(take, notTake);
        }

        return dp[0];
    }

    public int binarySearch(int nums[], int target) {
        int left = 0;
        int right = nums.length - 1;
        int result = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}