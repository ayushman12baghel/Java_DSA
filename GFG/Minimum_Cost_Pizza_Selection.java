//Approach 1 Tabulation O(x)
class Solution {
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        int dp[]=new int[x+1];
        
        for(int i=1;i<=x;i++){
            int costS=dp[Math.max(0,i-s)]+cs;
            int costM=dp[Math.max(0,i-m)]+cm;
            int costL=dp[Math.max(0,i-l)]+cl;
            
            dp[i]=Math.min(costS,Math.min(costM,costL));
        }
        
        return dp[x];
    }
}

//Approach 2 Memoisation O(x)
class Solution {
    public int minimumCost(int x, int s, int m, int l, int cs, int cm, int cl) {
        int dp[]=new int[x+1];
        Arrays.fill(dp,-1);
        
        return solve(x,s,m,l,cs,cm,cl,dp);
    }
    
    public int solve(int x,int s,int m,int l,int cs,int cm,int cl,int dp[]){
        if(x<=0){
            return 0;
        }
        
        if(dp[x]!=-1){
            return dp[x];
        }
        
        int first=cs+solve(x-s,s,m,l,cs,cm,cl,dp);
        int second=cm+solve(x-m,s,m,l,cs,cm,cl,dp);
        int third=cl+solve(x-l,s,m,l,cs,cm,cl,dp);
        
        return dp[x]=Math.min(first,Math.min(second,third));
    }
}
