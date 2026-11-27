//Approach 1 Using Memoisation O(n*budget)
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length;

        int copies[]=new int[n];
        int minPrice=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            minPrice=Math.min(minPrice,items[i][1]);
            int copy=0;

            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }

                if(items[j][0]%items[i][0]==0){
                    copy++;
                }
            }

            copies[i]=copy;
        }

        int dp[][]=new int[n][budget+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }

        return solve(items,budget,minPrice,copies,0,dp);
    }

    public int solve(int items[][],int budget,int minPrice,int copies[],int index,int dp[][]){
        if(index>=items.length){
            return budget/minPrice;
        }

        if(dp[index][budget]!=-1){
            return dp[index][budget];
        }

        int take=0;
        int skip=solve(items,budget,minPrice,copies,index+1,dp);
        int price=items[index][1];

        if(price<=budget){
            take=1+copies[index]+solve(items,budget-price,minPrice,copies,index+1,dp);
        }

        return dp[index][budget]=Math.max(take,skip);
    }
}

//Approach 2 Tabulation 
class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length;

        int copies[]=new int[n];
        int minPrice=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            minPrice=Math.min(minPrice,items[i][1]);
            int copy=0;

            for(int j=0;j<n;j++){
                if(i==j){
                    continue;
                }

                if(items[j][0]%items[i][0]==0){
                    copy++;
                }
            }

            copies[i]=copy;
        }

        int dp[][]=new int[n+1][budget+1];

        for(int i=0;i<=budget;i++){
            dp[n][i]=i/minPrice;
        }

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=budget;j++){
                int take=0;
                int skip=dp[i+1][j];
                int price=items[i][1];

                if(price<=j){
                    take=1+copies[i]+dp[i+1][j-price];
                }

                dp[i][j]=Math.max(take,skip);
            }
        }

        return dp[0][budget];
    }
}
