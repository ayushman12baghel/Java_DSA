import java.util.*;

// Approach 1 Doing Memoisation O(n*n*k)
class Solution {
    int directions[][] = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { -1, -2 }, { 1, -2 } };

    public double knightProbability(int N, int k, int row, int col) {
        double dp[][][] = new double[N][N][k + 1];
        for (double plane[][] : dp) {
            for (double r[] : plane) {
                Arrays.fill(r, -1);
            }
        }
        return solve(N, row, col, k, dp);
    }

    public double solve(int n, int row, int col, int k, double dp[][][]) {
        if (row >= n || col >= n || row < 0 || col < 0) {
            return 0;
        }

        if (k == 0) {
            return 1;
        }

        if (dp[row][col][k] != -1) {
            return dp[row][col][k];
        }

        double total = 0;
        for (int direction[] : directions) {
            total += (solve(n, row + direction[0], col + direction[1], k - 1, dp)) / 8.0;
        }

        return dp[row][col][k] = total;
    }
}

//Approach 2 Doing Tabulation O(n*n*k)
class Solution {
    public double knightProbability(int n, int step, int row, int col) {
        int directions[][]={{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{-1,-2},{1,-2}};
        double dp[][][]=new double[n][n][step+1];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j][0]=1;
            }
        }

        for(int k=1;k<=step;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    double total=0;

                    for(int direction[]:directions){
                        int newRow=direction[0]+i;
                        int newCol=direction[1]+j;

                        if(newRow>=0 && newCol>=0 && newRow<n && newCol<n){
                            total+=dp[newRow][newCol][k-1]/8.0;
                        }
                    }

                    dp[i][j][k]=total;
                }
            }
        }

        return dp[row][col][step];
    }
}