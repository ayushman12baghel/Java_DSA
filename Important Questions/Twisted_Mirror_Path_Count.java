//Approach Using Memoisation T.C O(n*m) and S.C O(n*m)
class Solution {
    int n;
    int m;
    int mod=1000000007;

    public int uniquePaths(int[][] grid) {
        n=grid.length;
        m=grid[0].length;

        int dp[][][]=new int[n][m][3];
        for(int plane[][]:dp){
            for(int row[]:plane){
                Arrays.fill(row,-1);
            }
        }

        return solve(grid,0,0,0,dp);
    }

    public int solve(int grid[][],int i,int j,int last,int dp[][][]){
        if(i>=n || j>=m){
            return 0;
        }

        if(i==n-1 && j==m-1){
            return 1;
        }

        if(dp[i][j][last]!=-1){
            return dp[i][j][last];
        }

        int count=0;
        if(grid[i][j]==1){
            if(last==1){
                count=(count+solve(grid,i+1,j,2,dp))%mod;
            }else{
                count=(count+solve(grid,i,j+1,1,dp))%mod;
            }

            return dp[i][j][last]=count%mod;
        }else{
            count=(count+solve(grid,i+1,j,2,dp))%mod;
            count=(count+solve(grid,i,j+1,1,dp))%mod;

            dp[i][j][0]=count;
            dp[i][j][1]=count;
            dp[i][j][2]=count;

            return dp[i][j][2];
        }
    }
}

//Approach 2 Tabulation O(n*m)
class Solution {
    int n;
    int m;
    int mod=1000000007;

    public int uniquePaths(int[][] grid) {
        n=grid.length;
        m=grid[0].length;

        int dp[][][]=new int[n+1][m+1][3];
        dp[n-1][m-1][0]=1;
        dp[n-1][m-1][1]=1;
        dp[n-1][m-1][2]=1;

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1){
                    continue;
                }

                for(int last=0;last<3;last++){
                    int count=0;
                    if(grid[i][j]==1){
                        if(last==1){
                            count=(count+dp[i+1][j][2])%mod;
                        }else{
                            count=(count+dp[i][j+1][1])%mod;
                        }

                        dp[i][j][last]=count%mod;
                    }else{
                        count=(count+dp[i+1][j][2])%mod;
                        count=(count+dp[i][j+1][1])%mod;

                        dp[i][j][0]=count;
                        dp[i][j][1]=count;
                        dp[i][j][2]=count;
                        break;
                    }
                }
            }
        }

        return dp[0][0][0];
    }
}
