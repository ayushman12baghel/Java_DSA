import java.util.*;

public class Longest_Increasing_Subsequence {

    // Approach 1 Using Recursion T.L.E
    public static int lengthOfLIS(int nums[]) {
        return solve(nums, 0, -1);
    }

    public static int solve(int nums[], int index, int prevIndex) {
        if (index >= nums.length) {
            return 0;
        }

        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = solve(nums, index + 1, index) + 1;
        }

        int notTake = solve(nums, index + 1, prevIndex);

        return Math.max(take, notTake);
    }

    // Approach 2 Using Memoisation O(n^2)
    public static int lengthOfLIS2(int nums[]) {
        int n = nums.length;
        int dp[][] = new int[n][n + 1];

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(nums, 0, -1, dp);
    }

    public static int solve(int nums[], int index, int prevIndex, int dp[][]) {
        if (index >= nums.length) {
            return 0;
        }

        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }

        int take = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            take = solve(nums, index + 1, index, dp) + 1;
        }

        int notTake = solve(nums, index + 1, prevIndex, dp);

        return dp[index][prevIndex + 1] = Math.max(take, notTake);
    }

    // Tabulation
    public static int lengthOfLIS3(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n];

        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }

        return max;
    }

    // Approach 3 Patience Sorting BinarySearch O(n*logn)
    public static int lengthOfLIS4(int nums[]) {
        int n = nums.length;
        List<Integer> sorted = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int index = binarySearch(sorted, nums[i]);

            if (index == sorted.size()) {
                sorted.add(index, nums[i]);
            } else {
                sorted.set(index, nums[i]);
            }
        }

        return sorted.size();
    }

    public static int binarySearch(List<Integer> sorted, int target) {
        int left = 0;
        int right = sorted.size() - 1;
        int result = sorted.size();

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sorted.get(mid) < target) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        return result;
    }

    // Using Same Code as Maximum Balanced Sbsequence Sum O(n*logn) Patience Sorting
    public static int lengthOfLIS5(int nums[]) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = 1;

        for (int i = 0; i < nums.length; i++) {
            int length = 1;
            Integer key = map.lowerKey(nums[i]);

            if (key != null) {
                length += map.get(key);
            }

            map.put(nums[i], Math.max(map.getOrDefault(nums[i], 0), length));

            key = map.higherKey(nums[i]);

            while (key != null && map.get(key) <= length) {
                map.remove(key);
                key = map.higherKey(nums[i]);
            }

            ans = Math.max(ans, length);
        }

        return ans;
    }

    public static void main(String args[]) {
        int nums[] = { 10, 9, 2, 5, 3, 7, 101, 18 };

        System.out.println(lengthOfLIS(nums));
        System.out.println(lengthOfLIS2(nums));

        System.out.println(lengthOfLIS3(nums));
        System.out.println(lengthOfLIS4(nums));
        System.out.println(lengthOfLIS5(nums));
    }
}
