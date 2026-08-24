//Approach 1 Memoisation O(n)
class Solution {
    int n;
    int dp[];
    public int stoneGameVIII(int[] stones) {
        n=stones.length;

        int prefix[]=new int[n];
        prefix[0]=stones[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+stones[i];
        }

        dp=new int[n];
        Arrays.fill(dp,Integer.MIN_VALUE);

        return solve(1,prefix);
    }

    public int solve(int i,int prefix[]){
        if(i==n-1){
            return prefix[i];
        }

        if(dp[i]!=Integer.MIN_VALUE){
            return dp[i];
        }

        int take=prefix[i]-solve(i+1,prefix);
        int skip=solve(i+1,prefix);

        return dp[i]=Math.max(take,skip);
    }
}

//Approach 2 Tabylation O(n)
class Solution {
    public int stoneGameVIII(int[] stones) {
        int n=stones.length;

        int prefix[]=new int[n];
        prefix[0]=stones[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+stones[i];
        }

        int dp[]=new int[n];
        dp[n-1]=prefix[n-1];

        for(int i=n-2;i>=1;i--){
            int take=prefix[i]-dp[i+1];
            int skip=dp[i+1];

            dp[i]=Math.max(take,skip);
        }

        return dp[1];
    }
}
