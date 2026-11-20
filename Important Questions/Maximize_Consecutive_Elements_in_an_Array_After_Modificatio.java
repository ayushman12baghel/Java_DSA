//Approach1 Memoisation O(n^maxValue)
class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int dp[][][]=new int[nums.length][2][100001];

        for(int plane[][]:dp){
            for(int row[]:plane){
                Arrays.fill(row,-1);
            }
        }

        return solve(nums,0,false,0,dp);
    }

    public int solve(int nums[],int index,boolean lastTaken,int prevValue,int dp[][][]){
        if(index>=nums.length){
            return 0;
        }
        
        int value=lastTaken?1:0;

        if(dp[index][value][prevValue]!=-1){
            return dp[index][value][prevValue];
        }

        int takeSame=0;
        int takeInc=0;
        int skip=solve(nums,index+1,lastTaken,prevValue,dp);
        
        if(lastTaken==false || nums[index]==prevValue+1){
            takeSame=1+solve(nums,index+1,true,nums[index],dp);
        }

        if(lastTaken==false || nums[index]+1==prevValue+1){
            takeInc=1+solve(nums,index+1,true,nums[index]+1,dp);
        }

        return dp[index][value][prevValue]=Math.max(skip,Math.max(takeSame,takeInc));
    }
}
//Approach 2 Tabulation O(nlogn)
class Solution {
    public int maxSelectedElements(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);

        int[][] dp = new int[n][2];
        dp[0][0] = 1;
        dp[0][1] = 1;

        int ans = 1;

        for (int i = 1; i < n; i++) {
            int diff = nums[i] - nums[i - 1];

            if (diff == 0) {
                dp[i][0] = dp[i - 1][0];
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + 1);
            } else if (diff == 1) {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0] + 1);
                dp[i][1] = dp[i - 1][1] + 1;
            } else if (diff == 2) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = 1;
            } else {
                dp[i][0] = 1;
                dp[i][1] = 1;
            }

            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }

        return ans;
    }
}
