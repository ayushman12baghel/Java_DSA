import java.util.*;

public class Length_of_Longest_Fibonacci_Subsequence {

    // Brute Force Backtracking Approach - Time Complexity O(n^3)
    public static int lenLongestFibSubseq(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int j = 1; j < nums.length; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                int length = solve(nums, map, j, k);

                if (length >= 3) {
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength >= 3 ? maxLength : 0;
    }

    public static int solve(int nums[], HashMap<Integer, Integer> map, int j, int k) {
        int target = nums[k] - nums[j];

        if (map.containsKey(target) && map.get(target) < j) {
            int i = map.get(target);
            return solve(nums, map, i, j) + 1;
        }

        return 2;
    }

    // DP Approach - Time Complexity O(n^2) //Bottom Up Approach
    public static int lenLongestFibSubseq2(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int dp[][] = new int[nums.length][nums.length];
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int j = 1; j < nums.length; j++) {
            for (int k = j + 1; k < nums.length; k++) {
                int length = solve(nums, map, j, k, dp);

                if (length >= 3) {
                    maxLength = Math.max(maxLength, length);
                }
            }
        }

        return maxLength >= 3 ? maxLength : 0;
    }

    public static int solve(int nums[], HashMap<Integer, Integer> map, int j, int k, int dp[][]) {
        if (dp[j][k] != 0) {
            return dp[j][k];
        }
        int target = nums[k] - nums[j];

        if (map.containsKey(target) && map.get(target) < j) {
            int i = map.get(target);
            return dp[j][k] = solve(nums, map, i, j, dp) + 1;
        }

        return dp[j][k] = 2;
    }

    // Bottom Up Approach - Time Complexity O(n^2)
    public static int lenLongestFibSubseq3(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int dp[][] = new int[arr.length][arr.length];

        for (int row[] : dp) {
            Arrays.fill(row, 2);
        }

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        int maxLength = 0;
        for (int j = 1; j < arr.length; j++) {
            for (int k = j + 1; k < arr.length; k++) {
                int target = arr[k] - arr[j];
                if (map.containsKey(target) && map.get(target) < j) {
                    dp[j][k] = dp[map.get(target)][j] + 1;
                    maxLength = Math.max(maxLength, dp[j][k]);
                }
            }
        }

        return maxLength >= 3 ? maxLength : 0;
    }

    public static void main(String args[]) {
        int nums[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        System.out.println(lenLongestFibSubseq(nums));
        System.out.println(lenLongestFibSubseq2(nums));
    }
}
