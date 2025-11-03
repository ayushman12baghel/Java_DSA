import java.util.*;

//Approach Using Memoisation M.L.E O(n^2)
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int dp[][] = new int[colors.length()][colors.length() + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(colors, neededTime, 0, -1, dp);
    }

    public int solve(String colors, int neededTime[], int index, int prevIndex, int dp[][]) {
        if (index >= colors.length()) {
            return 0;
        }

        if (dp[index][prevIndex + 1] != -1) {
            return dp[index][prevIndex + 1];
        }

        if (prevIndex == -1) {
            return dp[index][prevIndex + 1] = solve(colors, neededTime, index + 1, index, dp);
        }

        int result = Integer.MAX_VALUE;

        if (colors.charAt(index) == colors.charAt(prevIndex)) {
            int removeCurrent = neededTime[index] + solve(colors, neededTime, index + 1, prevIndex, dp);
            int removePrev = neededTime[prevIndex] + solve(colors, neededTime, index + 1, index, dp);

            result = Math.min(removeCurrent, removePrev);
        } else {
            result = Math.min(result, solve(colors, neededTime, index + 1, index, dp));
        }

        return dp[index][prevIndex + 1] = result;
    }
}

// Approach Using Tabulation O(n)
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;

        int dp[] = new int[n];
        int maxTime = neededTime[0];

        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                dp[i] = dp[i - 1] + Math.min(maxTime, neededTime[i]);
                maxTime = Math.max(maxTime, neededTime[i]);
            } else {
                dp[i] = dp[i - 1];
                maxTime = neededTime[i];
            }
        }

        return dp[n - 1];
    }
}

// Greedy Approach
class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;

        int time = 0;
        int prev = neededTime[0];

        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                time += Math.min(neededTime[i], prev);
                prev = Math.max(neededTime[i], prev);
            } else {
                prev = neededTime[i];
            }
        }

        return time;
    }
}