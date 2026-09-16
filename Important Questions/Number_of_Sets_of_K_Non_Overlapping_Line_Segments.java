//Approach 1 Memoisation O(n^2*k) T.L.E
class Solution {
    int mod=1000000007;
    public int numberOfSets(int n, int k) {
        int dp[][]=new int[n][k+1];

        for(int row[]:dp){
            Arrays.fill(row,-1);
        }

        return solve(n,1,k,dp);
    }

    public int solve(int n,int i,int k,int dp[][]){
        if(i>=n){
            return k==0?1:0;
        }

        if(k==0){
            return 1;
        }

        if(dp[i][k]!=-1){
            return dp[i][k];
        }

        int ans=solve(n,i+1,k,dp);

        for(int j=i+1;j<=n;j++){
            ans=(ans+solve(n,j,k-1,dp))%mod;
        }

        return dp[i][k]=ans;
    }
}

//Approach 2 More optimised O(n*k)
class Solution {
    int mod=1000000007;
    public int numberOfSets(int n, int k) {
        int dp[][][]=new int[n][k+1][2];

        for(int plane[][]:dp){
            for(int row[]:plane){
                Arrays.fill(row,-1);
            }
        }

        return solve(n,0,k,0,dp);
    }

    public int solve(int n,int i,int k,int drawing,int dp[][][]){
        if(k==0){
            return 1;
        }

        if(i>=n){
            return k==0?1:0;
        }

        if(dp[i][k][drawing]!=-1){
            return dp[i][k][drawing];
        }

        int ans=0;

        if(drawing==0){
            ans=(solve(n,i+1,k,0,dp)+solve(n,i+1,k,1,dp))%mod;
        }else{
            ans=(solve(n,i+1,k,1,dp)+solve(n,i,k-1,0,dp))%mod;
        }

        return dp[i][k][drawing]=ans;
    }
}

//Approach 3 Tabulation O(n*k)
class Solution {
    int mod=1000000007;
    public int numberOfSets(int n, int k) {
        int dp[][][]=new int[n+1][k+1][2];

        for(int i=0;i<=n;i++){
            for(int j=0;j<=1;j++){
                dp[i][0][j]=1;
            }
        }

        for(int i=n-1;i>=0;i--){
            for(int j=1;j<=k;j++){
                for(int drawing=0;drawing<=1;drawing++){
                    int ans=0;

                    if(drawing==0){
                        ans=(dp[i+1][j][0]+dp[i+1][j][1])%mod;
                    }else{
                        ans=(dp[i+1][j][1]+dp[i][j-1][0])%mod;
                    }

                    dp[i][j][drawing]=ans;
                }
            }
        }

        return dp[0][k][0];
    }
}
