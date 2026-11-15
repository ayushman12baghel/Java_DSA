//Approach 1 Brute Force Recursion O(n^2) T.L.E
class Solution {
    int mod=1000000007;
    public int numOfSubarrays(int[] nums) {
        int n=nums.length;

        int ans=0;

        for(int i=n-1;i>=0;i--){
            int count[]=solve(nums,i);
            ans=(ans+count[1])%mod;
        }

        return ans;
    }

    public int[] solve(int nums[],int index){
        if(index>=nums.length){
            return new int[]{0,0};
        }

        int next[]=solve(nums,index+1);
        int currentEven=0;
        int currentOdd=0;
        
        if(nums[index]%2==0){
            currentEven=(1+next[0])%mod;
            currentOdd=next[1];
        }else{
            currentOdd=(1+next[0])%mod;
            currentEven=next[1];
        }

        return new int[]{currentEven,currentOdd};
    }
}

//Approach 2 Memoisation O(n)
class Solution {
    int mod=1000000007;
    public int numOfSubarrays(int[] nums) {
        int n=nums.length;

        int ans=0;
        int dp[][]=new int[n][];

        for(int i=n-1;i>=0;i--){
            int count[]=solve(nums,i,dp);
            ans=(ans+count[1])%mod;
        }

        return ans;
    }

    public int[] solve(int nums[],int index,int dp[][]){
        if(index>=nums.length){
            return new int[]{0,0};
        }

        if(dp[index]!=null){
            return dp[index];
        }

        int next[]=solve(nums,index+1,dp);
        int currentEven=0;
        int currentOdd=0;
        
        if(nums[index]%2==0){
            currentEven=(1+next[0])%mod;
            currentOdd=next[1];
        }else{
            currentOdd=(1+next[0])%mod;
            currentEven=next[1];
        }

        return dp[index]=new int[]{currentEven,currentOdd};
    }
}

//Approach 3 O(n) Tabulation
class Solution {
    int mod=1000000007;
    public int numOfSubarrays(int[] nums) {
        int n=nums.length;

        int dp[][]=new int[n+1][2];
        int ans=0;

        for(int i=n-1;i>=0;i--){
            if(nums[i]%2==0){
                dp[i][0]=(1+dp[i+1][0])%mod;
                dp[i][1]=dp[i+1][1];
            }else{
                dp[i][1]=(1+dp[i+1][0])%mod;
                dp[i][0]=dp[i+1][1];
            }

            ans=(ans+dp[i][1])%mod;
        }

        return ans;
    }
}

//Approach 4 O(n) Without Space 
class Solution {
    int mod=1000000007;
    public int numOfSubarrays(int[] nums) {
        int n=nums.length;

        int odd=0;
        int even=0;
        int ans=0;

        for(int i=n-1;i>=0;i--){
            int newOdd;
            int newEven;
            if(nums[i]%2==0){
                newEven=(1+even)%mod;
                newOdd=odd;
            }else{
                newOdd=(1+even)%mod;
                newEven=odd;
            }

            ans=(ans+newOdd)%mod;
            odd=newOdd;
            even=newEven;
        }

        return ans;
    }
}
