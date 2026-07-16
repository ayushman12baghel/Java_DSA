//Approach 1 O(n*sum) Memoisation 
class Solution {
    public int countWays(int n, int sum) {
        int dp[][]=new int[n][sum+1];
        
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        
        int ans=solve(0,sum,dp,n);
        
        return ans==0?-1:ans;
    }
    
    public int solve(int index,int sum,int dp[][],int n){
        if(index>=n){
            return sum==0?1:0;
        }
        if(sum<=0){
            return 0;
        }
        
        if(dp[index][sum]!=-1){
            return dp[index][sum];
        }
        int count=0;
        for(int i=0;i<=9;i++){
            count+=solve(index+1,sum-i,dp,n);
        }
        
        return dp[index][sum]=count;
    }
};




//Approach 2 O(n*Sum)
class Solution {
    public int countWays(int n, int sum) {
        int dp[][]=new int[n+1][sum+1];
        
        dp[n][0]=1;
        
        for(int i=n-1;i>=0;i--){
            for(int j=sum;j>=0;j--){
                int count=0;
                int start=(i==0?1:0);
                
                for(int k=start;k<=9 && j-k>=0;k++){
                    count+=dp[i+1][j-k];
                }
                
                dp[i][j]=count;
            }
        }
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=sum;j++){
                System.out.print(dp[i][j]+" ");
            }
            
            System.out.println();
        }
        
        return dp[0][sum]==0?-1:dp[0][sum];
    }
};



