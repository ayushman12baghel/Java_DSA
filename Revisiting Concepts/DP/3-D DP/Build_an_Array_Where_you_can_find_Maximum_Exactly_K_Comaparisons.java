import java.util.*;

public class Build_an_Array_Where_you_can_find_Maximum_Exactly_K_Comaparisons {

    // By Memoisation
    static int N;
    static int M;
    static int K;
    static int mod = 1000000007;

    public static int numOfArrays(int n, int m, int k) {
        N = n;
        M = m;
        K = k;
        int dp[][][] = new int[n][m + 1][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m + 1; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(0, 0, 0, dp);
    }

    public static int solve(int index, int searchCost, int maxSoFar, int dp[][][]) {
        if (index == N) {
            if (searchCost == K) {
                return 1;
            }

            return 0;
        }

        if (searchCost > K)
            return 0;

        if (dp[index][maxSoFar][searchCost] != -1) {
            return dp[index][maxSoFar][searchCost];
        }

        int result = 0;

        for (int i = 1; i <= M; i++) {
            if (i > maxSoFar) {
                result = (result + solve(index + 1, searchCost + 1, i, dp)) % mod;
            } else {
                result = (result + solve(index + 1, searchCost, maxSoFar, dp)) % mod;
            }
        }

        return dp[index][maxSoFar][searchCost] = result;
    }

    public static void main(String args[]) {
        int n = 2, m = 3, k = 1;

        System.out.println(numOfArrays(n, m, k));
    }
}
