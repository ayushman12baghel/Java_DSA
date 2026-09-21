//Approach 1 Memoisation O(n^2)
class Solution {
    public int minPathSum(ArrayList<ArrayList<Integer>> triangle) {
        int n=triangle.size();
        
        int dp[][]=new int[n][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        
        return solve(triangle,0,0,dp);
    }
    
    public int solve(ArrayList<ArrayList<Integer>> triangle,int i,int j,int dp[][]){
        if(i>=triangle.size()){
            return 0;
        }
        
        if(j>=triangle.get(i).size()){
            return Integer.MAX_VALUE;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int option1=triangle.get(i).get(j)+solve(triangle,i+1,j,dp);
        int option2=triangle.get(i).get(j)+solve(triangle,i+1,j+1,dp);
        
        return dp[i][j]=Math.min(option1,option2);
    }
}

//Approach  2 Tabulation O(n^2)
class Solution {
    public int minPathSum(ArrayList<ArrayList<Integer>> triangle) {
        int n=triangle.size();
        
        int dp[][]=new int[n+1][n+1];
        for(int i=0;i<n;i++){
            dp[n-1][i]=triangle.get(n-1).get(i);
        }
        
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                int option1=triangle.get(i).get(j)+dp[i+1][j];
                int option2=triangle.get(i).get(j)+dp[i+1][j+1];
                
                dp[i][j]=Math.min(option1,option2);
            }
        }
        
        return dp[0][0];
    }
}
