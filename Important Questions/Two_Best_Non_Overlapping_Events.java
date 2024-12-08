import java.util.*;

public class Two_Best_Non_Overlapping_Events {

    public static int getNextIndex(int arr[][], int left, int prevEnd) {
        int right = arr.length - 1;
        int result = arr.length + 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid][0] > prevEnd) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static int solve(int arr[][], int i, int dp[][], int count) {
        if (count > 2) {
            return Integer.MIN_VALUE;
        }
        if (i >= arr.length) {
            return 0;
        }
        if (dp[i][count] != -1) {
            return dp[i][count];
        }
        int next = getNextIndex(arr, i + 1, arr[i][1]);
        int taken = arr[i][2] + solve(arr, next, dp, count + 1);
        int notTaken = solve(arr, i + 1, dp, count);
        dp[i][count] = Math.max(taken, notTaken);
        return dp[i][count];
    }

    public static int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        int dp[][] = new int[events.length][3];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return solve(events, 0, dp, 0);
    }

    public static void main(String args[]) {
        int events[][] = { { 1, 3, 2 }, { 4, 5, 2 }, { 2, 4, 3 } };

        System.out.println(maxTwoEvents(events));
    }
}
