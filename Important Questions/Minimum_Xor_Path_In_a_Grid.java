//Approach 1 Using Memoisation O(n*m*1024)
class Solution {
    int n;
    int m;
    public int minCost(int[][] grid) {
        n=grid.length;
        m=grid[0].length;

        int dp[][][]=new int[n][m][1024];
        for(int plane[][]:dp){
            for(int row[]:plane){
                Arrays.fill(row,-1);
            }
        }

        return solve(grid,0,0,0,dp);
    }

    public int solve(int grid[][],int i,int j,int current,int dp[][][]){
        if(i>=n || j>=m){
            return Integer.MAX_VALUE;
        }

        if(i==n-1 && j==m-1){
            return current^grid[i][j];
        }

        if(dp[i][j][current]!=-1){
            return dp[i][j][current];
        }

        int first=solve(grid,i,j+1,current^grid[i][j],dp);
        int second=solve(grid,i+1,j,current^grid[i][j],dp);

        return dp[i][j][current]=Math.min(first,second);
    }
}

//Approach 2 Tabulation 
class Solution {
    int n;
    int m;
    public int minCost(int[][] grid) {
        n=grid.length;
        m=grid[0].length;

        int dp[][][]=new int[n][m][1024];
        
        for(int i=0;i<1024;i++){
            dp[n-1][m-1][i]=i^grid[n-1][m-1];
        }

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1){
                    continue;
                }

                for(int c=0;c<1024;c++){
                    int right=Integer.MAX_VALUE;
                    int down=Integer.MAX_VALUE;
                    
                    int nextXor=c^grid[i][j];

                    if(j+1<m){
                        right=dp[i][j+1][nextXor];
                    }

                    if(i+1<n){
                        down=dp[i+1][j][nextXor];
                    }

                    dp[i][j][c]=Math.min(right,down);
                }
            }
        }

        return dp[0][0][0];
    }
}
