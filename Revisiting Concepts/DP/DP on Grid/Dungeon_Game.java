import java.util.*;

public class Dungeon_Game {

    // Approach 1 Using Binary Search and Memoisation
    // T.L.E

    public static int calculateMinimumHP(int dungeon[][]) {
        int n = dungeon.length;
        int m = dungeon[0].length;

        int left = 1;
        int right = 40000001;
        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            HashMap<String, Boolean> map = new HashMap<>();

            if (isPossible(dungeon, 0, 0, mid, map)) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    public static boolean isPossible(int dungeon[][], int i, int j, int mid, HashMap<String, Boolean> map) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        if (i >= n || j >= m) {
            return false;
        }

        mid += dungeon[i][j];

        if (mid <= 0) {
            return false;
        }

        if (i == n - 1 && j == m - 1) {
            return true;
        }

        String key = i + "|" + j + "|" + mid;
        if (map.containsKey(key)) {
            return map.get(key);
        }

        boolean ans = isPossible(dungeon, i + 1, j, mid, map) || isPossible(dungeon, i, j + 1, mid, map);
        map.put(key, ans);

        return ans;
    }

    // Approach 2 Using Memoisation
    public static int calculateMinimumHP2(int dungeon[][]) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int dp[][] = new int[n][m];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        return solve(dungeon, 0, 0, dp);
    }

    public static int solve(int dungeon[][], int i, int j, int dp[][]) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }

        if (i == n - 1 && j == m - 1) {
            return dungeon[i][j] > 0 ? 1 : Math.abs(dungeon[i][j]) + 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int right = solve(dungeon, i, j + 1, dp);
        int down = solve(dungeon, i + 1, j, dp);

        int result = Math.min(right, down) - dungeon[i][j];

        return dp[i][j] = result > 0 ? result : 1;
    }

    // Approach 3 Using Tabulation O(n^2)
    public static int calculateMinimumHP3(int dungeon[][]) {
        int n = dungeon.length;
        int m = dungeon[0].length;

        int dp[][] = new int[n][m];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (i == n - 1 && j == m - 1) {
                    dp[i][j] = dungeon[i][j] > 0 ? 1 : Math.abs(dungeon[i][j]) + 1;
                } else {
                    int right = j + 1 >= m ? Integer.MAX_VALUE : dp[i][j + 1];
                    int down = i + 1 >= n ? Integer.MAX_VALUE : dp[i + 1][j];

                    int result = Math.min(right, down) - dungeon[i][j];

                    dp[i][j] = result > 0 ? result : 1;
                }
            }
        }

        return dp[0][0];
    }

    public static void main(String args[]) {
        int dungeon[][] = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };

        System.out.println(calculateMinimumHP(dungeon));
        System.out.println(calculateMinimumHP2(dungeon));
        System.out.println(calculateMinimumHP3(dungeon));
    }
}
