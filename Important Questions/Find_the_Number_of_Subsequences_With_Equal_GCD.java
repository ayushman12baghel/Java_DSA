import java.util.*;

//Approach 1 O(n*gcd1*gcd2)
class Solution {
    int mod=1000000007;
    public int subsequencePairCount(int[] nums) {
        int dp[][][]=new int[nums.length][201][201];
        for(int plane[][]:dp){
            for(int row[]:plane){
                Arrays.fill(row,-1);
            }
        }

        return solve(nums,0,0,0,dp)-1;
    }

    public int solve(int nums[],int index,int gcd1,int gcd2,int dp[][][]){
        if(index>=nums.length){
            return gcd1==gcd2?1:0;
        }

        if(dp[index][gcd1][gcd2]!=-1){
            return dp[index][gcd1][gcd2];
        }

        int skip=solve(nums,index+1,gcd1,gcd2,dp);
        int take1=solve(nums,index+1,gcd(nums[index],gcd1),gcd2,dp);
        int take2=solve(nums,index+1,gcd1,gcd(nums[index],gcd2),dp);
        
        return dp[index][gcd1][gcd2]=((skip+take1)%mod+take2)%mod;
    }

    public int gcd(int a,int b){
        if(a==0){
            return b;
        }

        return gcd(b%a,a);
    }
}

//Approach 2 Tabulation O(n*max*max)
class Solution {
    int mod=1000000007;
    public int subsequencePairCount(int[] nums) {
        int n=nums.length;

        int max=0;
        for(int num:nums){
            max=Math.max(max,num);
        }

        int dp[][][]=new int[n+1][max+1][max+1];
        for(int i=0;i<=max;i++){
            dp[n][i][i]=1;
        }

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=max;j++){
                for(int k=0;k<=max;k++){
                    int skip=dp[i+1][j][k];
                    int take1=dp[i+1][gcd(j,nums[i])][k];
                    int take2=dp[i+1][j][gcd(k,nums[i])];

                    dp[i][j][k]=((skip+take1)%mod+take2)%mod;
                }
            }
        }

        return dp[0][0][0]-1;
    }

    public int gcd(int a,int b){
        if(a==0){
            return b;
        }

        return gcd(b%a,a);
    }
}

//More Optimised 
class Solution {
    int mod=1000000007;
    public int subsequencePairCount(int[] nums) {
        int n=nums.length;

        int max=0;
        for(int num:nums){
            max=Math.max(max,num);
        }

        int dp[][][]=new int[n+1][max+1][max+1];
        for(int i=0;i<=max;i++){
            dp[n][i][i]=1;
        }

        for(int i=n-1;i>=0;i--){
            int nextGcd[]=new int[max+1];
            for(int j=0;j<=max;j++){
                nextGcd[j]=gcd(j,nums[i]);
            }

            for(int j=0;j<=max;j++){
                for(int k=0;k<=max;k++){
                    int skip=dp[i+1][j][k];
                    int take1=dp[i+1][nextGcd[j]][k];
                    int take2=dp[i+1][j][nextGcd[k]];

                    dp[i][j][k]=((skip+take1)%mod+take2)%mod;
                }
            }
        }

        return dp[0][0][0]-1;
    }

    public int gcd(int a,int b){
        if(a==0){
            return b;
        }

        return gcd(b%a,a);
    }
}

//Space Optimised Bottom Up
class Solution {
    int mod=1000000007;
    public int subsequencePairCount(int[] nums) {
        int n=nums.length;

        int max=0;
        for(int num:nums){
            max=Math.max(max,num);
        }

        int prev[][]=new int[max+1][max+1];
        for(int i=0;i<=max;i++){
            prev[i][i]=1;
        }

        for(int i=n-1;i>=0;i--){
            int current[][]=new int[max+1][max+1];
            int nextGcd[]=new int[max+1];
            for(int j=0;j<=max;j++){
                nextGcd[j]=gcd(j,nums[i]);
            }

            for(int j=0;j<=max;j++){
                for(int k=0;k<=max;k++){
                    int skip=prev[j][k];
                    int take1=prev[nextGcd[j]][k];
                    int take2=prev[j][nextGcd[k]];

                    current[j][k]=((skip+take1)%mod+take2)%mod;
                }
            }

            prev=current;
        }

        return prev[0][0]-1;
    }

    public int gcd(int a,int b){
        if(a==0){
            return b;
        }

        return gcd(b%a,a);
    }
}
