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
