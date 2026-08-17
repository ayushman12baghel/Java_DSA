//Approach O(n^3)
class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;

        int prefix[]=new int[n+1];
        for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1]+stoneValue[i-1];
        }

        int dp[][]=new int[n][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }

        return solve(stoneValue,0,n-1,prefix,dp);
    }

    public int solve(int nums[],int left,int right,int prefix[],int dp[][]){
        if(left==right){
            return 0;
        }

        if(dp[left][right]!=-1){
            return dp[left][right];
        }

        int maxScore=0;

        for(int i=left;i<right;i++){
            int leftSum=prefix[i+1]-prefix[left];
            int rightSum=prefix[right+1]-prefix[i+1];

            if(leftSum<rightSum){
                maxScore=Math.max(maxScore,leftSum+solve(nums,left,i,prefix,dp));
            }else if(leftSum>rightSum){
                maxScore=Math.max(maxScore,rightSum+solve(nums,i+1,right,prefix,dp));
            }else{
                int option1=solve(nums,left,i,prefix,dp);
                int option2=solve(nums,i+1,right,prefix,dp);
                maxScore=Math.max(maxScore,leftSum+Math.max(option1,option2));
            }
        }

        return dp[left][right]=maxScore;
    }
}
