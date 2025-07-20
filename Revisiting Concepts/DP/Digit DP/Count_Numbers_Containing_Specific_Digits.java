import java.util.*;

public class Count_Numbers_Containing_Specific_Digits {

    public static int countValid(int n, int[] arr) {
        // code here
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int dp[][][] = new int[n + 1][2][2];

        for (int row[][] : dp) {
            for (int col[] : row) {
                Arrays.fill(col, -1);
            }
        }

        return solve(0, 1, 0, n, set, dp);
    }

    public static int solve(int pos, int isLeadingZero, int found, int n, Set<Integer> set, int dp[][][]) {
        if (pos == n) {
            return found == 1 ? 1 : 0;
        }

        if (dp[pos][isLeadingZero][found] != -1) {
            return dp[pos][isLeadingZero][found];
        }

        int ans = 0;

        for (int d = 0; d <= 9; d++) {
            if (pos == 0 && d == 0)
                continue;
            int newLeadingZero = (isLeadingZero == 1 && d == 0) ? 1 : 0;
            int newFound = (found == 1 || set.contains(d) ? 1 : 0);

            ans += solve(pos + 1, newLeadingZero, newFound, n, set, dp);
        }

        return dp[pos][isLeadingZero][found] = ans;
    }

    public static void main(String[] args) {
        int n = 2;
        int arr[] = { 3, 5 };

        System.out.println(countValid(n, arr));
    }
}
