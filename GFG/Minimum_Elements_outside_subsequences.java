class Solution {
    public int minCount(int[] nums) {
        int n=nums.length;
        
        int dp[][][]=new int[n][n+1][n+1];
        
        for(int plane[][]:dp){
            for(int row[]:plane){
                Arrays.fill(row,-1);
            }
        }
        
        return n-solve(nums,0,-1,-1,dp);
    }
    
    public int solve(int nums[],int index,int prevInc,int prevDec,int dp[][][]){
        if(index>=nums.length){
            return 0;
        }
        
        if(dp[index][prevInc+1][prevDec+1]!=-1){
            return dp[index][prevInc+1][prevDec+1];
        }
        
        int take1=0;
        int take2=0;
        int skip=0;
        
        if(prevInc==-1 || nums[index]>nums[prevInc]){
            take1=1+solve(nums,index+1,index,prevDec,dp);
        }
        
        if(prevDec==-1 || nums[index]<nums[prevDec]){
            take2=1+solve(nums,index+1,prevInc,index,dp);
        }
        
        skip=solve(nums,index+1,prevInc,prevDec,dp);
        
        return dp[index][prevInc+1][prevDec+1]=Math.max(skip,Math.max(take1,take2));
    }
}
