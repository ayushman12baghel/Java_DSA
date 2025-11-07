import java.util.*;

public class Maximum_Profit_in_Job_Scheduling {

    public static int getNextIndex(int arr[][], int left, int prevTime) {
        int right = arr.length - 1;
        int result = arr.length + 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid][0] >= prevTime) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static int solve(int arr[][], int i, int dp[]) {
        if (i >= arr.length) {
            return 0;
        }

        if (dp[i] != 0) {
            return dp[i];
        }

        int next = getNextIndex(arr, i + 1, arr[i][1]);
        int taken = arr[i][2] + solve(arr, next, dp);
        int notTaken = solve(arr, i + 1, dp);
        dp[i] = Math.max(taken, notTaken);

        return dp[i];
    }

    public static int jobSequencing(int startTime[], int endTime[], int profit[]) {
        int arr[][] = new int[startTime.length][3];

        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int dp[] = new int[arr.length];

        return solve(arr, 0, dp);
    }

    public static void main(String args[]) {
        int startTime[] = { 1, 2, 3, 3 };
        int endTime[] = { 3, 4, 5, 6 };
        int profit[] = { 50, 10, 40, 70 };

        System.out.println(jobSequencing(startTime, endTime, profit));
    }
}

// Approach 2 Tabulation O(n log n)
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = endTime.length;
        int nums[][] = new int[n][3];

        for (int i = 0; i < n; i++) {
            nums[i][0] = startTime[i];
            nums[i][1] = endTime[i];
            nums[i][2] = profit[i];
        }

        Arrays.sort(nums, (a, b) -> a[0] - b[0]);
        int dp[] = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            int nextIndex = findIndex(nums, nums[i][1]);
            int take = nums[i][2] + dp[nextIndex];
            int notTake = dp[i + 1];

            dp[i] = Math.max(take, notTake);
        }

        return dp[0];
    }

    public int findIndex(int nums[][], int prev) {
        int left = 0;
        int right = nums.length - 1;
        int result = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid][0] >= prev) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}

// Approach 3 Using PriorityQueue O(n log n)
class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = endTime.length;
        int nums[][] = new int[n][3];

        for (int i = 0; i < n; i++) {
            nums[i][0] = startTime[i];
            nums[i][1] = endTime[i];
            nums[i][2] = profit[i];
        }

        Arrays.sort(nums, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int maxProfit = 0;

        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && pq.peek()[0] <= nums[i][0]) {
                maxProfit = Math.max(maxProfit, pq.poll()[1]);
            }

            pq.offer(new int[] { nums[i][1], maxProfit + nums[i][2] });
        }

        while (!pq.isEmpty()) {
            maxProfit = Math.max(maxProfit, pq.poll()[1]);
        }

        return maxProfit;
    }
}