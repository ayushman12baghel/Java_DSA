//Approach 1 Using Recursion+Memoisation O(n*totalSum*Count)
class Solution {
    public ArrayList<ArrayList<Integer>> equalPartition(int[] nums) {
        int n=nums.length;
        
        int totalSum=0;
        int posSum=0;
        int negSum=0;
        
        for(int num:nums){
            totalSum+=num;
            if(num>=0){
                posSum+=num;
            }else{
                negSum+=Math.abs(num);
            }
        }
        
        if(totalSum%2!=0){
            return new ArrayList<>();
        }
        
        int targetSum=totalSum/2;
        int targetCount=n/2;
        
        int offset=negSum;
        int sumRange=posSum+offset;
        
        Boolean dp[][][]=new Boolean[n][targetCount+1][sumRange+1];
        solve(nums,0,0,0,targetCount,targetSum,offset,dp);
        
        ArrayList<Integer> subset1=new ArrayList<>();
        boolean used[]=new boolean[n];
        
        int currentSum=0;
        int currentCount=0;
        
        for(int i=0;i<n;i++){
            if(currentCount<targetCount){
                int nextSum=currentSum+nums[i];
                
                if(solve(nums,i+1,currentCount+1,nextSum,targetCount,targetSum,offset,dp)){
                    used[i]=true;
                    subset1.add(nums[i]);
                    currentSum=nextSum;
                    currentCount+=1;
                }
            }
        }
        
        ArrayList<Integer> subset2=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!used[i]){
                subset2.add(nums[i]);
            }
        }
        
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ans.add(subset1);
        ans.add(subset2);
        
        return ans;
    }
    
    public boolean solve(int nums[],int index,int currentCount,int currentSum,int targetCount,int targetSum,int offset,Boolean dp[][][]){
        if(currentCount==targetCount){
            return currentSum==targetSum;
        }
        
        if(index>=nums.length){
            return false;
        }
        
        int mappedSum=currentSum+offset;
        if(dp[index][currentCount][mappedSum]!=null){
            return dp[index][currentCount][mappedSum];
        }
        
        boolean take=solve(nums,index+1,currentCount+1,currentSum+nums[index],targetCount,targetSum,offset,dp);
        
        if(take){
            return dp[index][currentCount][mappedSum]=true;
        }
        
        boolean skip=solve(nums,index+1,currentCount,currentSum,targetCount,targetSum,offset,dp);
        
        return dp[index][currentCount][mappedSum]=skip;
    }
}

//Approach 2 Tabulation 
class Solution {
    public ArrayList<ArrayList<Integer>> equalPartition(int[] nums) {
        int n=nums.length;
        
        int totalSum=0;
        int posSum=0;
        int negSum=0;
        
        for(int num:nums){
            totalSum+=num;
            if(num>=0){
                posSum+=num;
            }else{
                negSum+=Math.abs(num);
            }
        }
        
        if(totalSum%2!=0){
            return new ArrayList<>();
        }
        
        int targetSum=totalSum/2;
        int targetCount=n/2;
        
        int offset=negSum;
        int sumRange=posSum+offset;
        
        boolean dp[][][]=new boolean[n+1][targetCount+1][sumRange+1];
        
        dp[n][targetCount][targetSum+offset]=true;
        
        for(int i=n-1;i>=0;i--){
            for(int c=targetCount;c>=0;c--){
                for(int sum=0;sum<=sumRange;sum++){
                    boolean skip=dp[i+1][c][sum];
                    
                    boolean take=false;
                    int nextSum=sum+nums[i];
                    if(c+1<=targetCount && nextSum>=0 && nextSum<=sumRange){
                        take=dp[i+1][c+1][nextSum];
                    }
                    
                    dp[i][c][sum]=take || skip;
                }
            }
        }
        
        
        ArrayList<Integer> subset1=new ArrayList<>();
        boolean used[]=new boolean[n];
        
        int currentSum=0;
        int currentCount=0;
        
        for(int i=0;i<n;i++){
            if(currentCount<targetCount){
                int nextSum=currentSum+nums[i];
                int mappedSum=nextSum+offset;
                
                if(mappedSum<=sumRange && mappedSum>=0 && dp[i+1][currentCount+1][mappedSum]){
                    used[i]=true;
                    subset1.add(nums[i]);
                    currentSum=nextSum;
                    currentCount+=1;
                }
            }
        }
        
        ArrayList<Integer> subset2=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!used[i]){
                subset2.add(nums[i]);
            }
        }
        
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        ans.add(subset1);
        ans.add(subset2);
        
        return ans;
    }
}
