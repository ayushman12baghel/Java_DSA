class Solution {
    public int minCost(int[][] grid) {
        // code here
        int n=grid.length;
        int dp[][]=new int[grid.length][4];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        
        return solve(grid,0,3,dp);
    }
    
    public int solve(int grid[][],int index,int last,int dp[][]){
        if(index>=grid.length){
            return 0;
        }
        
        if(dp[index][last]!=-1){
            return dp[index][last];
        }
        
        int min=Integer.MAX_VALUE;
        
        for(int choice=0;choice<3;choice++){
            if(choice!=last){
                int current=grid[index][choice]+solve(grid,index+1,choice,dp);
                min=Math.min(min,current);
            }
        }
        
        return dp[index][last]=min;
    }
}
