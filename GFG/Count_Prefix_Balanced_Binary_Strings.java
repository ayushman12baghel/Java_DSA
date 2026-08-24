//Approach Using DP O(n^2)
class Solution {
    public int prefixStrings(int n) {
        int dp[][]=new int[n+1][n+1];
        int mod=1000000007;
        
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        
        for(int ones=1;ones<=n;ones++){
            for(int zeros=1;zeros<=ones;zeros++){
                int placeOne=dp[ones-1][zeros];
                int placeZero=dp[ones][zeros-1];
                
                dp[ones][zeros]=(placeOne+placeZero)%mod;
            }
        }
        
        return dp[n][n];
    }
}
