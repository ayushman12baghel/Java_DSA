import java.util.*;

public class Jump_Game_2 {

    public static int minJumps(int arr[]) {
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        dp[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            int steps = arr[i];
            int ans = Integer.MAX_VALUE;
            for (int j = i + 1; j <= i + steps && j < n; j++) {
                if (dp[j] != -1) {
                    ans = Math.min(ans, dp[j] + 1);
                }
            }

            if (ans != Integer.MAX_VALUE) {
                dp[i] = ans;
            }
        }

        return dp[0];
    }

    public static void main(String args[]) {
        int arr[] = { 2, 3, 1, 1, 4 };

        System.out.println(minJumps(arr));
    }
}

// Memoisation O(n^2)
class Solution {
    public int jump(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        int ans = solve(nums, 0, dp);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int solve(int nums[], int index, int dp[]) {
        if (index >= nums.length - 1) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = index + 1; i <= nums[index] + index; i++) {
            int next = solve(nums, i, dp);

            if (next != Integer.MAX_VALUE) {
                ans = Math.min(ans, next + 1);
            }
        }

        return dp[index] = ans;
    }
}

// Optimal Greedy O(n)
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int farthest = 0;
        int end = 0;
        int jumps = 0;

        for (int i = 0; i < n; i++) {
            farthest = Math.max(farthest, i + nums[i]);

            if (i == end) {
                jumps++;
                end = farthest;

                if (end >= n - 1) {
                    return jumps;
                }
            }
        }

        return end < nums.length - 1 ? -1 : jumps;
    }
}
