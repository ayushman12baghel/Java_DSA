//Approach 1 Memoisation O(n*length)
class Solution {
    int mod=1000000007;
    public int countSubsequences(String s, int n) {
        int length=s.length();
        int dp[][]=new int[length+1][n+1];
        
        dp[n][0]=1;
        
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<n;j++){
                int take=0;
                int digit=s.charAt(i)-'0';
                take=dp[i+1][(j*10+digit)%n];
                int skip=dp[i+1][j];
                
                dp[i][j]=(take+skip)%mod;
            }
        }
        
        return dp[0][0]-1;
    }
    
    public int solve(String s,int index,int remainder,int n,int dp[][]){
        if(index>=s.length()){
            return remainder==0?1:0;
        }
        
        if(dp[index][remainder]!=-1){
            return dp[index][remainder];
        }
        
        int take=0;
        int digit=s.charAt(index)-'0';
        take=solve(s,index+1,(remainder*10+digit)%n,n,dp);
        
        int skip=solve(s,index+1,remainder,n,dp);
        
        return dp[index][remainder]=(take+skip)%mod;
    }
}

//Approach 2 Tabulation O(n*length)
class Solution {
    int mod=1000000007;
    public int countSubsequences(String s, int n) {
        int length=s.length();
        int dp[][]=new int[length+1][n+1];
        
        dp[length][0]=1;
        
        for(int i=length-1;i>=0;i--){
            for(int j=0;j<n;j++){
                int take=0;
                int digit=s.charAt(i)-'0';
                take=dp[i+1][(j*10+digit)%n];
                int skip=dp[i+1][j];
                
                dp[i][j]=(take+skip)%mod;
            }
        }
        
        return dp[0][0]-1;
    }
}

//Approach 3 Space Optimised 
class Solution {
    int mod=1000000007;
    public int countSubsequences(String s, int n) {
        int length=s.length();
        int dp[]=new int[n+1];
        
        dp[0]=1;
        
        for(int i=length-1;i>=0;i--){
            int curr[]=new int[n+1];
            for(int j=0;j<n;j++){
                int take=0;
                int digit=s.charAt(i)-'0';
                take=dp[(j*10+digit)%n];
                int skip=dp[j];
                
                curr[j]=(take+skip)%mod;
            }
            
            dp=curr;
        }
        
        return dp[0]-1;
    }
}
